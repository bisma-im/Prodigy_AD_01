package com.example.prodigyinfotech;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inp1,inp2, op;
    Button add, sub, div, mul, exp, clear,equals,
            button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, del;
    int a, b;
    String operator;
    double result;
    TextView res;

    private String getButtonText(Button btn){
        return btn.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inp1 = findViewById(R.id.editTextText2);
        inp2 = findViewById(R.id.editTextText3);
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);
        div = findViewById(R.id.div);
        div.setOnClickListener(this);
        mul = findViewById(R.id.mul);
        mul.setOnClickListener(this);
        exp = findViewById(R.id.exp);
        exp.setOnClickListener(this);
        equals = findViewById(R.id.equals);
        equals.setOnClickListener(this);
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(this);
        del = findViewById(R.id.del);
        del.setOnClickListener(this);
        op = findViewById(R.id.op);
        res = findViewById(R.id.result);

        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add) {
            if(op.getText().toString() == ""){
                op.setText("+");
            }
        } else if (view.getId() == R.id.sub) {
            if(op.getText().toString() == ""){
                op.setText("-");
            }
        } else if (view.getId() == R.id.mul) {
            if(op.getText().toString() == ""){
                op.setText("*");
            }
        } else if (view.getId() == R.id.div) {
            if(op.getText().toString() == ""){
                op.setText("/");
            }
        } else if (view.getId() == R.id.exp) {
            if(op.getText().toString() == ""){
                op.setText("^");
            }
        } else if (view.getId() == R.id.clear) {
            inp1.setText("");
            inp2.setText("");
            op.setText("");
            res.setText("");
        } else if (view.getId() == R.id.equals) {
            a = Integer.parseInt(inp1.getText().toString());
            b = Integer.parseInt(inp2.getText().toString());
            operator = op.getText().toString();
            result = calculateResult(a, b, operator);
            res.setText(String.valueOf(result));
        } else if (view.getId() == R.id.del) {
            if (inp1.isFocused() && inp1.length() > 0) {
                inp1.getText().delete(inp1.length() - 1, inp1.length());
            } else if (inp2.isFocused() && inp2.length() > 0) {
                inp2.getText().delete(inp2.length() - 1, inp2.length());
            } else if (op.isFocused() && op.length() > 0) {
                op.getText().delete(op.length() - 1, op.length());
            }
        } else if (view.getId() == R.id.button0 ||
                view.getId() == R.id.button1 ||
                view.getId() == R.id.button2 ||
                view.getId() == R.id.button3 ||
                view.getId() == R.id.button4 ||
                view.getId() == R.id.button5 ||
                view.getId() == R.id.button6 ||
                view.getId() == R.id.button7 ||
                view.getId() == R.id.button8 ||
                view.getId() == R.id.button9) {

            Button clickedButton = (Button) view;
            String buttonText = clickedButton.getText().toString();

            if (inp1.isFocused()) {
                inp1.append(buttonText);
            } else if (inp2.isFocused()) {
                inp2.append(buttonText);
            }
        }
    }

    private double calculateResult(int a, int b, String operator) {
        switch (operator){
            case "+": return (double) a+b;
            case "-": return (double) a-b;
            case "*": return (double) a*b;
            case "/": return (double) a/b;
            case "^": return Math.pow(a,b);
            default: return 0;
        }
    }
}