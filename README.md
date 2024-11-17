<div align="center">

<!-- <p><img src="https://github.com/CoinTrend/CoinTrend/blob/develop/metadata/en-US/images/icon.png" width="200"></p> -->

# Woodworker's Friend

### Lightweight Set of Woodworking Utilities

[![Android](https://img.shields.io/badge/Android-grey?logo=android&style=flat)](https://www.android.com/)
[![AndroidAPI](https://img.shields.io/badge/API-26%2B-859900.svg?style=flat)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-6c71c4.svg?logo=kotlin)](https://kotlinlang.org)
[![JetpackCompose](https://img.shields.io/badge/Jetpack%20Compose-1.7.5-b58900)](https://developer.android.com/jetpack/compose)
[![Release](https://badgen.net/github/release/my-waiwai/woodworkers-friend?color=dc322f)](https://github.com/my-waiwai/waiwai-android/releases)

</div>

 ----

Lightweight and fast set of utilities for Android dedicated to the needs of woodworkers.

## Features

- **Unit Conversion**: convert between common measurement units with customizable fractional inch calculations
- **Board Foot Calculator**: calculate and optionally save your board foot calculations
- **Janka Hardness**: a non-exhaustive database of Janka hardness values
- **Settings**: customize your in-app experience

### Lightweight
At this time, Woodworker's Friend does not require internet access, nor does it ask for it.

### Designed for Android
The User Interface has been designed by following the latest Google's Material Design guidelines and by using only native Android components and animations. The themes are based on the Solarized color palette which is designed to work well in a variety of lighting conditions.


## Technical Details

- **100% Jetpack Compose** 🚀

- **Material Design 3** 💎

- **Multimodule Clean Architecture** 🏛 as [davidepanidev](https://github.com/davidepanidev)'s [Clean Architecture Compose Concept](https://github.com/davidepanidev/android-multimodule-architecture-concepts/tree/clean-architecture-compose-concept) which consists of four separate modules:
  -  _app_: Android module that contains the Android Application component and all the framework specific configurations. It has visibility over all the other modules and defines the global dependency injection configurations.
  -  _presentation_: Android **MVVM**-based module. It contains the Android UI framework components (Activities, Composables, ViewModels...) and the related resources (e.g. images, strings...). This module just observes data coming from the undelying modules through Kotlin Flows and displays it. 
  -  _domain_: Kotlin module that contains platform-independent business logic, the entities (platform-independent business models), and the repository interfaces. It contains the `BaseAutomaticRefreshDataFlowUseCase` which handles the logic to refresh the persisted data when it becomes outdated.
  -  _data_: Android module that acts as the **Single-Source-Of-Truth** of the app. It contains repositories implementations, the Room entities for persistence, the data source API implementations and the corresponding API-specific models.

## Credits

### Contributors

- [Dave Wiard](https://github.com/davewiard)

### Libraries and References

- [CoinTrend](https://github.com/CoinTrend/CoinTrend): provided a very clean MVVM example to learn from

- [nicolashaan](https://github.com/nicolashaan): for the [Resultat](https://github.com/nicolashaan/resultat) library

- [olshevski](https://github.com/olshevski): for the [Compose Navigation Reimagined](https://github.com/olshevski/compose-navigation-reimagined) library

- [mxalbert1996](https://github.com/mxalbert1996): for the [Compose Shared Element](https://github.com/mxalbert1996/compose-shared-elements) library

- [vico](https://github.com/patrykandpatrick/vico): for the chart library

- [Solarized](https://ethanschoonover.com/solarized/): for the light and dark themes


## Support

Woodworker's Friend does not generate any revenue. If you wish to support the developers you can donate some sats at the Bitcoin address below:
