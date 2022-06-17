<p align="center">
  <a href="https://github.com/vichid/playground/actions/workflows/build_main.yml" target=_blank>
    <img alt="GitHub Workflow Status" src="https://github.com/vichid/playground/actions/workflows/build_main.yml/badge.svg"/>
  </a>
  &nbsp;
  <a href="https://github.com/vichid/playground/blob/main/LICENSE.md" target=_blank>
    <img alt="Apache 2.0 license" src="https://img.shields.io/github/license/vichid/playground"/>
  </a>
</p>

Playground
====

This is a personal pet project where I play with everything android related with a focus on scalability and performance.

## Features & Technologies

- Written in Kotlin
- Design system written in [Compose](https://developer.android.com/jetpack/compose)
- Modular compose navigation
- Dagger 2 + Anvil + Custom Anvil Code Generators (ContributesApi, ContributesViewModel)
- Custom gradle plugins with conventions for each type of module (plain jvm, android library, compose, etc.)
- Code analysis with [Detekt](https://github.com/detekt/detekt) + Custom Detekt rules module
- Macrobenchmarks + baseline profiles
- Module generator task that allows to generate architecture with repo standards
- Structured modularization validated with [Module Graph Assert](https://github.com/jraska/modules-graph-assert)
- Version catalogs with [renovatebot](https://github.com/renovatebot/renovate) running
- [Leak Canary](https://square.github.io/leakcanary/)
- Build health validated with [Gradle doctor](https://runningcode.github.io/gradle-doctor/) and [Dependency analysis](https://github.com/autonomousapps/dependency-analysis-android-gradle-plugin)
- Monitoring app/module size thanks to [Ruler](https://github.com/spotify/ruler)
- Avoiding manifest boilerplate thanks to [AutoManifest](https://github.com/GradleUp/auto-manifest)

