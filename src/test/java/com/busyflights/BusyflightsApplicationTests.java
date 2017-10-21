package com.busyflights;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BusyflightsApplicationTests {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate restTemplate = new RestTemplate();

	private String getUrl() {
		StringBuilder url = new StringBuilder("http://localhost:");
		url.append(port);
		return url.toString();
	}

	@Test
	public void testMainScreen() throws Exception {
		String body = this.restTemplate.getForObject(getUrl() + "/", String.class);
		assertThat(body, equalTo("Welcome to BusyFlights Service"));
	}

	@Test
	public void testGetFlights() {
//		BusyFlightsRequest request = new BusyFlightsRequest("LHR", "TMS", "2017-01-29T12:12:12Z", "2017-02-15T11:12:13Z", "2");
//		BusyFlightsResponse body = restTemplate.postForObject(getUrl() + "/search", request, BusyFlightsResponse.class);
//		Assert.assertNotNull(body);
	}
}