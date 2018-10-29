package ru.grinncorp.factorydashboardservice.slrfactory;

import java.util.Collection;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="SlrfactorySearch")
@RibbonClient(name="SlrfactorySearch")
public interface SlrfactoryServiceProxy {
	
	@RequestMapping("/slrfactory/find/{id}")
	public SlrfactoryInfo findById(@PathVariable(value="id") Long id);
	
	@RequestMapping("/slrfactory/findall")
	public Collection<SlrfactoryInfo> findAll();

}
