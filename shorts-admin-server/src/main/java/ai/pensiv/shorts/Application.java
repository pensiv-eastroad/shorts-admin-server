package ai.pensiv.shorts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;


//@EnableScheduling
@SpringBootApplication
//@EntityScan(basePackages = "com.miraeclimate.blackice.viz.entity")
//@EnableJpaRepositories(basePackages = "com.miraeclimate.blackice.viz.repository")
public class Application {
	public static void main(String arg[]) {
		SpringApplication.run(Application.class, arg);
	}
}