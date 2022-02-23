package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.dto.EmployeeDTO;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/crear")
	public EmployeeDTO create(@RequestBody @Valid EmployeeDTO employee) {

		EmployeeDTO empleadoRecibido = employeeService.create(employee);

		return empleadoRecibido;
	}

	@GetMapping("/{companyId}/get")
	public List<EmployeeDTO> getEmployeeByCompanyId(@PathVariable(value = "companyId") Integer companyId) {
	
		 List<EmployeeDTO> empleadoEncontradoPorId = employeeService.getEmployeeByCompanyId(companyId);
		return empleadoEncontradoPorId;
	}

}
