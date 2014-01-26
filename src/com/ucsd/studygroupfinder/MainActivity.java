package com.ucsd.studygroupfinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private ClientThread client;
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
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
    
    public void signUpTest(View view)
    {
    	Intent i = new Intent(this, SignUpActivity.class);
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
    
    public void searchResultsTest(View view)
    {
    	Intent i = new Intent(this, SearchResultsActivity.class);
    	startActivity(i);
    }
    
    
    public void connectTest(View view)
    {
        client = new ClientThread("id", "password", "school");
     
        client.start();
    	
    	//client.run();
    }
    
    private class ClientThread extends Thread
    {
    	private String id;
    	private String password;
    	private String school;
    	
    	public ClientThread(String id, String password, String school)
    	{
    		this.id = id;
    		this.password = password;
    		this.school = school;
    	}
    	
    	public void run()
    	{
    		Log.d("RUN()", "Running");
    		
			try
			{
				Log.d("TRY()", "Tried");
				
				socket = new Socket("54.201.23.79", 1234);
				out = new PrintWriter(socket.getOutputStream(),true);
				in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				out.println("login");
				String send = id + " " + password + " " + school;
				out.println(send);
				int code = Integer.parseInt(in.readLine());
				
			}
			catch (UnknownHostException e) 
			{
				Log.d("UNKNOWN HOST", "Who?");
				//showError(CONNECTION_ERROR);
				//finish();
			} 
			catch (IOException e) 
			{
				Log.d("IO EXCEPTION", "Bad IO");
				//showError(CONNECTION_ERROR);
				//finish();
			}
    	}
    	
    	
    	
    }
    
}
