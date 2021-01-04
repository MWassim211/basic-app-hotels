#!/usr/bin/env bash

echo $PATH
echo 'hello'
echo ${MONGO_INITDB_ROOT_PASSWORD}
echo $MONGO_INITDB_ROOT_PASSWORD
echo $MONGO_INITDB_ROOT_USERNAME
echo $MONGO_INITDB_HOST
echo $MONGO_INITDB_DATABASE

java -jar -Dspring.data.mongodb.username=${MONGO_INITDB_ROOT_USERNAME} -Dspring.data.mongodb.password=${MONGO_INITDB_ROOT_PASSWORD} -Dspring.data.mongodb.host=${MONGO_INITDB_HOST} -Dspring.data.mongodb.database=${MONGO_INITDB_DATABASE} /app/app-0.0.1-SNAPSHOT.jar
# java -jar /app/app-0.0.1-SNAPSHOT.jar