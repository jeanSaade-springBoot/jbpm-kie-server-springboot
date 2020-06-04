package com.company.service;


import java.util.HashMap;
import java.util.Map;

import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.model.VariableDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller  {
	
    @Autowired
    private ProcessService processService;
    @Autowired
    private RuntimeDataService runtimeDataService;

    public Controller(ProcessService processService)
    {
    	this.processService = processService;
    }
 
    @GetMapping("/createandsubmit")
    public ResponseEntity<String> createAndSubmit(@RequestParam String name,@RequestParam String status) throws Exception {
    	Map<String, Object> vars = new HashMap<>();
    	vars.put("processVar1", name);
    	vars.put("status", status);
    	String output= "";
    	Long processInstanceId = processService.startProcess("business-application-kjar-1_0-SNAPSHOT", "SimpleProcess", vars);
    	for ( VariableDesc var: runtimeDataService.getVariablesCurrentState(processInstanceId) ) {
    		if ( var.getVariableId().equals("processVar1"))
    			output =output + var.getNewValue();
    		if ( var.getVariableId().equals("status"))
    			output = output+ var.getNewValue();
    	}
    	 return ResponseEntity.ok(output);
    }
}