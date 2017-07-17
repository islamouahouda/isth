package com.example.adam.ishtapp;

import android.app.AuthenticationRequiredException;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ButtonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSingin;
    private FirebaseAuth firebaseAuth;
    //private ProgressDialog progressDialog ;
//





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //ProgressBar = new progressbar(this);


        //firebas auth
        firebaseAuth = FirebaseAuth.getInstance();

        // now let's initialize our views

        ButtonRegister = (Button) findViewById(R.id.ButtonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSingin = (TextView) findViewById(R.id.TextViewSigin);

        //after implementing the method "on click" let's attache the listener to out text view and button register

        // listner is on the same class so lets use this

         ButtonRegister.setOnClickListener(this);
         textViewSingin.setOnClickListener(this);




    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password =  editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){    //prefered over string.isempty()
            //email is empty
            Toast.makeText(this,"please enter Email",Toast.LENGTH_SHORT).show();
            return;  //stopping the funcition execution further !
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this,"please enter Password",Toast.LENGTH_SHORT).show();
            return; // again stoping the fucntion from repeating it self
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password);
        firebaseAuth = FirebaseAuth.getInstance();

    // to this point validations are ok
        // so we will show a progressdialog while the user waits fot autho(might take a lil time )


      //progressDialog.setMessage("Registering User...");
        //progressDialog.show();


        firebaseAuth.createUserWithEmailAndPassword(email,password)
         //.addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        //.addOnCompleteListener()
;



    }

    @Override
    public void onClick(View view) {
    if(view == ButtonRegister){
        registerUser();
    }
    if(view == textViewSingin){
        //will openlogin activity here
    }

    }
}
