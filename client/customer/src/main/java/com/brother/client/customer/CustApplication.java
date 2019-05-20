package com.brother.client.customer;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableHystrixDashboard
@EnableFeignClients
/**
 * 因为我们将一些工具类放在common工程下，springboot默认扫描启动类下的包，
 * 一般我们会把启动类放在最外层的包，那么，在该工程下springboot会扫描com.brother.client.customer
 * 而我们的common工程包路径为com.brother.common，为了能获取到common下的工具类，我们自定义扫描包路径
 */
@ComponentScan(basePackages = "com.brother")
@MapperScan("com.brother.client.customer.mapper")
public class CustApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustApplication.class, args);
    }

    /**
     * 熔断器监控，后面集成熔断器的时候再介绍
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet );
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
