package kr.or.connect.bookingService.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"kr.or.connect.bookingService.dao", "kr.or.connect.bookingService.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
