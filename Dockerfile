FROM maven:3.8.4-openjdk-17-slim as builder
WORKDIR /teatime
COPY src /usr/teatime/teatime-mgmt-backend/src
COPY pom.xml /usr/teatime/teatime-mgmt-backend
RUN mvn -f /usr/teatime/teatime-mgmt-backend/pom.xml clean package -DskipTests -Pproduction

FROM openjdk:17-jdk-oraclelinux7

ENV DB_URL=http://www.teatimesuplementos.com.br
ENV DB_USERNAME=username
ENV DB_PASSWORD=password
ENV AUTH_ISSUER=http://www.teatimesuplementos.com.br
ENV AUTH_AUDIENCE=audience
ENV AUTH_CLIENT_ID=client_id
ENV AUTH_CLIENT_SECRET=client_secret

COPY --from=builder /usr/teatime/teatime-mgmt-backend/target/teatime-mgmt-backend-0.0.1-SNAPSHOT.jar /usr/local/teatime-mgmt-backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/teatime-mgmt-backend.jar"]