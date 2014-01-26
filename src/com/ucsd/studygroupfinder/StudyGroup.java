package com.ucsd.studygroupfinder;

public class StudyGroup 
{
	public int number;
	
    private String subject;
    private String school;
    private String address;
    private String description;
    private String date;
    private String time;
    
    private boolean isCreator;
    private int count;
    
    public StudyGroup()
    {
    	super();
    }
    
    public StudyGroup(String subject, String school, String address, String description, String date, String time)
    {
    	super();
    	
    	this.subject = subject;
    	this.school = school;
    	this.address = address;
    	this.description = description;
    	this.date = date;
    	this.time = time;
    	
    	this.isCreator = true;
    	this.count = 1;
    }
    
    public StudyGroup(String subject, String school, String address, String description, String date, String time,
    boolean isCreator, int count)
    {
    	super();
    	
    	this.subject = subject;
    	this.school = school;
    	this.address = address;
    	this.description = description;
    	this.date = date;
    	this.time = time;
    	
    	this.isCreator = isCreator;
    	this.count = count;
    }
    
    // ACCESSORS
    public String getSubject()
    {
    	return subject;
    }
    
    public String getSchool()
    {
    	return school;
    }
    
    public String getAddress()
    {
    	return address;
    }
    
    public String getDescription()
    {
    	return description;
    }
    
    public String getDate()
    {
    	return date;
    }
    
    public String getTime()
    {
    	return time;
    }
    
    public boolean getIsCreator()
    {
    	return isCreator;
    }
    
    public int getCount()
    {
    	return count;
    }
}
