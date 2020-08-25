package com.example.calculatorapp;

import java.util.Stack;

/**
 * Creates a new Node for the expression tree
 * @param item Value to be inserted into node
 */

class Node {
    String value;
    Node left, right;

    Node(String item){
        this.value = item;
        this.left = this.right = null;
    }
}

class ExpressionTree {
    /**
     * Checks if string is operator
     * @param c String to be checked
     * @return True if operator else false
     */
    private boolean isOperator(String c) {
        if (c.equals("+") || c.equals("-") || c.equals("*")  || c.equals("/") || c.equals("^") ) {
            return true;
        }
        return false;
    }
    /**
     * Populates Tree
     * @param postfix String array of postFix expression
     * @return Root node of tree
     */
    Node populateTree(String postfix[]){
        Stack<Node> st = new Stack();
        Node t, t1, t2;
        for(int i = 0; i < postfix.length; i++){
            if(!isOperator(postfix[i].trim())){
                t = new Node(postfix[i].trim());
                st.push(t);
            }else{
                t = new Node(postfix[i].trim());

                //Pop two top nodes
                //Store top
                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }

    /**
     * Prints Tree
     * @param root root node of any tree
     */
    void printTree(Node root){
       if(root != null){
           printTree(root.left);
           System.out.println(root.value + " ");
           printTree(root.right);
       }
    }

    /**
     * Evaluates an expression tree
     * @param root root node of any tree
     * @return Value of tree
     */
    Double evaluateTree(Node root){
        //If root is null || if root is the only node in tree
        if(root == null)
            return 0.0;
        if(root.left == null && root.right == null)
            return Double.parseDouble(root.value);

        //Evaluate each side
        double left_value = evaluateTree(root.left);
        double right_value = evaluateTree(root.right);

        if(root.value.equals("+"))
            return left_value + right_value;

        if(root.value.equals("-"))
            return left_value - right_value;

        if(root.value.equals("*"))
            return left_value * right_value;

        return (double)(left_value / right_value);
    }


}

