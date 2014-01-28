package com.ucsd.studygroupfinder;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ucsd.studygroupfinder.LoginActivity;

import android.os.AsyncTask;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class LoginActivity extends Activity {
        private ClientThread client;
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        public final static String EMAIL = "EMAIL";
        public final static String PASSWORD = "PASSWORD";

        private final static int EMAIL_EMPTY = 1;
        private final static int PASSWORD_EMPTY = 2;
        
        private SharedPreferences save;
        
        private String email;
        private String password;

        private AlertDialog.Builder builder;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                builder = new AlertDialog.Builder(this);
                setContentView(R.layout.activity_login);
                
                save = this.getSharedPreferences("Save", MODE_PRIVATE);
                
                email = save.getString("user", "");
                if(email != "")
                {
                	//password = save.getString("password", "");
                	//check();
                	out();
                }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }

        public void login(View view) {
                login();
        }

        private void login() {
                EditText editEmail = (EditText) findViewById(R.id.editEmail);
                EditText editPassword = (EditText) findViewById(R.id.editPassword);
                email = editEmail.getText().toString();
                if (email == null || email.equals("")) {
                        showWarning(EMAIL_EMPTY);
                        return;
                }
                password = editPassword.getText().toString();
                if (password == null || password.equals("")) {
                        showWarning(PASSWORD_EMPTY);
                        return;
                }
                
                check();
        }
        
        private void check()
        {
            client = new ClientThread(email, password, "school");
            client.start();
        }

        private void showToast(String message) {
                Toast.makeText(getApplicationContext(), message, TRIM_MEMORY_MODERATE)
                                .show();
        }

        private class ClientThread extends Thread {
                private String id;
                private String password;
                private String school;

                public ClientThread(String id, String password, String school) {
                        this.id = id;
                        this.password = password;
                        this.school = school;
                }

                public void run() {

                        try {
                                socket = new Socket("54.201.23.79", 1234);
                                out = new PrintWriter(socket.getOutputStream(), true);
                                in = new BufferedReader(new InputStreamReader(
                                                socket.getInputStream()));
                                out.println("login");
                                String send = id + " " + password + " " + "school";

                                out.println(send);

                                int code = Integer.parseInt(in.readLine());
                                if (code == 1)
                                {
                                	    saveData();
                                        out();
                                }
                                else
                                {
                                	removeData();
                                }

                        } catch (UnknownHostException e) {
                                // showError(CONNECTION_ERROR);
                                finish();
                                e.printStackTrace();
                        } catch (IOException e) {
                                // showError(CONNECTION_ERROR);
                                finish();
                                e.printStackTrace();
                        }
                }
        }

        /*
         * public void register(View view) {
         * 
         * Intent intent = new Intent(this, SignUpActivity.class);
         * startActivity(intent); }
         */

        private void showWarning(int code) {
                builder.setTitle(R.string.warning);
                switch (code) {
                case EMAIL_EMPTY:
                        builder.setMessage(R.string.emailEmpty);
                        break;
                case PASSWORD_EMPTY:
                        builder.setMessage(R.string.passwordEmpty);
                        break;
                }
                builder.create().show();
        }
        
        public void saveData()
        {
            Editor editor = save.edit();
            editor.putString("user", email);
            editor.putString("password", password);
            
            editor.commit();
        }
        
        public void removeData()
        {
            Editor editor = save.edit();
            editor.putString("user", null);
            editor.putString("password", null);
            
            editor.commit();
        }

        public void out() 
        {
                Intent i = new Intent(this, Search.class);
                startActivity(i);
        }

}