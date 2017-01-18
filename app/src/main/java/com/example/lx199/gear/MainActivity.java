package com.example.lx199.gear;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void js(View view)
    {
        double cd,kcs;
        EditText cse=(EditText)findViewById(R.id.et1);
        EditText mse=(EditText) findViewById(R.id.et2);
        EditText ylje=(EditText) findViewById(R.id.et3);
        EditText lxje=(EditText) findViewById(R.id.et4);
        EditText bwxse=(EditText) findViewById(R.id.et5);
        EditText cde=(EditText)findViewById(R.id.et6);
        EditText kcse=(EditText)findViewById(R.id.et7);
        if( cse.getText().toString().length()==0||mse.getText().toString().length()==0||ylje.getText().toString().length()==0||lxje.getText().toString().length()==0||bwxse.getText().toString().length()==0)
        {
            Toast.makeText(this,"请输入有效数字！", Toast.LENGTH_SHORT).show();
        }
        else {
            double cs = Double.valueOf(cse.getText().toString());
            double ms = Double.valueOf(mse.getText().toString());
            double ylj = Double.valueOf(ylje.getText().toString());
            double lxj = Double.valueOf(lxje.getText().toString());
            double bwxs = Double.valueOf(bwxse.getText().toString());
            double csp=cs*(Math.tan(ylj*Math.PI/180)/Math.cos(lxj*Math.PI/180)-Math.atan(Math.tan(ylj*Math.PI/180)/Math.cos(lxj*Math.PI/180)))/(Math.tan(ylj*Math.PI/180)-ylj*Math.PI/180);
            double yljp=Math.acos(csp*Math.cos(ylj*Math.PI/180)/(csp+2*bwxs));
            kcs = Math.round((csp * yljp /Math.PI) + 0.5);
            cd = ms * Math.cos(ylj * Math.PI / 180) * (Math.PI * (kcs - 0.5) + (Math.tan(ylj * Math.PI / 180) - ylj * Math.PI / 180) * csp)+2*bwxs*ms*Math.sin(ylj*Math.PI/180);
            cde.setText(String.valueOf(cd));
            kcse.setText(String.valueOf(kcs));
        }
    }
}
