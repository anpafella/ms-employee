package com.employee.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.dto.EmployeeDTO;
import com.employee.model.entity.Employee;
import com.employee.model.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.service.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public EmployeeDTO create(EmployeeDTO employeeDTO) {

		EmployeeDTO employeeDTOtoReturn = new EmployeeDTO();

		Employee employee = employeeMapper.toEmployee(employeeDTO);

		employee.setCompanyId(employee.getCompanyId());
		employee.setId(employee.getId());
		employee.setName(employee.getName());
		employee.setLastName(employee.getLastName());
		employee.setEdad(employee.getEdad());

		Employee newEmploye = employeeRepository.save(employee);
		employeeDTOtoReturn = employeeMapper.toEmployeeDTO(newEmploye);

		return employeeDTOtoReturn;
	}

	@Override
	public List<EmployeeDTO> getEmployeeByCompanyId(Integer companyId) {
		List<Employee> employeeList = employeeRepository.findByCompanyId(companyId);

		List<EmployeeDTO> employeeDTOlist = new ArrayList<>();

		if (null!=employeeList && employeeList.size()>0) {
			employeeDTOlist = employeeMapper.toListEmployeeDTO(employeeList);

		}
		return employeeDTOlist;

	}

}
