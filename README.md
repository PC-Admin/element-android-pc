# Perthchat App

The Perthchat App is a re-branding of the popular [Element Android](https://github.com/vector-im/element-android) client.

Perthchat.org is a Matrix service run for Perth, Western Australia. Started in 2017 it’s one of the larger Matrix instances in Australia. This service was created to provide a secure, open source and ad-free messaging experience. Matrix servers interconnect allowing users to make friends and join rooms with people from all over the world.

## Issues

For bug reports feel free to create an issue on [our issue tracker](https://gitlab.com/perthchat.org/element-android-perthchat/-/issues). Keep in mind though this is nearly exactly the same code as the upstream [Element Android](https://github.com/vector-im/element-android) client and the bug you're experiencing might already be documented there.
=======
Build of develop branch: [![GitHub Action](https://github.com/vector-im/element-android/actions/workflows/build.yml/badge.svg?query=branch%3Adevelop)](https://github.com/vector-im/element-android/actions/workflows/build.yml?query=branch%3Adevelop) Nightly test status: [![allScreensTest](https://github.com/vector-im/element-android/actions/workflows/nightly.yml/badge.svg)](https://github.com/vector-im/element-android/actions/workflows/nightly.yml)


# New Android SDK

Element is based on a new Android SDK fully written in Kotlin (like Element). In order to make the early development as fast as possible, Element and the new SDK currently share the same git repository.

At each Element release, the SDK module is copied to a dedicated repository: https://github.com/matrix-org/matrix-android-sdk2. That way, third party apps can add a regular gradle dependency to use it. So more details on how to do that here: https://github.com/matrix-org/matrix-android-sdk2.

# Roadmap

The version 1.0.0 of Element still misses some features which was previously included in Riot-Android.
The team will work to add them on a regular basis.

# Releases to app stores

There is some delay between when a release is created and when it appears in the app stores (Google Play Store and F-Droid). Here are some of the reasons:

* Not all versioned releases that appear on GitHub are considered stable. Each release is first considered beta: this continues for at least two days. If the release is stable (no serious issues or crashes are reported), then it is released as a production release in Google Play Store, and a request is sent to F-Droid too.
* Each release on the Google Play Store undergoes review by Google before it comes out. This can take an unpredictable amount of time. In some cases it has taken several weeks.
* In order for F-Droid to guarantee that the app you receive exactly matches the public source code, they build releases themselves. When a release is considered stable, Element staff inform the F-Droid maintainers and it is added to the build queue. Depending on the load on F-Droid's infrastructure, it can take some time for releases to be built. This always takes at least 24 hours, and can take several days.

If you would like to receive releases more quickly (bearing in mind that they may not be stable) you have a number of options:

1. [Sign up to receive beta releases](https://play.google.com/apps/testing/im.vector.app) via the Google Play Store.
2. Install a [release APK](https://github.com/vector-im/element-android/releases) directly - download the relevant .apk file and allow installing from untrusted sources in your device settings.  Note: these releases are the Google Play version, which depend on some Google services.  If you prefer to avoid that, try the latest dev builds, and choose the F-Droid version.
3. If you're really brave, install the [very latest dev build](https://github.com/vector-im/element-android/actions/workflows/build.yml?query=branch%3Adevelop) - pick a build, then click on `Summary` to download the APKs from there: `vector-Fdroid-debug` and `vector-Gplay-debug` contains the APK for the desired store. Each file contains 5 APKs. 4 APKs for every supported specific architecture of device. In doubt you can install the `universal` APK.

## Contributing

Please refer to [CONTRIBUTING.md](./CONTRIBUTING.md) if you want to contribute on Matrix Android projects!

Come chat with the community in the dedicated Matrix [room](https://matrix.to/#/#element-android:matrix.org).

Also [this documentation](./docs/_developer_onboarding.md) can hopefully help developers to start working on the project.

## Triaging issues

Issues are triaged by community members and the Android App Team, following the [triage process](https://github.com/vector-im/element-meta/wiki/Triage-process).

We use [issue labels](https://github.com/vector-im/element-meta/wiki/Issue-labelling) to sort all incoming issues.
