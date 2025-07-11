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

## 🤖 Telegram Bot

Для получения сообщений в Telegram:

1. Найди бота: [@Ramil192Bot](https://t.me/Ramil192Bot)
2. Отправь ему сообщение в формате:
3. /start <твой_username>
4. Бот привяжет твой Telegram-аккаунт к пользователю в системе.
4. Теперь каждое сообщение, отправленное через REST API (`POST /messages`), будет доставлено в Telegram в формате:
---

## ⚙️ Установка

```bash
git clone https://github.com/RamilNazmiev192/telegram-message-forwarder.git
cd telegram-message-forwarder
./gradlew build
docker-compose up --build

