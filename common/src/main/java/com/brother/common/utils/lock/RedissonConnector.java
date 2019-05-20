package com.brother.common.utils.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class RedissonConnector {
    RedissonClient redisson;

    public static class Builder {
        private String host;
        private String port;
        private int database;
        private String password;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public Builder setDatabase(int database) {
            this.database = database;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public RedissonConnector build(){
            return new RedissonConnector(this);
        }

    }

    private RedissonConnector(Builder builder){
        Config config = new Config();
        config.useSingleServer().setDatabase(builder.database)
                .setAddress("redis://" + builder.host+ ":" + builder.port)
                .setPassword(builder.password);
        redisson = Redisson.create();
    }

    public static Builder options(){
        return new RedissonConnector.Builder();
    }

    public RedissonClient getClient(){
        return redisson;
    }
}
