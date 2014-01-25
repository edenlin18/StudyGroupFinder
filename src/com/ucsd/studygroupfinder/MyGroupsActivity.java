package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MyGroupsActivity extends Activity {

	private TableLayout mainTable;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_groups);
		mainTable = (TableLayout) findViewById(R.id.tableLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_groups, menu);
		return true;
	}
	
	public void rowMaker(View view)
	{
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row = inflater.inflate(R.layout.my_groups_row, null, false);
		
		mainTable.addView(row);
		
		/*
		TableRow row = new TableRow(this);
		
		TextView msg1 = new TextView(this);
		TextView msg2 = new TextView(this);
		
		msg1.setText("First message");
		msg2.setText("Message number 2");
		
		row.addView(msg1);
		row.addView(msg2);
		
		mainTable.addView(row);
		*/
	}

}
