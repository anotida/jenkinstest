#!/bin/bash
test $(curl localhost:8765/test/two) -eq 0