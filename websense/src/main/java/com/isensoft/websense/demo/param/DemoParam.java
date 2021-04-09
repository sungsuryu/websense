package com.isensoft.websense.demo.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DemoParam {

	@NotNull(message="msisdn not null")
	@Size(min=11, max=12, message="msisdn 을 11~12자리여야 합니다.")
	@Pattern(regexp="(^821\\d{1})([1-9]\\d{2,3})(\\d{4})")
	private String msisdn;
}