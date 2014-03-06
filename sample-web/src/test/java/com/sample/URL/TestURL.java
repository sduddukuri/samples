package com.sample.URL;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

public class TestURL {

	@Test
	public void test() throws URISyntaxException {
		try{
		URI rui = new URI("http://localhost:8080/account?accountNo=4");
		System.out.println(rui.getHost());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
