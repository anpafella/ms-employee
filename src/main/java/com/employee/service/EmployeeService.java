package com.employee.service;

import java.util.List;

import com.employee.model.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO create(EmployeeDTO employeeDTO);

	List<EmployeeDTO> getEmployeeByCompanyId(Integer companyId);
}
