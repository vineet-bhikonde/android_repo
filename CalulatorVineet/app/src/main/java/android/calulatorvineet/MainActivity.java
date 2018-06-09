package android.calulatorvineet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one,two,three,four,five,six,seven,eight,nine,zero,mul,div,add,sub,mod,clear,equal,decimal;
    private TextView text;

    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char MODULUS='%';
    private final char EQUAL='=';

    private double val1=Double.NaN;
    private double val2;

    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text.setText(text.getText().toString()+"9");
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=ADDITION;
                text.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=SUBTRACTION;
                text.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=MULTIPLICATION;
                text.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=DIVISION;
                text.setText(null);
            }
        });

        mod.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=MODULUS;
                text.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                compute();
                operator=EQUAL;
                text.setText(String.valueOf(val1));
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                val1=Double.NaN;
                val2=0;
                text.setText(null);
            }
        });
    }

    private void setupUIViews(){
        zero=(Button)findViewById(R.id.btnzero);
        one=(Button)findViewById(R.id.btn1);
        two=(Button)findViewById(R.id.btn2);
        three=(Button)findViewById(R.id.btn3);
        four=(Button)findViewById(R.id.btn4);
        five=(Button)findViewById(R.id.btn5);
        six=(Button)findViewById(R.id.btn6);
        seven=(Button)findViewById(R.id.btn7);
        eight=(Button)findViewById(R.id.btn8);
        nine=(Button)findViewById(R.id.btn9);
        add=(Button)findViewById(R.id.btnadd);
        sub=(Button)findViewById(R.id.btnsub);
        mul=(Button)findViewById(R.id.btnmul);
        div=(Button)findViewById(R.id.btndiv);
        mod=(Button)findViewById(R.id.btnmod);
        equal=(Button)findViewById(R.id.btnequ);
        clear=(Button)findViewById(R.id.btnclr);
        decimal=(Button)findViewById(R.id.btndec);
        text=(TextView) findViewById(R.id.textView);

    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(text.getText().toString());
            switch(operator){
                case ADDITION:
                    val1=val1+val2;
                    break;
                case SUBTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case MODULUS:
                    val1=val1%val2;
                    break;
                case EQUAL:
                    break;
            }
        }else{
            val1=Double.parseDouble(text.getText().toString());
        }
    }
}
