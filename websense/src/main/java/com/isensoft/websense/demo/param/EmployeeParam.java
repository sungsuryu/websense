package com.isensoft.websense.demo.param;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeParam {
	
	private String employeeName;
	
	@NotNull(message="loginId is not null")
	@Size(min=12, max=25, message="LoginId는 12~25자리의 영문 또는 숫자여야 합니다.")
	private String loginId;

	@NotNull(message="Password is not null")
	@Size(min=12, max=25, message="Password는 12~25자리의 영문 또는 숫자여야 합니다.")
	private String passwd;
}
