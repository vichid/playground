<p align="center">
  <a href="https://github.com/vichid/playground/actions/workflows/build_main.yml" target=_blank>
    <img alt="GitHub Workflow Status (branch)" src="https://img.shields.io/github/workflow/status/vichid/playground/build_main/main?logo=github"/>
  </a>
  &nbsp;
  <a href="https://github.com/vichid/playground/blob/main/LICENSE.md" target=_blank>
    <img alt="Apache 2.0 license" src="https://img.shields.io/github/license/vichid/playground"/>
  </a>
</p>

Playground
====

An app where I play with everything android related with a focus on scalability and performance.

## Features & Technologies

- Kotlin
- Modular compose navigation
- Dagger/Anvil + Code Generators (ContributesApi, ContributesViewModel)
- Custom gradle plugins for each type of module (jvm, android library, compose, etc.)
- Detekt + Custom detekt rules
- Macrobenchmarks + baseline profiles
- Module generator that follows architecture 
- Structured modularization validated with [Module Graph Assert](https://github.com/jraska/modules-graph-assert)
- Version catalogs with renovatebot running
