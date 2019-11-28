# Настройки
	## zuul.ignored-services - пропустить автоматическое добавление службы
		Если сервис соответствует шаблону, который игнорируется, но также включен в
		явно сконфигурированную карту маршрутов, то он будет отменен.
		Пример:
	zuul:
	  ignoredServices: *
	  routes:
	    departments: /mydepartments/**

		игнорируются все сервисы кроме departments
	## Время ожидания чтения Hystrix по умолчанию составляет 1 секунду 
		необходимо изменить в случае длительных запросов
	### для всех сервисов
	hystrix:
	  command:
	    default:
	      execution:
		isolation:
		  thread:
		    timeoutInMilliseconds: 5000
	### для конкретного сервиса
	hystrix:
	  command:
	    <serviceName>:
	      execution:
		isolation:
		  thread:
		    timeoutInMilliseconds: 5000
	
в случае изменения параметров сервиса можно воспользоваться конечной точкой актуатора /routes , Zuul проведет ее автоматическую конфигурацию.
localhost:<port>/routes  

curl localhost:8080/resource
