# Курсовая работа спринг

Приложение предоставляет сервер для обработки запросов перевода денег с карты на карту.

## Запуск
Для запуска приложения нужно склонировать репозиторий

Для запуска приложения необходимо выполнить команду `docker-compose up` в корневой папке проекта.
В docker compose 3 контейнера
Сервер dmitriynazarov/course-work (образ загружен на docker hub) доступен по ссылке `http://localhost:5500/`
База данных mongo порт 27017
mongo-express Администривная панель БД `http://localhost:8081/` login admin password pass

## Описание

При инициализации проекта если БД не создана , создается бд coursework и colection cards c данными

- "id", cardFromCVV:111, cardFromNumber: 1111111111111111, cardFromValidTill:"11/24", balans:100000
- "id", cardFromCVV:222, cardFromNumber: 2222222222222222, cardFromValidTill:"11/24", balans:100000
- "id", cardFromCVV:333, cardFromNumber: 3333333333333333, cardFromValidTill:"11/24", balans:100000
- "id", cardFromCVV:444, cardFromNumber: 4444444444444444, cardFromValidTill:"11/24", balans:100000
- "id", cardFromCVV:555, cardFromNumber: 5555555555555555, cardFromValidTill:"11/24", balans:100000
- "id", cardFromCVV:666, cardFromNumber: 6666666666666666, cardFromValidTill:"11/24", balans:100000

При запросе  с  https://serp-ya.github.io/card-transfer/ происходит валидация данных, при успешном прохождение создается colection transferCardS с данными
Пример:
{
_id: '6554da795e071f75cf3e7d86',
cardFromNumber: 1111111111111111,
cardToNumber: 2222222222222222,
amount: 1100,
date: ISODate('2023-11-15T14:49:29.155Z'),
commision: 11,
_class: 'ru.netology.coursework.model.ModelTransfer'
}

Все логи работы сервера записыватся в fike.log
