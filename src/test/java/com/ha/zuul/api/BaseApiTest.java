package com.ha.zuul.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseApiTest {

    @Value(value = "${mock.server.port}")
    protected int mockServerPort;

    @Autowired
    private WebApplicationContext context;

    protected WireMockServer mockServer;

    protected MockMvc mockMvc;

    @BeforeEach
    public void beforeEach() {
        WireMockConfiguration config = new WireMockConfiguration();
        config.port(mockServerPort);

        mockServer = new WireMockServer(config);
        mockServer.start();

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        log.info("MockServer start, port: {}", mockServerPort);
    }
}
