class Constants {

    // the pitest kotlin plugin must be added as a dependency in more than one place
    // concentrating the plugins as constants here is one way to keep the versions in sync
    object Plugins {
        const val pitestKotlin = "com.groupcdg.pitest:pitest-kotlin-plugin:1.0.8"
        const val pitestBase = "com.groupcdg.arcmutate:base:1.1.2"
    }
}