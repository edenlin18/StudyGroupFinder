package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Search extends Activity {

	private Button searchButton, groupButton, logoutButton;
	private EditText sEdit;

	public static final String KEYWORD = "KEYWORD";

	public String removeDuplicates(String s) {
		return new LinkedHashSet<String>(Arrays.asList(s.split(" ")))
				.toString().replaceAll("(^\\[|\\]$)", "").replace(", ", " ");
	}

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
		searchButton = (Button) findViewById(R.id.SEARCHsearch);
		groupButton = (Button) findViewById(R.id.SEARCHgroup);
		logoutButton = (Button) findViewById(R.id.SEARCHlogout);
	}

	public void myGroupsOnClick(View view) {
		Intent i = new Intent(this, MyGroupsActivity.class);
		startActivity(i);

	}

	public void mySearchOnClick(View view) {
		sEdit = (EditText) findViewById(R.id.SEARCHsearchfield);

		String input = sEdit.getText().toString();

		Intent i = new Intent(this, MyGroupsActivity.class);

		if (input.contains("_"))
			input = input.replace('_', ' ');

		input = new String(removeDuplicates(input));

		for (int j = 0;; j++) {
			if (input.contains(" ")) {
				i.putExtra(KEYWORD + j, input.substring(0, input.indexOf(" ")));
				Log.d("Test first", input.substring(0, input.indexOf(" ")));
				input = new String(input.substring(1 + input.indexOf(" ")));
			} else {
				i.putExtra(KEYWORD + j, input);
				Log.d("Test last", input);
				break;
			}
		}
		startActivity(i);

	}

}
