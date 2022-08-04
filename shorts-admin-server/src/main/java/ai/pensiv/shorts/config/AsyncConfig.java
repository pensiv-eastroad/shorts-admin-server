package ai.pensiv.shorts.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@ConfigurationProperties("threadPool")
@EnableAsync
public class AsyncConfig {
    @Value("${threadPool.namePrefix}")
    private String NAME_PREFIX;

    @Value("${threadPool.core}")
    private int CORE_POOL_SIZE;

    @Value("${threadPool.max}")
    private int MAX_POOL_SIZE;

    @Value("${threadPool.queue}")
    private int QUEUE_CAPACITY;

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.setThreadNamePrefix(NAME_PREFIX);
        taskExecutor.initialize();
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return taskExecutor;
    }
}
