package com.acme.spring_data_entityless_fetching.configuration;

import io.micrometer.tracing.Tracer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracerInitializer {

   @Bean
   @ConditionalOnClass(Tracer.class)
   Tracer getTracer() {
      return Tracer.NOOP;
   }

}
