package ru.grinncorp.factorydashboardservice.slrfactory;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//@RefreshScope
//@RestController
public class SlrfactoryInfoController {
	
	private static Logger logger = LoggerFactory.getLogger(SlrfactoryInfoController.class);
	
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	@Autowired
//	private EurekaClient eurekaClient;
//	
//	@Value("${service.slrfactorysearch.serviceId}")
//	private String slrfactorySearchserviceId;
//	
//	@RequestMapping("/dashboard/{myself}")
//	@HystrixCommand(fallbackMethod="defaultMe")
//	public SlrfactoryInfo findme(@PathVariable Long myself) {
//		Application application = eurekaClient.getApplication(slrfactorySearchserviceId);
//		InstanceInfo instanceInfo = application.getInstances().get(0);
//		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" 
//				+ "slrfactory/find/" + myself;
//		logger.info("++++++>>>> URL " + url);
//		SlrfactoryInfo factory = restTemplate.getForObject(url, SlrfactoryInfo.class);
//		logger.info("++++++>>>> RESPONSE " + factory);
//		return factory;
//		
//	}
//	
//	private SlrfactoryInfo defaultMe(Long id) {
//		SlrfactoryInfo info = new SlrfactoryInfo();
//		info.setId(id);
//		info.setSnm("Hystrix fallback");
//		info.setSlongname("Netflix fallback");
//		return info;
//	}
//	
//	@RequestMapping("/dashboard/peers")
//	public Collection<SlrfactoryInfo> findPeers(){
//		Application appication = eurekaClient.getApplication(slrfactorySearchserviceId);
//		InstanceInfo instanceInfo = appication.getInstances().get(0);
//		String url = "http://" + instanceInfo.getIPAddr() + ":" 
//				+ instanceInfo.getPort() + "/" + "slrfactory/findall";
//		logger.info("++++++>>>> URL " + url);
//		Collection<SlrfactoryInfo> list = restTemplate.getForObject(url, Collection.class);
//		logger.info("++++++>>>> RESPONSE " + list);
//		return list;
//	}

}
