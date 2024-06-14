# Use uma imagem base oficial do Kotlin
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo de construção do Gradle para o diretório de trabalho
COPY build/libs/*.jar app.jar

# Exponha a porta que o aplicativo Ktor usará
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use a imagem base do PostgreSQL
FROM postgres:latest

# Configurações adicionais, se necessário
# Exemplo: definir variáveis de ambiente para o PostgreSQL
ENV POSTGRES_USER user
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB clarimail

# Copie scripts SQL para inicialização do banco de dados, se aplicável
COPY init.sql /docker-entrypoint-initdb.d/
