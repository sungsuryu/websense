package com.isensoft.websense.demo.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isensoft.websense.demo.param.DemoParam;
import com.isensoft.websense.demo.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/{companyId}/")
public class DemoController {

	@Autowired
	DemoService demoService;
	
	public HashMap<String, Object> getDemo() throws Exception {
		
		return new HashMap<String, Object>();
	}
	
	@PostMapping("/employee")
	public HashMap<String, Object> getListCompany(@PathVariable String companyId, @Valid @RequestBody DemoParam demoParam, BindingResult bindingResult) throws Exception {
		
		demoService.getListCompany(demoParam, companyId);
		
		
		return new HashMap<String, Object>();
	}
}
