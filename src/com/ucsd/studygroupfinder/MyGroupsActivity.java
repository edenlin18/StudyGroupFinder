package com.ucsd.studygroupfinder;

import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyGroupsActivity extends ListActivity 
{
	private ArrayList<StudyGroup> groups;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	   super.onCreate(savedInstanceState);
	   
	   groups = new ArrayList<StudyGroup>();
	   

	   groups.add(new StudyGroup("CSE 1", false, 7));
	   groups.add(new StudyGroup("CSE 2", false, 72));
	   groups.add(new StudyGroup("CSE 3", false, 34));
	   groups.add(new StudyGroup("CSE 40", false, 21));
	   groups.add(new StudyGroup("CSE 105", true, 487));
	   groups.add(new StudyGroup("CSE 1", false, 7));
	   groups.add(new StudyGroup("CSE 2", false, 72));
	   groups.add(new StudyGroup("CSE 3", false, 34));
	   groups.add(new StudyGroup("CSE 40", false, 21));
	   groups.add(new StudyGroup("CSE 105", true, 487));
	   groups.add(new StudyGroup("CSE 1", false, 7));
	   groups.add(new StudyGroup("CSE 2", false, 72));
	   groups.add(new StudyGroup("CSE 3", false, 34));
	   groups.add(new StudyGroup("CSE 40", false, 21));
	   groups.add(new StudyGroup("CSE 105", true, 487));
	   
	   setListAdapter(new Adapter(MyGroupsActivity.this, R.layout.search_results_row, groups));
	}
	
	public class Adapter extends ArrayAdapter<StudyGroup>
	{
		public Adapter(Context context, int textResource, List<StudyGroup> objects)
		{
			super(context, textResource, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{			
			View row = convertView;
			
			if(row == null)
			{	
				LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = inflater.inflate(R.layout.search_results_row, null);
			}
			
			StudyGroup item = getItem(position);
			
			if(item != null)
			{
				TextView subject = (TextView) row.findViewById(R.id.RESULTsubject);
				if(subject != null)
					subject.setText(item.getSubject());
				
				TextView isCreator = (TextView) row.findViewById(R.id.RESULTisCreator);
				if(isCreator != null)
				{
					if(item.getIsCreator() == true)
						isCreator.setText("Creator");
					else
						isCreator.setText("Member");
				}
				
				TextView count = (TextView) row.findViewById(R.id.RESULTcount);
				count.setText(Integer.toString(item.getCount()));
			}
			
			return row;
		}
	}
	
	public void editResult(View view)
	{
		Intent i = new Intent(this, EditGroupActivity.class);
		startActivity(i);
	}
}
