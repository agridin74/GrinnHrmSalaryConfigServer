package ru.grinncorp.factorydashboardservice.slrfactory;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class FeignSlrfactoryInfoController {
	
	@Autowired
	SlrfactoryServiceProxy proxyService;
	
	@RequestMapping("/dashboard/feign/{myself}")
	public SlrfactoryInfo findme(@PathVariable Long myself) {
		return proxyService.findById(myself);
	}
	
	@RequestMapping("/dashboard/feign/peers")
	public Collection<SlrfactoryInfo> findPeers(){
		return proxyService.findAll();
	}

}
