package com.ds;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import org.junit.Test;

public class Crawler {

	@Test
	public void accessYahoo() throws Exception {
		InputStream input = new URL("https://finance.yahoo.com").openStream();
		String s = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining("\n"));
		System.out.println(s);
	}

	@Test
	public void crawlYahoo() {

	}

	@Test
	public void scrapeYahoo() {

	}

}
