package com.example.calculatorapp;

import java.util.Stack;

/**
 * Creates a new Node for the expression tree
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
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    /**
     * Populates Tree
     * @param postfix String array of postFix expression
     * @return Root node of tree
     */
    Node populateTree(String[] postfix){
        Stack<Node> st = new Stack();
        Node t;
        Node t1;
        Node t2;
        for (String s : postfix) {
            if (!isOperator(s.trim())) {
                t = new Node(s.trim());
                st.push(t);
            } else {
                t = new Node(s.trim());

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

        return (left_value / right_value);
    }
}

