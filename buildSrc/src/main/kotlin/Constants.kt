class Constants {

    // the pitest kotlin plugin must be added as a dependency in more than one place
    // concentrating the plugins as constants here is one way to keep the versions in sync
    object Plugins {
        const val pitestKotlin = "com.arcmutate:pitest-kotlin-plugin:1.2.0"
        const val pitestBase = "com.arcmutate:base:1.3.0"
    }
}