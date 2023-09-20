package dto;

import com.dfs.dfstestjpah2web.entity.University;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UniversityDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public University toUniversity() {
		return new University(name);
	}
}
