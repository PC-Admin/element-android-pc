/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.app.features.notifications

import org.matrix.android.sdk.api.pushrules.PushEvents
import org.matrix.android.sdk.api.pushrules.PushRuleService
import org.matrix.android.sdk.api.pushrules.getActions
import org.matrix.android.sdk.api.session.Session
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PushRuleTriggerListener @Inject constructor(
        private val resolver: NotifiableEventResolver,
        private val notificationDrawerManager: NotificationDrawerManager
) : PushRuleService.PushRuleListener {

    private var session: Session? = null

    override fun onEvents(pushEvents: PushEvents) {
        session?.let { session ->
            val notifiableEvents = pushEvents.matchedEvents.mapNotNull { (event, pushRule) ->
                Timber.v("Push rule match for event ${event.eventId}")
                val action = pushRule.getActions().toNotificationAction()
                if (action.shouldNotify) {
                    resolver.resolveEvent(event, session, isNoisy = !action.soundName.isNullOrBlank())
                } else {
                    Timber.v("Matched push rule is set to not notify")
                    null
                }
            }

            notificationDrawerManager.updateEvents { queuedEvents ->
                notifiableEvents.forEach { notifiableEvent ->
                    queuedEvents.onNotifiableEventReceived(notifiableEvent)
                }
                queuedEvents.syncRoomEvents(roomsLeft = pushEvents.roomsLeft, roomsJoined = pushEvents.roomsJoined)
                queuedEvents.markRedacted(pushEvents.redactedEventIds)
            }
        } ?: Timber.e("Called without active session")
    }

    fun startWithSession(session: Session) {
        if (this.session != null) {
            stop()
        }
        this.session = session
        session.addPushRuleListener(this)
    }

    fun stop() {
        session?.removePushRuleListener(this)
        session = null
        notificationDrawerManager.clearAllEvents()
    }
}
