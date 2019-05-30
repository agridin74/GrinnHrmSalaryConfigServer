# Сервер конфигурации 
http://localhost:8888/config/default 
http://localhost:8888/config/default/master
curl localhost:8888/config/env
 
## для загрузки файлов свойств обычно используется GIT но можно использоватьи локальное хранилище
	spring:
  	 cloud:
          config:
           server:
            git:
             uri: https://github.com/MyRepository
  * application.properties
	server.port=8081 - используемый порт в приложении
	spring.application.name=my-service-config -имя сервиса
	spring.cloud.config.server.git.uri=file://${user.home}/app-config -расположение Git реестра 
	 на локальной машине(необходимо создать папку app-config в домашнем каталоге и инициализировать
	 Git реестр командой git init)
	$ cd $HOME
	$ mkdir config-repo
	$ cd config-repo
	$ git init .
	$ echo info.foo: bar > application.properties
	$ git add -A .
	$ git commit -m "Add application.properties"

## Сервер конфигурации хранит свойства каждой микрослужбы на основе идентификатора службы (Service ID)
 задается свойством spring.application.name в файле bootstrap.properties 
 или bootstrap.yml (например spring.application.name=MyService)
 для различных профилей свойства загружаются исходя из шаблона именования 
 Например:профиль "dev" читаются все файлы  {Имя Сервиса}-dev.properties
 {ServiceID}-{profile}.properties.
  * MyService-dev.properties  - разработка
  * MyService-stg.properties  - тестирование
  * MyService-prod.properties - продакшн
## Клиент (сервис) ищет файл bootstrap.(properties, yml) в каталоге src/main/resources для загрузки свойств сервиса:
  * spring.applicaton.name - имя сервиса (например myexample-service)
  * spring.cloud.config.uri - местонахождение сервера конфигурации
bootstrap.properties(.yml) загружается раньше других файлов свойств (в том числе
 application.properties(.yml)) т.е сообщет где искать остальные файлы 
 конфигурации.Порядок загрузки:
  * 1. bootstrap.properties(.yml)
  * 2. application.properties(.yml)

## Безопастность 
Если в GIT-хранилище включено HTTP BASIC необходимо определить свойства сервера конфигурации :
  * spring.cloud.config.server.git.username
  * spring.cloud.config.server.git.password
что бы разрешить доступ к безопастным Git хранилищам.
Безопастность самого сервера определяется например с помощью HTTP BASIC
для этого необходимо добавить в POM 
	org.springframework.boot: spring-boot-starter-security
и определить свойства :
 * security.user.name
 * security.user.password
Клиенты должны использовать строку для поиска сервера конфигурации в виде
 spring.cloud.config.uri https://username:password@hostname.com

##Обновление конфигурации у клиентов
необходимо использовать аннотацию @RefreshScope - позволяет получать область 
видимости и любому bean-компоненту пересоздавать себя заново и перечитывать 
параметры 
Пример:
	@RestController
	@RefreshScope
	class MyRestController {
	....
	@Autowired
	public MyRestController( 
		@Value("${configuration.nameParam}") String param)
bean компоненты получают событие ApplicationContext имеющие тип 
RefreshScopeRefreshedEvent 
для запуска обновления можно отправить POST запрос 
http://127.0.0.1:8080/refresh 
curl -d{} http://127.0.0.1:8080/refresh
либо воспользоваться Spring Boot Actuator JMX (после git commit вызвать REST
 или JMX на клиенте) для массового автоматического обновления используется 
канал Spring Cloud Bus получающий ссылки на сервисы через SpringCloud Stream
( пример RabbitMQ, Apache Kafka Reactor и т.д.) 
зависимость org.springframework.cloud: spring-cloud-starter-bus-amqp
 * RabbitMQ ConnectionFactoy
	spring:
	  rabbitmq:
	   host: ExampleRabbitHost 
	   port: 5672
	   username: MyUserName
	   password: MyPassword
используемые аннотации 
	** @BusConnectionFactory - к какому конкретно экземпляру 
		применяется обновление(в случае нескольких экземпляров 
		ConnectionFactory)
	** @Primary - классификация любого другого экземпляра для обычных 
		действий не связанных с обработкой канала 
открывается конечная точка актуатора /bus/refresh
curl -d{} http://127.0.0.1:8080/bus/refresh  
