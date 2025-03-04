@echo off

:: Перевіряємо наявність Maven Wrapper
if exist mvnw (
    echo Використовується Maven Wrapper...
    call mvnw clean package
) else (
    echo Використовується встановлений Maven...
    mvn clean package
)

:: Перевіряємо, чи створився jar файл
if exist target\gorygo-0.0.1-SNAPSHOT.jar (
    echo Запуск програми...
    java -jar target\gorygo-0.0.1-SNAPSHOT.jar
) else (
    echo Помилка: jar файл не знайдено!
    pause
    exit /b 1
)

pause
