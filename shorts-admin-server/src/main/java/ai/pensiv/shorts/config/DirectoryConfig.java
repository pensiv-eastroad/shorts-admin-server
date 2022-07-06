package shorts.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("dir")
@Slf4j
public class DirectoryConfig {
    @Getter
    @Value("${dir.models.shorts.output.result}")
    private int MODEL_SHORTS_OUTPUT_RESULT;
}
