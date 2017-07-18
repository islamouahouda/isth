package com.example.adam.ishtapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Login_Activity extends AppCompatActivity {


    TextView register;
    EditText login ,pass;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //point objects to the corresponding view


        login = (EditText) findViewById(R.id.LoginText);
        pass = (EditText) findViewById(R.id.PasswordText);
        loginbutton = (Button) findViewById(R.id.ButtonLogin);
        register = (TextView) findViewById(R.id.TextViewRegister);


        // Create the OnclickListners

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go from this activity to the register activity

                Intent intent = new Intent(getBaseContext(),MainActivity.class); // here this will not refer to the context thats why i used Get Base Context() function
                startActivity(intent);
                // kill this activity
                finish();

            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });



    }

    private void loginUser() {
        String email = login.getText().toString().trim();
        String password =  pass.getText().toString().trim();
        if(TextUtils.isEmpty(email)){    //prefered over string.isempty()
            //email is empty
            Toast.makeText(this,"please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        // if everything goes okay we need a dialog who tell the user to wait
        AlertDialog waitdialog = new AlertDialog.Builder(this).create(); // i was obliged to do like this so i can access to close() function more detail : https://stackoverflow.com/questions/14853325/how-to-dismiss-alertdialog-in-android
        // need a customView to carry-on it
        LayoutInflater inflater = (LayoutInflater) getLayoutInflater().getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View waitview = inflater.inflate(R.layout.waitdialog,null);
        waitdialog.setView(waitview);
        waitdialog.setCanceledOnTouchOutside(false); // so it will be sticky
        waitdialog.show(); // show please wait dialog


        // firebase code for login goes here




        waitdialog.dismiss();  // dimiss the dialog
        /**
         here after login we need that the application preserve the coordinates of user on memory
         we need :
         id : will help us on communication with the server
         name : obviously
         those info we will get them from the server after login

         so if the login has already succseeded before we will not use register activity neither login activity
         for that we need a code on the main activity that will verify that

         triying now to work on the next activity
         */


        // intent to navigation activity

       // Intent intent = new Intent(this,navigationActivity.class);
       // startActivity(intent);


    }

}
