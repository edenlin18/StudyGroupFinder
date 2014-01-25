package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class Search extends Activity {

	
	private Button searchButton, groupButton, logoutButton;
	private EditText sEdit;
	
	public static final String KEYWORD = "KEYWORD";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		addListenerOnButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	public void addListenerOnButton() {
		searchButton = (Button) findViewById(R.id.search);
		groupButton = (Button) findViewById(R.id.group);
		logoutButton = (Button) findViewById(R.id.logout);
	}

	public void myGroupsOnClick(View view)
	{
		Intent i = new Intent(this, MyGroupsActivity.class);
		startActivity(i);
		
	}
	
	public void mySearchOnClick(View view)
	{
		sEdit = (EditText)findViewById(R.id.searchfield);
		String input = sEdit.getText().toString();
		
		Intent i = new Intent(this, MyGroupsActivity.class);
		
		if(input.contains("_"))
			input = input.replace('_', ' ');
		
		for(int j = 0;; j++) {
			if(input.contains(" ")) {
				i.putExtra(KEYWORD + j, input.substring(0, input.indexOf(" ")) );
				Log.d("Test first", input.substring(0, input.indexOf(" ")));
				input = new String(input.substring(1+input.indexOf(" ")));
			}
			else {
				i.putExtra(KEYWORD + j, input.substring(0) );
				Log.d("Test last", input.substring(0));
				break;
			}
		}
		startActivity(i);
		

	}
	
}
	
