FROM openjdk:18

LABEL Thomas="thomaskittlaus@gmail.com"

ADD backend/target/tepmplate.jar template.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -Dspring.data.mongodb.uri=$URI -jar /template.jar" ]
