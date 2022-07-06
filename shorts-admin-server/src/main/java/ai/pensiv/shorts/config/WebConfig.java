package shorts.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ConfigurationProperties("server")
public class WebConfig implements WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Value("${server.crossorigins}")
    private String crosssOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(!"".equals(crosssOrigins)){
            registry.addMapping("/**").allowedOrigins(crosssOrigins);
        }
    }
}

