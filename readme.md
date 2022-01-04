# Overview

Gradle test project with reports automatically published in React-based web page using
`docker-compose`

## How to Run

Run the command:

```
docker-compose up -d
# or
make start
```

## Regression tests

Tests can be easily updated or added, just add your java classes or make any changes with the codebase, run test container once more

```
docker start test
# or
make test
```

## Screenshot viewer

A container for browsing the screenshots taken durin test run. This gallery is available at `http://<HOST-IP>:8000`