package com.agendador.agenda.configuracao.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration extends AsyncConfigurerSupport {

    @Value("${application.async-core-pool-size}")
    private Integer corePoolSize;

    @Value("${application.async-max-pool-size}")
    private Integer maxPoolSize;

    @Value("${application.async-queue-capacity}")
    private Integer queueCapaxity;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapaxity);
        executor.setThreadNamePrefix("thread-pool-task-executor");
        executor.initialize();
        return executor;
    }

}
