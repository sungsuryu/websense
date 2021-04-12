package com.isensoft.websense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isensoft.websense.demo.entity.DemoCompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<DemoCompanyEntity, String> {

	public List<DemoCompanyEntity> findByCompanyIdOrderByInsertedDateDesc(String companyId);
	
	public List<DemoCompanyEntity> findAll();

	public List<DemoCompanyEntity> findTopByOrderByInsertedDateDesc();
}
