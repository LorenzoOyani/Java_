package org.example.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixPostfix {

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';

    }

    public static int precedence(char symbol) {
        return switch (symbol) {
            case '+', '-' -> 1;
            case '/', '*' -> 2;
            case '^' -> 3;
            default -> -1;
        };

    }

    public static String InfixToPostFix(String infix) {
        Stack<Character> stacks = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < infix.length() && Character.isLetterOrDigit(infix.charAt(i))) {
                    sb.append(infix.charAt(i));
                    i++;
                }
                i--;
                list.add(sb.toString());
            } else if (isOperator(c)) {
                while (!stacks.empty() && precedence(stacks.peek()) >= precedence(c)) {
                    list.add(Character.toString(stacks.pop()));

                }
                stacks.push(c);


            } else if (c == '(') {
                stacks.push(c);

            } else if (c == ')') {
                while (!stacks.isEmpty() && stacks.peek() != '(') {
                    list.add(Character.toString(stacks.pop()));
                }
                stacks.pop();

            }
            while (!stacks.isEmpty()) {
                list.add(Character.toString(stacks.pop()));
            }

        }
        return String.join("", list);

    }

    public static void main(String[] args) {
        String infix = "3 + 4 * (2 -1 )";
        String postfix = InfixToPostFix(infix);
        System.out.println(STR."postfix \{postfix}");
    }
}
