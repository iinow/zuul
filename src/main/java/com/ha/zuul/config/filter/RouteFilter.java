package com.ha.zuul.config.filter;

import com.ha.zuul.common.RoutingType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RoutingFilter extends ZuulFilter {

    private boolean execute;
    private int order;

    public RoutingFilter(int order, boolean execute) {
        this.order = order;
        this.execute = execute;
    }

    @Override
    public String filterType() {
        return RoutingType.ROUTING.value;
    }

    @Override
    public int filterOrder() {
        return this.order;
    }

    @Override
    public boolean shouldFilter() {
        return this.execute;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("RoutingFilter run!!");
        return null;
    }
}
