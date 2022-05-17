apply(plugin = "com.jraska.module.graph.assertion")

configure<com.jraska.module.graph.assertion.GraphRulesExtension> {
    maxHeight = 4
    allowed = arrayOf(
        ":android-app:app -> :android-app:.*:impl",
        ":android-app:.*:demo -> :android-app:.*:impl",
        ":android-app:.* -> :android-app:core.*",
        ":android-app:.*:impl -> :android-app:.*:api",
    )
    restricted = arrayOf(
        ":android-app:.*:impl -X> :android-app:.*:impl",
    )
}
