package com.example.rediscache.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyb
 */
@RestController
public class CacheTestController {


    @Cacheable(cacheNames = "test1", key = "method.name")
    @GetMapping("/test1")
    public Map<String, String> test1(HttpServletRequest request) {
        return getCacheOrMap(request);
    }

    @Cacheable(cacheNames = "test2", keyGenerator = "mKeyGenerator")
    @GetMapping("/test2")
    public Map<String, String> test2(HttpServletRequest request) {
        return getCacheOrMap(request);
    }

    private Map<String, String> getCacheOrMap(HttpServletRequest request) {
        request.getMethod();
        Map<String, String> result = new HashMap<>();
        result.put("method", request.getMethod());
        result.put("time", DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()));
        return result;
    }

}
