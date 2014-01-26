package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
		
		TextView text = (TextView) findViewById(R.id.SEARCHchangeSchool);
		
		String changeSchool = "Change School";
		SpannableString content = new SpannableString(changeSchool);
		content.setSpan(new UnderlineSpan(), 0, changeSchool.length(), 0);
		text.setText(content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

	public void changeSchool(View view)
	{
		TextView text = (TextView) findViewById(R.id.SEARCHchangeSchool);
		
		String changeSchool = "School Changed!";
		SpannableString content = new SpannableString(changeSchool);
		content.setSpan(new UnderlineSpan(), 0, changeSchool.length(), 0);
		text.setText(content);
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

		String input = sEdit.getText().toString().toUpperCase();

		Intent i = new Intent(this, SearchResultsActivity.class);

		if (input.contains("_"))
			input = input.replace('_', ' ');

		input = new String(removeDuplicates(input));

		i.putExtra(KEYWORD, input);
		//Log.d(KEYWORD, input);

		startActivity(i);

	}

}
