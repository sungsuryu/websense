package com.isensoft.websense.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.isensoft.websense.demo.entity.common.CommonEntity;

@Entity(name="TB_COMPANY")
@Getter @Setter
@ToString(callSuper=true)
@NoArgsConstructor
public class DemoCompanyEntity extends CommonEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPANY_ID")
	private String companyId;
	
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="EMPLOYEE_NUM")
	private int employeeNum = 0;
	
	@Column(name="START_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@Basic(optional=false)
	private LocalDateTime startDate;
	
	@Builder
	public DemoCompanyEntity(String insertedId, LocalDateTime insertedDate, 
			String updatedId, LocalDateTime updatedDate, 
			String companyId, String companyName, 
			int employeeNum, LocalDateTime startDate) {
		
		super(insertedId, insertedDate, updatedId, updatedDate);
		
		this.companyId = companyId;
		this.companyName = companyName;
		this.employeeNum = employeeNum;
		this.startDate = startDate;
	}
}
