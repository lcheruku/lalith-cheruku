// REST API Web Service
// Following code is building REST APIs to communicate with the underlying MySQL database from SQL Workbench  
// Code extends JPARepository or CrudRepository and uses ORM framework called Hibernate  
// This code consists a Spring Boot Application, Entity Class, Service Class, Repository Class, and a Rest Controller
/* Let us assume few things first,
    Project Built Tool - Maven
    Language - Java
    Spring Boot initialization - Spring Boot Initializr
    Spring Boot version - 3.4.0(current)
  */
// Also, assume that maven dependencies are readily available in pom.xml file 
// Additionally, properties for SQL Workbench and port 8080 are already configured in application.properties
// Let's follow the given process pattern, Spring Boot Application Class -> Entity Class -> Repository Class -> Service Class -> Rest Controller

____________________________________________________________________________________________________________________________________________________

// Spring Boot Application - Application start up
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // annotation for Spring Boot Application
public class PracticeExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeExerciseApplication.class, args);
	}

}

____________________________________________________________________________________________________________________________________________________

// Entity Class - Our database underlying in SQL Workbench
import jakarta.persistence.Column;
import lombok.data; // Lombok is a library that automatically creates setter, getter, and toString methods. Add Lombok dependency to pom.xml 

@Entity // annotation that Employee is a table
public class Employee {

// EmployeeID, employeeName, salary are rows in Employee table
@Id // annotation that EmployeeID is Primary Key
@GeneratedValue // annotation that Primary Key value is Generated automatically and incremented by 1 everytime a new column is added
private long EmployeeID;
private String employeeName;
private int salary;
}

____________________________________________________________________________________________________________________________________________________

// Repository class - Responsible for performing operations on our database
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SpringDataJpaRepository extends JpaRepository<Employee, long> { // Employee - table, long - type of primary key
// Both JpaRepository and CrudRepository has Crud operations namely Create, Retrieve, Update, Delete. JpaRepository is built on top of CrudRepository
// JpaRepository, in addition, has Pagination and Sorting
  
}

____________________________________________________________________________________________________________________________________________________

// Creating an interface that has methods which are called by our Service class to perform Crud Operations
// I would generally include any operations I might perform in an interface and call them from Service class. I reckon as good coding practice  
import java.util.List;
	
public interface IEmployeeService {

// review on all these methods will be provided in our Service class
public List<Employee> getAllEmployees(); 
public Employee getEmployeeById(Long id);
public Employee addEmployeeDetails(Employee employee);
public Employee updateEmployee(Long id, Employee employee);
public Employee updatedEmployee(Long id, Map<String, Object> updates)
public void deleteEmployee(Long id);
  
}  

____________________________________________________________________________________________________________________________________________________

// Service class - Business logic
import java.util.List;
	
@Service
public class EmployeeService implements IEmployeeService { 

private final SpringDataJpaRepository repository; // Wiring the Repository class. This is called field-injection 

public EmployeeService(SpringDataJpaRepository repository) // Creating a constructor 
{
	this.repository = repository;
}

// Now, I would call all methods from the above interface. Carefully look at the SQL statement for each method implementation
  
@Override
// Lists all employees from Employee table - GET method
public List<Employee> getAllEmployees(){
// findAll() - Select * from Employee;
return repository.findAll(); 
}

@Override
// Lists employees by given id - GET method
public Optional<Employee> getEmployeeById(Long id){
// findById() - Select * from Employee where id=:Employeeid;  
return repository.findById(long id).orElseThrow(() -> newRuntimeException("Employee not found"));  
}

@Override
// Inserts employee details to Employee table - POST method
public Employee addEmployeeDetails(Employee employee){
// save() - Insert into Employee values(EmployeeId, employeeName, Salary);
return repository.save(employee);
}

@Override
// Inserts employee details by given id - PUT method
public Optional<Employee> updateEmployee(Long id, Employee employee){
// update Employee set employeeName=:employeeName, salary=:salary where id=:EmployeeId;
return repository.findById.map(s -> {
				s.setName(employee.getName());
				s.setSalary(employee.getSalary());
				return repository.save(s); })
		.orElseThrow(() -> newRuntimeException("Employee not found"));
}

@Override
// Updates certain columns by given id - PATCH method
public Optional<Employee> updatedEmployee(Long id, Map<String, Object> updates){
// update Employee set employeeName=:employeeName where id=:EmployeeId;
// or, update Employee set salary=:salary where id=:EmployeeId;
Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    employee.setName((String) value);
                    break;
                case "salary":
                    employee.setSalary((Double) value);
                    break;
		case default:
		    throw new RuntimeException("Employee not found");
                    break;
}
});
	return repository.save(employee);
}

@Override
// Deletes the entire column by given id
public void deleteEmployee(Long id){
// deleteById() - delete from Employee where id=:EmployeeId; 
return repository.deleteById(id);
}

}
  
____________________________________________________________________________________________________________________________________________________

// Rest Controller class - Building REST API web service
import java.util.List;
	
@RestController // Creates APIs that communicate with Service class method implementations respectively
@RequestMapping("/employees") // creating a base endpoint 
// These API endpoints are called from the URL - http://localhost:8080/employees
Public class Controller {

private final EmployeeService employeeService; // Field-injection

Public Controller(EmployeeService employeeService) // Constructor
{
	this.employeeService = employeeService;
}

// http://localhost:8080/employees
@GetMapping("/employees") // HTTP - GET method
public List<Employee> getEmployeeDetails(){
	return employeeService.getAllEmployees();
}

// http://localhost:8080/employees/id
@GetMapping("/employees/{id}") // HTTP - GET method
public Employee getEmployeeDetailsById(@PathVariable long id){ // @PathVariable is the id that we pass in the URL header
	return employeeService.getEmployeeById(id);
}

// http://localhost:8080/employees
@PostMapping("/employees") // HTTP - POST method
public Employee insertEmployeeDetails(@RequestBody Employee employee){ // @RequestBody is the payload we pass for inserts and updates as Body
	return employeeService.addEmployeeDetails(employee);
}

// http://localhost:8080/employees/id
@PutMapping("/{id}") // HTTP - PUT method
public Employee updatedEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	return employeeService.updatedEmployee(id, employee);
}

// http://localhost:8080/employees/id
@PatchMapping("/{id}") // HTTP - PATCH method
public Employee updateEmployee(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
	return employeeService.updateEmployee(id, updates);
    }

// http://localhost:8080/employees/id
@DeleteMapping("/{id}") // HTTP - DELETE method
public Employee deleteEmployee(@PathVariable Long id){
	return employeeService.deleteEmployee(id);
}

}
