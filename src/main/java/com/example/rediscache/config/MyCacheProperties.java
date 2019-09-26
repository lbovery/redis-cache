package com.example.rediscache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lyb
 */
@ConfigurationProperties(prefix = "caching")
@Component
@Data
public class MyCacheProperties {

    private List<CacheSpec> specs;
    @Data
    static class CacheSpec {

        /**
         * 缓存过期时间
         */
        private Integer timeout;

        /**
         * 缓存名称
         */
        private String cacheName;
    }
}
