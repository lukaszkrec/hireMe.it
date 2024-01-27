FROM ubuntu:latest
LABEL authors="Luke"

ENTRYPOINT ["top", "-b"]
