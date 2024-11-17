FROM amd64/amazoncorretto:17
WORKDIR /app
COPY ./build/libs/agoda-0.0.1-SNAPSHOT.jar /app/agoda.jar
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "-Dspring.profiles.active=dev", "agoda.jar"]
