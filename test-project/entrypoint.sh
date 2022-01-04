#! /bin/bash

sudo gradle clean test
sudo cp -r build/reports/tests/test/* /report