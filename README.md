1. docker-compose -f docker-compose-no-customization.yml up -d 
2. docker ps
3. docker cp <CB_CODEBEAMER_ID>:/home/appuser/codebeamer/tomcat/webapps/ROOT/WEB-INF/lib/ ./codebeamer-sdk
4. docker-compose down
5. ./gradlew jar
6. docker-compose up -d
