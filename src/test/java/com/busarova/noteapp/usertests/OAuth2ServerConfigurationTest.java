package com.busarova.noteapp.usertests;

import com.busarova.noteapp.user.dto.CreateCustomerDto;
import com.busarova.noteapp.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class OAuth2ServerConfigurationTest {
  
  private static final String TEST_EMAIL = "r.busarova@tests.com";
  private static final String TEST_PASSWORD = "password";
  
  @Autowired private MockMvc mvc;
  @Autowired private UserService userService;
  
  @Test public void testGetAccessTokenAsCustomer() throws Exception {
    userService.createCustomer(new CreateCustomerDto(TEST_EMAIL, TEST_PASSWORD));
    String clientId = "noteapp-web-client";
    String clientSecret = "12345";
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("grant_type", "password");
    params.add("client_id", clientId);
    params.add("client_secret", clientSecret);
    params.add("username", TEST_EMAIL);
    params.add("password", TEST_PASSWORD);
    mvc.perform(post("/oauth/token").params(params).with(httpBasic(clientId, clientSecret))
        .accept("application/json;charset=UTF-8")).andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8")).andDo(print())
        .andExpect(jsonPath("access_token").isString()).andExpect(jsonPath("token_type").value("bearer"))
        .andExpect(jsonPath("refresh_token").isString()).andExpect(jsonPath("expires_in").isNumber())
        .andExpect(jsonPath("scope").value("web"));
  }
}