package com.yany.leetcode;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 */
public class _150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(new _150_EvaluateReversePolishNotation().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            int num1, num2;
            if ("+".equals(token)) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 + num2));
            } else if ("-".equals(token)) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2 - num1));
            } else if ("*".equals(token)) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num1 * num2));
            } else if ("/".equals(token)) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2 / num1));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
