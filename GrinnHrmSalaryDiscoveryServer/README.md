#Сервер маршрутизации
 используется  Netflix Eureka для обнаружения и регистрации реестра сервисов
 может работать в 2 режимах
 * Standalone :  автономный режим (есть только один сервер Eureka)
 * Clustered  :  есть несколько серверов Eureka ,может иметь файл свойств 
                 и взаимодействовать с сервером конфигурации, 
                 как это делают другие микрослужбы.
## Файл параметров bootstrap.properties
   * spring.application.name : уникальное имя сервиса
   * eureka.client.serviceUrl.defaultZone :  зона URL сервера Eureka для синхронизации реестра службы
   * server.port : используемый порт сервера
   * eureka.client.register-with-eureka : нужно ли регистироваться на сервере Eureka (true or false)
   * eureka.client.fetch-registry : не регистрировать себя в реестре служб
### Настройка клиентов
   * eureka.instance.metadataMap.instanceId: -- регистрация нового экземпляра 
       одного и того же сервиса
       ${spring.application.name}:${spring.application.instance_id:${server.port}} --новый порт
       ${spring.application.name}:${spring.application.instance_id:${random.value}} --случайное значение

 http://localhost:9091

