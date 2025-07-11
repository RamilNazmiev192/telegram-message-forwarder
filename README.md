# 📬 Telegram Message Forwarder

Spring Boot приложение, позволяющее пользователям отправлять сообщения через REST API и пересылать их в Telegram-бота.

## 🚀 Стек технологий

- Java 17
- Spring Boot 3
- Spring Security + JWT
- PostgreSQL + Liquibase
- TelegramBots API
- Swagger OpenAPI 3
- Docker + Docker Compose
- Gradle

## 📘 API-документация (Swagger UI)

После запуска проекта Swagger доступен по адресу:

🔗 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Через Swagger можно:
- Регистрировать и авторизовываться
- Отправлять сообщения
- Смотреть список сообщений
- Вставлять JWT токен через кнопку **Authorize**

---

## ⚙️ Установка

```bash
git clone https://github.com/RamilNazmiev192/telegram-message-forwarder.git
cd telegram-message-forwarder
./gradlew build
docker-compose up --build

