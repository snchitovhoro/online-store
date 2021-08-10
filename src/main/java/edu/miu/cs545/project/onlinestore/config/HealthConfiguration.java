package edu.miu.cs545.project.onlinestore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeReactiveHealthContributor;
import org.springframework.boot.actuate.health.ReactiveHealthContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HealthConfiguration {

    @Autowired
    private ServiceHealth serviceHealth;

    @Bean
    public ReactiveHealthContributor coreServices() {
        Map healthMap = new HashMap();
        healthMap.put("serviceHealthContrib", serviceHealth);
        return CompositeReactiveHealthContributor.fromMap(healthMap);
    }

}