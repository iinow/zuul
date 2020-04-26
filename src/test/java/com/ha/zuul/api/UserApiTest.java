package com.ha.zuul.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@Slf4j
public class UserApiTest extends BaseApiTest {

    @Test
    public void users() throws Exception {
        mockServer.stubFor(get(urlEqualTo("/ha/api/users/2"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//                        .withBodyFile("json/user.json")
                        .withBody("{\"name\": \"BB\", \"age\": 22}")
                        .withStatus(HttpStatus.OK.value())
                ));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/2"))
            .andExpect(content().json("{\"name\": \"BB\", \"age\": 22}"))
            .andDo(print())
            .andReturn();
    }
}
