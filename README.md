# Arcmutate Kotlin Example

An example of one way in which the [Arcmutate Kotlin plugin](https://docs.arcmutate.com/docs/kotlin.html) can be configured for a gradle multi module project.

The actual code in the repo makes little sense, is not idiomatic kotlin, and is present purely to have something to mutate.

## Usage

To run pitest and aggregate the module results use

```bash
./gradlew pitestReportAggregate
```

Aggregated results will be written to

```bash
build/reports/pitest/
```

