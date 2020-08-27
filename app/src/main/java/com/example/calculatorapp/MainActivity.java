package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //Equations string
    private String eq;
    private Double memory;
    private boolean valid;
    int left_bracket = 0;
    int right_bracket = 0;


    //On create of main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: When a number is pressed and there already is a result, ANS function
        //TODO: Add Sin/Cos Implimination
        //Number Format
        final NumberFormat formatter = new DecimalFormat("#0.00");


        //Get instance
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //outputText
        final TextView output_textbox = findViewById(R.id.outputText);
        final TextView history_textbox = findViewById(R.id.history_Text);

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
        Button backspace = findViewById(R.id.backspace_btn);

        //TODO: Add memory implementation
        Button btn_left_bracket = findViewById(R.id.bracket_left);
        Button btn_right_bracket = findViewById(R.id.bracket_right);

        //Backspace functionality
        backspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String s = (String) output_textbox.getText();
                if (!s.isEmpty() && s.indexOf('=') == -1) {
                    if (s.charAt(s.length() - 1) == ' ')
                        s = s.substring(0, s.length() - 2);
                    else
                        s = s.substring(0, s.length() - 1);
                    output_textbox.setText(s);
                }
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "1");

            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "2");

            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "4");

            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "5");

            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "6");

            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "7");

            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "8");

            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "9");

            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + ".");

            }
        });

        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output_textbox.setText("");
                history_textbox.setText("");
                left_bracket = 0;
                right_bracket = 0;
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + " / ");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + " * ");
            }
        });

        btn_addition.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + " + ");
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + " - ");
            }
        });

        btn_left_bracket.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + "(");
                left_bracket++;

            }
        });

        btn_right_bracket.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                output_textbox.setText(output_textbox.getText() + ")");
                right_bracket++;
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!output_textbox.getText().toString().contains("=") && left_bracket == right_bracket) {
                    //Get equation
                    eq = output_textbox.getText().toString();
                    history_textbox.setText(eq);

                    //Convert String to array
                    String[] array_string = bracketHandler(eq);

                    //Convert String to post fix
                    String post_fixed_string = postFix(array_string);
                    if(!post_fixed_string.equals("N/A")) {
                        double result = Calculate(post_fixed_string);

                        //Output
                        System.out.print(result);
                        output_textbox.setText("");
                        String outputStr = output_textbox.getText() + " = " + formatter.format(result);
                        output_textbox.setText(outputStr);
                    }else{
                        output_textbox.setText("Syntax Error");
                    }
                }  else{
                    output_textbox.setText("Syntax Error");
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
        StringBuilder result = new StringBuilder();

        Stack<String> stack = new Stack<>();

        for(String x:input){
            if(isNumeric(x))
                result.append(x).append(",");
            else if (x.equals("("))
                stack.push(x);
            else if(x.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("("))
                    result.append(stack.pop()).append(",");
                if(!stack.isEmpty() && !stack.peek().equals("("))
                    return "N/A";
                else
                    stack.pop();
            }else{
                while(!stack.isEmpty() && Prec(x) <= Prec(stack.peek())){
                    if(stack.peek().equals("("))
                        return "N/A";
                    result.append(stack.pop()).append(",");
                }
                stack.push(x);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals("("))
                return "N/A";
            result.append(stack.pop()).append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return result.toString();
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
        System.out.print("# Generated Tree: ");
        tree.printTree(root);
        return tree.evaluateTree(root);
    }


    /**
     * Handles Bracket's in equation
     * @param inputString String of equation (Must be in post-fix format).
     * @return String array of all operators and numbers
     */
    private String[] bracketHandler(String inputString){
        int left_bracket_count = 0;
        int right_bracket_count = 0;

        String[] array_string = inputString.trim().split(" ", 0);

        List<String> list = new LinkedList<>(Arrays.asList(array_string));
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.indexOf('(') > -1) {
                left_bracket_count++;
                String string_to_add = s.substring(s.indexOf('(') + 1);
                System.out.print(string_to_add);
                iterator.set("(");
                iterator.add(string_to_add);
            }
            if (s.indexOf(')') > -1) {
                right_bracket_count++;
                String string_to_add = s.substring(0, s.indexOf(')'));
                System.out.print(string_to_add);
                iterator.set(string_to_add);
                iterator.add(")");
            }
        }

        //Fixes bug above
        while(left_bracket_count != right_bracket_count){
            if (left_bracket_count > right_bracket_count){
                right_bracket_count++;
                list.add(")");
            }
            if (right_bracket_count > left_bracket_count){
                left_bracket_count++;
                list.add("(");
            }
        }

        Object[] objArray = list.toArray();
        array_string = Arrays.copyOf(objArray, objArray.length, String[].class);
        return array_string;
    }

}