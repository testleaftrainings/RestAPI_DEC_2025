package week4.day1;

import com.google.gson.annotations.SerializedName;

public class CreateIncidentPojo {

	@SerializedName(value = "short_description")
	private String shortDescription;
	@SerializedName(value = "description")
	private String desc;
	@SerializedName(value = "first name")
	private String firstName;	
	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}