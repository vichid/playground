apply(plugin = "com.jraska.module.graph.assertion")

configure<com.jraska.module.graph.assertion.GraphRulesExtension> {
    maxHeight = 4
    allowed = arrayOf(
        ":app -> :.*:impl",
        ":.*:demo -> :.*:impl",
        ":.* -> :core.*",
        ":.* -> :lib.*",
        ":.*:impl -> :.*:api",
    )
    restricted = arrayOf(
        ":data-.* -X> :ui-.*",
        ":.*:impl -X> :.*:impl",
    )
}
