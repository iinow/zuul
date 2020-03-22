package com.ha.zuul.common;

public enum RoutingType {
    PRE("pre"),
    ROUTE("route"),
    POST("post");

    public String value;

    RoutingType(String value) {
        this.value = value;
    }
}
