package com.mckesson.restApi.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UserControllerTests extends ApplicationTests {
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// Don't include this test as the users end point is not currently included in the API
	// @Test
	public void testGetUsers() throws Exception {

		this.mockMvc.perform(get("/users")).andExpect(status().isOk());
	}

	@Test
	public void testPutUser() throws Exception {
		
		final int id = 1;
		final String name = "Jeremy Hovis";
		final String email = "jeremyhovis@gmail.com";
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value("1"))
			.andExpect(jsonPath("$.name").value(name))
			.andExpect(jsonPath("$.email").value(email));
	}
	
	@Test
	public void testPutNullName() throws Exception {
		
		final int id = 1;
		final String name = null;
		final String email = "jeremyhovis@gmail.com";
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testPutUserEmptyName() throws Exception {
		
		final int id = 1;
		final String name = "";
		final String email = "jeremyhovis@gmail.com";
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testPutUserNullEmail() throws Exception {
		
		final int id = 1;
		final String name = "Jeremy Hovis";
		final String email = null;
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testPutUserEmptyEmail() throws Exception {
		
		final int id = 1;
		final String name = "Jeremy Hovis";
		final String email = "";
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testPutUserInvalidEmail() throws Exception {
		
		final int id = 1;
		final String name = "Jeremy Hovis";
		final String email = "jeremyhovisgmail.com";
		User user = new User();
		user.setName(name);
		user.setEmail(email);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(user);

		mockMvc.perform(put("/user/" + id)
			.contentType(APPLICATION_JSON_UTF8).content(requestJson))
			.andExpect(status().isBadRequest());
	}
}