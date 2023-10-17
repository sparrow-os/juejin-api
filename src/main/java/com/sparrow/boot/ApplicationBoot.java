package com.sparrow.boot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication(scanBasePackages = "com.sparrow.*")
public class ApplicationBoot {
    private static Logger log = LoggerFactory.getLogger(ApplicationBoot.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationBoot.class);

        springApplication.addListeners(new ApplicationListener<ContextClosedEvent>() {

            @Override
            public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
                log.info("application closed at at {}", contextClosedEvent.getTimestamp());
            }
        });
        springApplication.run(args);
    }
}
