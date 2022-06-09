package com.pm.nielwebshop.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring")
@Data
public class DateTimeFormatConfigurationProperties {

	private Mvc mvc = new Mvc();

	@Data
	public static class Mvc {
		private Format format = new Format();
	}

	@Data
	public static class Format {
		private String date;
		private String dateTime;
	}

}
