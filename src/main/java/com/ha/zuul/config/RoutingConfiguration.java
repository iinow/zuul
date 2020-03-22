package com.ha.zuul.config;

import com.ha.zuul.config.filter.PostFilter;
import com.ha.zuul.config.filter.PreFilter;
import com.ha.zuul.config.filter.RouteFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter(0, true);
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter(1, true);
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter(2, true);
    }
}
