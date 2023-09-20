package dto;

import com.dfs.dfstestjpah2web.entity.Role;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoleDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Role toRole() {
		return new Role(name);
	}
}
