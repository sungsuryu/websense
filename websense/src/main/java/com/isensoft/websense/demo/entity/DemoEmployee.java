package com.isensoft.websense.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.isensoft.websense.demo.entity.common.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="TB_EMPLOYEE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="passwd")
public class DemoEmployee extends CommonEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="ENTER_DATE")
	@Basic(optional=false)
	private LocalDateTime enterDate;
	
	@Column(name="COMPANY_ID")
	private String companyId;
	
	@Column(name="PHONE_NUM")
	private String phoneNum;
	
	@Column(name="LOGIN_ID")
	private String loginId;
	
	@Column(name="PASSWD")
	private String passwd;
	
	@Column(name="JWT_TOCKEN")
	private String jwtToken;
}
