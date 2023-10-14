# Используем официальный образ OpenJDK для Java 17
FROM openjdk:17-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл вашего приложения в контейнер
COPY target/*.jar app.jar

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "/app.jar"]

# Определяем имя образа
LABEL name=VTB-Spring-backend