package com.ucsd.studygroupfinder;

import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
	   
	   groups.add(new StudyGroup("CSE 105", "UCSD", "Price Center", "Fun Times!", "2014-01-20", "14:52:21", true, 1));
	   groups.add(new StudyGroup("ECON 1", "UCLA", "Library", "Not good...", "2014-01-20", "14:52:21", false, 1));
	   
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

				TextView dateTime = (TextView) row.findViewById(R.id.RESULTdateTime);
				dateTime.setText(item.getDate() + "       " + item.getTime());
				
				TextView count = (TextView) row.findViewById(R.id.RESULTcount);
				count.setText(Integer.toString(item.getCount()));
			}
			
			return row;
		}
	}
	
	public void editResult(View view)
	{
		String subject;
		boolean isCreator;
		int count;
		
		TextView subjectText = (TextView) view.findViewById(R.id.RESULTsubject);
		subject = subjectText.getText().toString();
		
		Log.d("Subject Get", subject);
		
		Intent i = new Intent(this, EditGroupActivity.class);
		startActivity(i);
	}
}
