apply(plugin = "com.jraska.module.graph.assertion")

configure<com.jraska.module.graph.assertion.GraphRulesExtension> {
    maxHeight = 4
    allowed = arrayOf(
        ":app -> :.*:wiring",
        ":.*:demo -> :.*:wiring",
        ":.* -> :core.*",
        ":.* -> :lib.*",
        ":.*:wiring -> :.*:impl",
        ":.*:impl -> :.*:api",
    )
    restricted = arrayOf(
        ":data-.* -X> :ui-.*",
        ":.*:impl -X> :.*:impl",
        ":.*:wiring -X> :.*:wiring",
    )
}
