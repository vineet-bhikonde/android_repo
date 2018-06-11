package android.firebasedemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private EditText uName,uPassword,uEmail;
    private Button register;
    private TextView signin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupUIViews();

        firebaseAuth=FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String user_email=uEmail.getText().toString().trim();
                    String user_password=uPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(register.this,"Registration Successfull !",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(register.this,MainActivity.class));
                            }else{
                                Toast.makeText(register.this,"Registration Unsuccessfull !",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(register.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupUIViews(){
        uName=(EditText)findViewById(R.id.etUsername);
        uPassword=(EditText)findViewById(R.id.etUserPassword);
        uEmail=(EditText)findViewById((R.id.etUserEmail));
        register=(Button)findViewById(R.id.btnRegister);
        signin=(TextView)findViewById(R.id.tvSignin);
    }

    private boolean validate(){
        boolean result=false;
        String name=uName.getText().toString();
        String pass=uPassword.getText().toString();
        String email=uEmail.getText().toString();

        if((name.isEmpty()) || (pass.isEmpty()) || (email.isEmpty())){
            Toast.makeText(this,"Please enter all the details !",Toast.LENGTH_SHORT).show();
        }else{
            result=true;
        }
        return result;
    }
}
