# GeoConverter [![Build Status](https://travis-ci.org/eaxdev/GeoConverter.svg?branch=master)](https://travis-ci.org/eaxdev/GeoConverter)

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
 * Hystrix Dashboard - панель мониторинга
 
### Автоматизация инфраструктуры:
  * Maven
  * TravisCI
  * Docker
  
## Запуск
* Установить `Docker` и `Docker Compose`
* Экспортировть переменную окружения `CONFIG_SERVICE_PASSWORD`

### Prod mode:

```sh
docker-compose up -d
```
В этом случае  все собранные образы через `travis`,  загружаются из центрального репозитория (Docker Hub), порты проброшены наружу докера только для API Gateway, Service Discovery, Monitoring и RabbitMQ management

### Dev mode:

```sh
mvn clean package
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up -d
```
В этом случае происходит сборка проекта через `maven` и строятся образы докера из докер файлов, а не забираются из репозитория.

## Результат работы:

```sh
pi@pi-VirtualBox:~$ http http://localhost/geo-converter/convert/?geoparam=spb
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Date: Sun, 13 Aug 2017 17:59:00 GMT
Server: Apache-Coyote/1.1
Transfer-Encoding: chunked
X-Application-Context: gateway:4000

[
    {
        "addressLine": "Россия", 
        "latitude": 59.939095, 
        "location": "Санкт-Петербург", 
        "longitude": 30.315868
    }
]

```

На 9000 порту висит `Hystrix Dashboard` для сбора статистики работы нашего микросервиса:
![Alt text](hystrix-dashboard.JPG?raw=true)
