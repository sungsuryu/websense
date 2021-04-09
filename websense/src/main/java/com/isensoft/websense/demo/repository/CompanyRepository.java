package com.isensoft.websense.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isensoft.websense.demo.entity.DemoCompanyEntity;

public interface CompanyRepository extends JpaRepository<DemoCompanyEntity, String> {

	public List<DemoCompanyEntity> findByCompanyIdOrderByInsertedDateDesc(String companyId);
}
