package com.spring_JPA_Demo.JPA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring_JPA_Demo.JPA.DAO.DepartmentDao;
import com.spring_JPA_Demo.JPA.Models.Department;
import com.spring_JPA_Demo.JPA.Models.Employee;
import com.spring_JPA_Demo.JPA.jparepo.EmployeeRepositories;

@SpringBootApplication
public class EmployeeDepartmentApplication implements CommandLineRunner {
//	@Autowired 
	private DepartmentDao departmentdao;
	@Autowired
	private EmployeeRepositories employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDepartmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner in =new Scanner(System.in);
		System.out.println("Enter the Choice ");
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			Department d1 =new Department("Training", "Chennai",null);
			
			List<Employee> employees=new ArrayList<>();
			employees.add(new Employee("Bob","bob@gmail.com",25,d1));
			employees.add(new Employee("Roy","Roy@gmail.com",25,d1));
			
			d1.setEmployees(employees);
			departmentdao.saveDepartment(d1);
			break;
		
		case 2:
			System.out.println("Enter the Department id");
			int deptid = in.nextInt();
			Department d2 = departmentdao.getDepartment(deptid);
			System.out.println(d2.getDeptname() + " " + d2.getLocation());
			break;
			
		case 3:
			System.out.println("Enter the department id");
			int did=in.nextInt();
			departmentdao.deleteDepartment(did);
			break;
	
		case 4:
			System.out.println("Updating employee's department");
			System.out.println("Enter the employee id");
			int eid=in.nextInt();
			Employee employee=departmentdao.getEmployee(eid);
			System.out.println("Enter the department id");
			deptid=in.nextInt();
			d1 =departmentdao.getDepartment(deptid);
			employee.setDepartment(d1);
			departmentdao.updateEmployee(employee);
			break;	
			
		case 5:
			System.out.println("Enter name");
			String name=in.nextLine();
			List<Employee> es= departmentdao.getEmployeeByName(name);
			for(Employee e:es) {
				System.out.println(e);
			}
			break;
			
		case 6:
			System.out.println("Enter age");
			int age=in.nextInt();
			List<Employee> es1= departmentdao.getEmployeeByage(age);
			for(Employee e:es1) {
				System.out.println(e);
			}
			break;
			
		case 7:
			System.out.println("Enter department id");
			int department=in.nextInt();
			List<Employee> es3= departmentdao.getEmployeeByDepartment(department);
			for(Employee e:es3) {
				System.out.println(e);
			}
			break;
			
		case 8:
			System.out.println("Finding First 3 Name from Employee");
			List<Employee> emp=employeeRepo.findFirst3ByOrderByNameAsc();
			for(Employee e:emp) {
				System.out.println(e);
			}
		}
		
			
	}

}
