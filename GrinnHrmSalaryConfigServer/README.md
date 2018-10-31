# Сервер конфигурации 
http://localhost:9090/config/default 
http://localhost:9090/config/default/master
## для загрузки файлов свойств обычно используется GIT но можно использоватьи локальное хранилище
spring:
  cloud:
    config:
      server:
        git:
         uri: https://github.com/MyRepository

## Сервер конфигурации хранит свойства каждой микрослужбы на основе идентификатора службы (Service ID)
 задается свойством spring.application.name в файле bootstrap.properties 
 или bootstrap.yml (например spring.application.name=MyService)
 для различных профилей свойства загружаются исходя из шаблона именования 
 Например:профиль "dev" читаются все файлы  {Имя Сервиса}-dev.properties
 {ServiceID}-{profile}.properties.
  *MyService-dev.properties  - разработка
  *MyService-stg.properties  - тестирование
  *MyService-prod.properties - продакшн
# 
