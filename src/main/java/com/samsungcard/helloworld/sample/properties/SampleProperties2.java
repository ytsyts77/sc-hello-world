package com.samsungcard.helloworld.sample.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleProperties2 {
	@Value("mysolution.remote-address")
	String remoteAddress;

	@Value("mysolution.security.username")
	String username;
}
