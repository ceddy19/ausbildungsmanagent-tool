package dto;

import com.dfs.dfstestjpah2web.entity.ProjectType;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectTypeDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public ProjectType toProjectType() {
		return new ProjectType(name);
	}
}
