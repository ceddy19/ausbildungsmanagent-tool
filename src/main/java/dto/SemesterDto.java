package dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.dfs.dfstestjpah2web.entity.Semester;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SemesterDto {
	@NotBlank(message = "The name is required")
	private String name;
	
	@NotBlank(message = "The startDate is required")
	private String startDate;
	
	@NotBlank(message = "The endDate is required")
	private String endDate;
	
	public String getName() {
		return name;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public Semester toSemester(Date startDateDate, Date endDateDate) {
		return new Semester(name, startDateDate, endDateDate);
	}
}
