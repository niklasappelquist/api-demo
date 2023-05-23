#!/bin/bash
cd todo-app && ./gradlew build && docker build -t niklasappelquist/api-demo .
cd ../todo.worker && ./gradlew build && docker build -t niklasappelquist/api-worker .
cd .. && docker-compose up
