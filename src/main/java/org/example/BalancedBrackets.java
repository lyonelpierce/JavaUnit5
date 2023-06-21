package org.example;

import java.util.Stack;

public class BalancedBrackets {

    // Balanced Parenthesis
    public static boolean balancedParenthesis(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Balanced Brackets
    public static boolean balancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '<' && close == '>');
    }

    public static void main(String[] args) {
        String input1 = "(())";
        boolean isBalancedParenthesis = balancedParenthesis(input1);
        System.out.println("Is balanced parenthesis? " + isBalancedParenthesis);

        String input2 = "{[()]}";
        boolean isBalancedBrackets = balancedBrackets(input2);
        System.out.println("Is balanced brackets? " + isBalancedBrackets);
    }
}
