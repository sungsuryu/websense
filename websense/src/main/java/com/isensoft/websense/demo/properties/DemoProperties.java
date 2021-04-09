package com.isensoft.websense.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix="demo")
public class DemoProperties {

}
