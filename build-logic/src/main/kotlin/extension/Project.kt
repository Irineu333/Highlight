package extension

import model.Config

val config = Config(
    version = Config.Version(
        major = 2,
        minor = 3,
        patch = 0,
        release = Config.Release.Definitive,
    ),
    android = Config.Android(
        compileSdk = 34,
        targetSdk = 34,
        minSdk = 21
    ),
    group = "com.neoutils.highlight",
)
