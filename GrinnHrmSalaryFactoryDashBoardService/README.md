# Простой сервис для тестирования
# http://localhost:8081/dashboard/feign/1

# Hystrix автомат защиты
	* @EnableHystrix - активация автомата защиты
	* @HystrixCommand(fallbackMethod="getDefaultMethod") -- активация защиты на методе 
	
	по умолчанию срабатывает при задержке ответа 1 с, можно поменять пимер(500 мс)
		commandProperties={
			@HystrixProperty(
				name="execution.isolation.thread.timeoutInMilliseconds",
				value="500")
							})
	* execution.timeout.enabled - false - отключить срабатывание по тайм ауту
	По умолчанию если защищенный метод вызывается более 20 раз и болле 50% терпят неудачу 
	в течении 10 секунд , автомат считается в открытом(разомкнутом) состоянии и все последующие вызовы 
	будут обрабатываться резервным методом.После 5 сек схема войдет в полуоткрытое состояние 
	и будет попытка вызова оригинального метода.
	Параметры влияющие на пороговые значения срабатывания
	* circuitBreaker.requestVolumeThreshold - кол-во вызовов метода в определенный момент времени
	* circuitBreaker.errorThresholdPercentage - процент неудачных вызовов
	* metrics.rollingStats.timeInMilliseconds - период времени (окно) для подсчета ошибок
	* circuitBreaker.sleepWindowInMilliseconds - задержка для полуоткрытой цепи
	
