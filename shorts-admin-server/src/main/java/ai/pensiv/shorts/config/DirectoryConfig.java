package ai.pensiv.shorts.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class DirectoryConfig {
//    @Getter
//    @Value("${dir.models.shorts.inputs}")
//    private String inputs;
//
//    @Getter
//    @Value("${dir.models.shorts.outputs}")
//    private String outputs;
//    @Getter
//    private Models models;
//    public class Models {
//        @Getter
//        private Shorts shorts;
//        public class Shorts {
//            @Getter
//            private String inputs;
//            @Getter
//            private String outputs;
//        }
//
//    }

}
