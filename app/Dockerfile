FROM adoptopenjdk:11-jdk-hotspot-focal
Run mkdir /app
COPY target/app-0.0.1-SNAPSHOT.jar /app 
COPY deploy.sh /app
# ENTRYPOINT [ "java" , "-jar"  , " -Dspring.data.mongodb.username=`${MONGO_INITDB_ROOT_USERNAME}` -Dspring.data.mongodb.password=`${MONGO_INITDB_ROOT_PASSWORD}` -Dspring.data.mongodb.uri=`${MONGO_INITDB_URI}` /app/app-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT [ "java" , "-jar"  , "/app/app-0.0.1-SNAPSHOT.jar"]
CMD ["/app/deploy.sh", "sh"]