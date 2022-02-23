package com.employee.service.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.model.dto.EmployeeDTO;
import com.employee.model.entity.Employee;

@Component
public class EmployeeMapper {

	public Employee toEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();

		employee.setId(employeeDTO.getId());
		employee.setName(employeeDTO.getName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setEdad(employeeDTO.getEdad());
		employee.setCompanyId(employeeDTO.getCompanyId());

		return employee;

	}

	public EmployeeDTO toEmployeeDTO(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();

		employeeDTO.setId(employee.getId());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setName(employee.getName());
		employeeDTO.setEdad(employee.getEdad());
		employeeDTO.setCompanyId(employee.getCompanyId());

		return employeeDTO;
	}

	public List<EmployeeDTO> toListEmployeeDTO(List<Employee> employeeList) {

		List<EmployeeDTO> listaDTOaRetornar = new ArrayList<>();

		for (Employee employee : employeeList) {
			EmployeeDTO employeeDTO = toEmployeeDTO(employee);

			listaDTOaRetornar.add(employeeDTO);
		}
		return listaDTOaRetornar;
	}

}