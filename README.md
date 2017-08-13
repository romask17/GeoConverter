# GeoConverter [![Build Status](https://travis-ci.org/romask17/GeoConverter.svg?branch=master)](https://travis-ci.org/romask17/GeoConverter)

Приложение представляет собой микросервис, представляющий из себя простой провайдер API для прямого и обратного геокодирования (из координат в адрес и наоборот). Микросервис предоставляет RESTful API с использования JSON формата данных. 

Для работы используется API Яндекс.Карт (https://tech.yandex.ru/maps/geocoder/).

## Используемые технологии и фреймворки:

### Инфраструктурные сервисы:
 * Spring Boot
 * Spring Cloud (Netflix OSS)
 * Spring Cloud Config - горизонтально масштабируемое хранилище конфигураций
 * API Gateway — Zuul
 * Service discovery (Eureka)
 * Circuit Breaker (Hystrix)
 * Feign - http-клиент
 * HystrixDashboard - панель мониторинга
 
### Автоматизация инфраструктуры:
  * Maven
  * TravisCI
  * Docker
  
## Результат работы:

```json
[
    {
        "addressLine": "Россия",
        "location": "Санкт-Петербург",
        "latitude": 59.939095,
        "longitude": 30.315868
    }
]
```
