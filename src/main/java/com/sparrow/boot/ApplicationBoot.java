package com.sparrow.boot;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication(scanBasePackages = "com.sparrow.*")
@MapperScan(basePackages = {"com.sparrow.article.dao", "com.sparrow.passport.dao", "com.sparrow.tag.dao"})
public class ApplicationBoot {
    private static Logger log = LoggerFactory.getLogger(ApplicationBoot.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationBoot.class);

        springApplication.addListeners(new ApplicationListener<ApplicationStartingEvent>() {
            @Override
            public void onApplicationEvent(ApplicationStartingEvent event) {
                System.out.printf("prepare before bean init");
            }
        });

        springApplication.addListeners(new ApplicationListener<ContextRefreshedEvent>() {
            @Override
            public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
                log.info("application startup at {}", contextRefreshedEvent.getTimestamp());
            }
        });

        springApplication.addListeners(new ApplicationListener<ContextClosedEvent>() {
            @Override
            public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
                log.info("application closed at at {}", contextClosedEvent.getTimestamp());
            }
        });
        springApplication.run(args);
    }
}
