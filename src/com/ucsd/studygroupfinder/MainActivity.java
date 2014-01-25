package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void myGroupsTest(View view)
    {
    	Intent i = new Intent(this, MyGroupsActivity.class);
    	startActivity(i);

    }
    
    public void searchTest(View view)
    {
    	Intent i = new Intent(this, Search.class);
    	startActivity(i);
    }
    
    public void editGroupTest(View view)
    {
    	Intent i = new Intent(this, EditGroupActivity.class);
    	startActivity(i);
    }
    
}
