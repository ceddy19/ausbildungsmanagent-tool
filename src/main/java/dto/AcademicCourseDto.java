package dto;

import com.dfs.dfstestjpah2web.entity.AcademicCourse;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AcademicCourseDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public AcademicCourse toAcademicCourse() {
		return new AcademicCourse(name);
	}
}
