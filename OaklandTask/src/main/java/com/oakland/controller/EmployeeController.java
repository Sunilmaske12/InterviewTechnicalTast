package com.oakland.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oakland.entity.Employee;
import com.oakland.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String loginPage(){
		return "login";
	}
		
	 @GetMapping("/welcome") 
	 public String getHome(Model model) { 
		 List<Employee> allEmployees = this.employeeService.getALLEmployees();
	 model.addAttribute("allEmployees", allEmployees); 
	 return "welcome";
	 }
	
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}
	
	
	@PostMapping("/registerEmployee")
	public String registerUser(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		employeeService.registerEmployee(employee);
		model.addAttribute("registerSuccess", "Employee register successfully.");
		return "login";
	}
	
	@PostMapping("/loginEmployee")
	public String loginEmployee(@RequestParam("password") String password, 
			@RequestParam("loginId") String loginId, Model model) {		
		Employee employee= this.employeeService.loginEmployee(loginId, password);
		if(employee!=null) {
			model.addAttribute("loginEmployeeName", employee.getName());
			 List<Employee> allEmployees = this.employeeService.getALLEmployeesExceptCurrent(employee);
			 model.addAttribute("allEmployees", allEmployees); 
			return "welcome";
		}
		model.addAttribute("loginEmployee", "Employee not found !");
		return "login";
	}
}

