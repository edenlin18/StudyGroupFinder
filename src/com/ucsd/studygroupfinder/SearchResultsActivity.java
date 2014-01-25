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

public class SearchResultsActivity extends ListActivity 
{
	private List<String> list;
	
	public class Adapter extends ArrayAdapter<String> 
	{
		public Adapter(Context context, int textResource, List<String> objects) 
		{
			super(context, textResource, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			LayoutInflater inflater=getLayoutInflater();
			View row = inflater.inflate(R.layout.search_results_row, parent, false);
			
			return row;
		}
	}
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	   super.onCreate(savedInstanceState);
	   
	   list = new ArrayList<String>();
	   
	   list.add("1");
	   list.add("2");
	   list.add("3");
	   
	   setListAdapter(new Adapter(SearchResultsActivity.this, R.layout.search_results_row, list));
	}
	
	public void editResult(View view)
	{
		// Color Feedback, weird stuff happening
		//view.setBackgroundResource(android.R.drawable.list_selector_background);
		
		Intent i = new Intent(this, EditGroupActivity.class);
		startActivity(i);
	}
}