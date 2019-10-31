#!/bin/bash
test $(curl localhost:8080/test/two) -eq 0