package com.isensoft.websense.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isensoft.websense.demo.param.DemoParam;
import com.isensoft.websense.demo.repository.CompanyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoService {

	@Autowired
	CompanyRepository companyRepository;
	
	public void getListCompany(DemoParam demoParam, String companyId) throws Exception {
		
		log.debug("msisdn:{}", demoParam.getMsisdn());
		
		companyRepository.findByCompanyIdOrderByInsertedDateDesc(companyId);
	}
}
