package com.ucsd.studygroupfinder;

public class StudyGroup 
{
    private String subject;
    private boolean isCreator;
    private int count;
    
    public StudyGroup()
    {
    	super();
    }
    
    public StudyGroup(String subject, boolean isCreator, int count)
    {
    	super();
    	
    	this.subject = subject;
    	this.isCreator = isCreator;
    	this.count = count;
    }
    
    public String getSubject()
    {
    	return subject;
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
