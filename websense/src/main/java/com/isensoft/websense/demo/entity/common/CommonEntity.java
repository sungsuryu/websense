package com.isensoft.websense.demo.entity.common;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity  {

	@Size(max=20)
	@Column(name="INSERTED_ID")
	private String insertedId;
	
	@CreationTimestamp
	@Column(name="INSERTED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@Basic(optional=false)
	private LocalDateTime insertedDate;
	
	@Size(max=20)
	@Column(name="UPDATED_ID")
	private String updatedId;
	
	@CreationTimestamp
	@Column(name="UPDATED_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	@Basic(optional=false)
	private LocalDateTime updatedDate;
}