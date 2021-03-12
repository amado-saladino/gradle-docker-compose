# Overview

Gradle test project with reports automatically published in React-based web page using
`docker-compose`

## How to Run

Run the command `docker-compose up -d`

## Update tests

Tests can be easily updated or added, just add your java classes or make any changes with the codebase, run test container once more

`docker start gradlereact_test_1`

## Container name format

The above command might slightly differ depending on the directory name, the container for running the tests will have this format

`docker start $(DIR_NAME)_$(SERVICE_NAME)_1`

it will rerun the tests and create the report, the report will automatically be copied to `output` folder where it is volumized to `public` folder in the other container which is charged of displaying the test result.

## Run the test

`make test`
