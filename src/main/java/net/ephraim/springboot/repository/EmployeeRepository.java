package net.ephraim.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ephraim.springboot.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
