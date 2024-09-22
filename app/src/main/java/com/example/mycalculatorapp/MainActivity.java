package com.example.mycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editsoa, editsob;
    Button tong, hieu, tich, thuong, ucln, thoat;
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editsoa = (EditText) findViewById(R.id.editsoa);
        editsob = (EditText) findViewById(R.id.editsob);
        tong = findViewById(R.id.tong);
        hieu = findViewById(R.id.hieu);
        tich = findViewById(R.id.tich);
        thuong = findViewById(R.id.thuong);
        ucln = findViewById(R.id.ucln);
        thoat = findViewById(R.id.thoat);
        ketqua = (TextView) findViewById(R.id.ketqua);

        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editsoa.getText().toString());
                int b = Integer.parseInt(editsob.getText().toString());
                int result = a+b;
                ketqua.setText(String.valueOf(result));
            }
        });
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editsoa.getText().toString());
                int b = Integer.parseInt(editsob.getText().toString());
                int result = a-b;
                ketqua.setText(String.valueOf(result));
            }
        });
        tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editsoa.getText().toString());
                int b = Integer.parseInt(editsob.getText().toString());
                int result = a*b;
                ketqua.setText(String.valueOf(result));
            }
        });
        thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editsoa.getText().toString());
                int b = Integer.parseInt(editsob.getText().toString());
                int result = a/b;
                ketqua.setText(String.valueOf(result));
            }
        });
        ucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editsoa.getText().toString());
                int b = Integer.parseInt(editsob.getText().toString());
                int gcd = calculateGCD(a, b);
                ketqua.setText(String.valueOf(gcd));
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private int calculateGCD(int a, int b) {
        if(b == 0) return a;
        else return calculateGCD(b,a%b);
    }
}