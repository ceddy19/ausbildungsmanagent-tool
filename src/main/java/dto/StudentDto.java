package dto;

import com.dfs.dfstestjpah2web.entity.Student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	@NotBlank(message = "The email is required")
	private String email;
	
	@NotNull
	private int personnelNumber;
	
	@NotNull
	private String description;
	
	@NotBlank(message = "The password is required")
	private String password;
	
	@NotBlank(message = "The office is required")
	private String office;
	
	@NotBlank(message = "The department is required")
	private String department;
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getPersonnelNumber() {
		return personnelNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getOffice() {
		return office;
	}
	
	public String getDepartment() {
		return department;
	}
	public Student toStudent() {
		return new Student(name, email, personnelNumber, description, password, office, department);
	}
}
