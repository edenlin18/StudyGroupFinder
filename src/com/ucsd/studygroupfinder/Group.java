package com.ucsd.studygroupfinder;

public class Group{
	private int id;
	private String title;
	private String subject;
	private String description;
	private String address;
	private String addressAddition;
	private String dateTime;
	private int duration;
	private int peopleIn;
	private int checkIn;
	private String school;
	private String creatorId;
	private String creatorName;

	public Group()
	{

	}

	public Group(int id, String title, String subject, 
		String description, String address, String addressAddition,
		String dateTime, int duration, int peopleIn, int checkIn, 
		String school, String creatorId, String creatorName ) {
		this.id = id;
		this.title = title;
		this.subject = subject;
		this.description = description;
		this.address = address;
		this.addressAddition = addressAddition;
		this.dateTime = dateTime;
		this.duration = duration;
		this.peopleIn = peopleIn;
		this.checkIn = checkIn;
		this.school = school;
		this.creatorId = creatorId;
		this.creatorName = creatorName;
	}

	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getSubject(){
		return subject;
	}
	public String getDescription(){
		return description;
	}
	public String getAddress(){
		return address;
	}
	public String getAddressAddition(){
		return addressAddition;
	}
	public String getDateTime(){
		return dateTime;
	}
	public int getDuration(){
		return duration;
	}
	public int getPeopleIn(){
		return peopleIn;
	}
	public int getCheckIn(){
		return checkIn;
	}
	public String getSchool(){
		return school;
	}
	public String getCreatorId(){
		return creatorId;
	}
	public String getCreatorName(){
		return creatorName;
	}


	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setAddressAddition(String addressAddition){
		this.addressAddition = addressAddition;
	}
	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}
	public void setDuration(int duration){
		this.duration = duration;
	}
	public void setPeopleIn(int peopleIn){
		this.peopleIn = peopleIn;
	}
	public void setCheckIn(int checkIn){
		this.checkIn = checkIn;
	}
	public void setSchool(String school){
		this.school = school;
	}
	public void setCreatorId(String creatorId){
		this.creatorId = creatorId;
	}
	public void setCreatorName(String creatorName){
		this.creatorName = creatorName;
	}

}