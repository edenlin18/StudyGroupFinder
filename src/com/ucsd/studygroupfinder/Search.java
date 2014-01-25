package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class Search extends Activity {

	
	private Button searchButton, groupButton, logoutButton;
	
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
		
		groupButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent i = new Intent(this, MyGroupsActivity.class);
				startActivity(i);
			}
			
		});
		
		
	}

}
