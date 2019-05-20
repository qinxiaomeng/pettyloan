package com.brother.common.config;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootConfiguration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    private int database;
    private String host;
    private String port;
    private String password;

    public String getAddress(){
        return "redis://" + this.host +":" + this.port;
    }


}
