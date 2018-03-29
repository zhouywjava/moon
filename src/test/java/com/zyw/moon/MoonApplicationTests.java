package com.zyw.moon;

import com.zyw.moon.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MoonApplication.class)
@WebAppConfiguration
public class MoonApplicationTests {

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void contextLoads() {
		try {
			String json = mockMvc.perform(MockMvcRequestBuilders.get("/hello/index").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			System.out.println("return response content : " + json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
