

public class Group{
	private String groupName;
	private String school;
	private String subject;
	private String address;
	private String description
	private String date;
	private String time;
	private String creatorID;

	public Group(){

	}

	public Group(int groupName, String school, String subject, String address, String description, 
		String date, String time, String creatorID ){
		this.groupName = groupName;
		this.school = school;
		this.subject = subject;
		this.address = address;
		this.description = description;
		this.date = date;
		this.time = time;
		this.creatorID = creatorID;
	}

	public String getGroupName(){
		return groupName;
	}
	public String getSchool(){
		return school;
	}
	public String getSubject(){
		return subject;
	}
	public String getAddress(){
		return address;
	}
	public String getDescription(){
		return description;
	}
	public String getDate(){
		return date;
	}
	public int getTime(){
		return time;
	}
	public String getCreatorID(){
		return creatorId;
	}

	public void setGroupName(int groupName){
		this.groupName = groupName;
	}
		
	public void setSchool(String school){
		this.school = school;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setTime(int time){
		this.time = time;
	}
	public void setCreatorID(String creatorID){
		this.creatorID = creatorID;
	}
}