docker-compose up -d 
docker ps
docker cp <CB_CODEBEAMER_ID>:/home/appuser/codebeamer/tomcat/webapps/ROOT/WEB-INF/lib/ ./codebeamer-sdk
gradlew jar
docker-compose down
docker-compose up -d
