#!/usr/bin/env bash

# on s'assure d'être dans le bon répertoire
cd $(dirname ${0})

if [[ -z "${TAG}" ]]
then
  TAG=app/hotel:0.0.1
fi

docker build -t "${TAG}" .