package ru.grinncorp.factorysearchservice.slrfactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author agridin74
 *
 */
@RefreshScope
@RestController
public class GreetController {

	@Value("${name}")
	private String personName;
	
	@RequestMapping("/greeting")
	public String greet() {
		return "helo " + personName;
	}
}
