package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //Equations string
    private String eq;
    private Double memory;


    //On create of main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: When a number is pressed and there already is a result, ANS function
        //Number Format
        final NumberFormat formatter = new DecimalFormat("#0.00");


        //Get instance
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //outputText
        final TextView output = (TextView) findViewById(R.id.outputText);

        //Buttons
        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button btn_clr = findViewById(R.id.btn_clr);
        Button btn_dec = findViewById(R.id.btn_dec);
        Button btn_division = findViewById(R.id.btn_div);
        Button btn_multiply = findViewById(R.id.btn_multip);
        Button btn_addition = findViewById(R.id.btn_addition);
        Button btn_subtract = findViewById(R.id.btn_minus);
        Button btn_equals = findViewById(R.id.btn_equals);
        Button btn_mem_plus = findViewById(R.id.mem_plus);
        Button btn_mem_minus = findViewById(R.id.mem_minus);

        //TODO: Add memory implementation
        Button btn_left_bracket = findViewById(R.id.bracket_left);
        Button btn_right_bracket = findViewById(R.id.bracket_right);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "1");

            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "2");

            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "4");

            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "5");

            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "6");

            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "7");

            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "8");

            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "9");

            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + ".");

            }
        });

        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText("");
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + " / ");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + " * ");
            }
        });

        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + " + ");
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + " - ");
            }
        });

        btn_left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + "(");
            }
        });

        btn_right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText() + ")");
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!output.getText().toString().contains("=")){
                    //Get equation
                    eq = output.getText().toString();

                    //Split the string at each space
                    String[] arrStr = eq.trim().split(" ",0);

                    //Convert the string to Post

                    //Debugging to check the PostFxed array
                    //String PostFixed = postFix(arrStr);
                    //System.out.println("Post Fixed Expression: " + PostFixed);

                    //Begin the calculation of the PostFixed string
                    double result = Calculate(postFix(arrStr));
                    output.clearComposingText();
                    output.setText(output.getText() + " = " + formatter.format(result));
                }
            }
        });
    }

    /**
     * Assigns numeric values to each operator
     * @param s String of operator
     * @return Associated numeric value
     */
    private  static int Prec(String s){
        switch (s){
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            case "^": return 3;
        }
        return -1;
    }

    /**
     * Converts Infix String to PostFix
     * @param input Array of Strings
     * @return Converted string
     */
    private String postFix(String[] input){
        //TODO: Fix brackets
        //TODO: Change function so that it converts a given string to PostFix, helps remove some redundant code in the main function
        String result = new String("");

        Stack<String> stack = new Stack<>();

        for(String x:input){
            if(isNumeric(x))
                result += x + ",";
            else if (x.equals("("))
                stack.push(x);
            else if(x.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("("))
                    result += stack.pop() + ",";
                if(!stack.isEmpty() && !stack.peek().equals("("))
                    return "N/A";
                else
                    stack.pop();
        }else{
                while(!stack.isEmpty() && Prec(x) <= Prec(stack.peek())){
                    if(stack.peek().equals("("))
                        return "N/A";
                    result += stack.pop() + ",";
                }
                stack.push(x);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals("("))
                return "N/A";
            result += stack.pop() + ",";
        }
        result = result.substring(0,result.length() - 1);
        return result;
    }

    /**
     * Checks if String is a number.
     * @param str String that needs to be checked if isNumeric.
     * @return True if isNumeric, else False.
     */
    private static boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    /**
     * Calculates the user generated equation.
     * @param eq String of equation (Must be in post-fix format).
     * @return value of evaluated tree.
     */
    private double Calculate(String eq) {
        String[] chars = eq.split(",",0);
        ExpressionTree tree = new ExpressionTree();
        Node root = tree.populateTree(chars);
        System.out.printf("# Generated Tree: ");
        tree.printTree(root);
        return tree.evaluateTree(root);
    }
}