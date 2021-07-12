package com.junit.component.unit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxiang
 */
@Configuration
@ComponentScan("com.xmw.component.unit")
@EnableFeignClients(basePackages = {"com.xmw.component.unit.feignService"})
@Slf4j
public class UnitAutoScanBeanConfiguration {
    @Bean
    public void scanUnitBean() {
        log.info("unit bean scan start");
    }
}
