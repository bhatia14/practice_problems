package practice;

import java.util.Stack;
import java.util.stream.Stream;

public class BasicCalculatorII {
    public static void main(String[] args) {
        calculate("3+2*2");
    }

    public static int calculate(String s) {

        char[] arr = s.toCharArray();
        Stack<Integer> numb = new Stack<>();
        Stack<Character> exp = new Stack<>();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                if (exp.empty()) {
                    exp.push(arr[i]);
                } else {
                    char x = exp.pop();
                    if (checkPriority(arr[i], x)) {
                        exp.push(x);
                        numb.push(evaluateExpression(arr[i],numb.pop(), numb.pop()));
                    } else {
                        exp.push(x);
                        exp.push(arr[i]);
                    }

                }
            } else {
                numb.push(Integer.parseInt(String.valueOf(arr[i])));
            }
            i++;
        }
        return  0;

    }

    static boolean checkPriority(char ex, char compare) {
        switch(ex) {
            case '/':
                return true;
            case '*':
                return (compare == '+' || compare == '-' || compare == '*') ? true : false;
            default :
                return true;
        }
    }

    static int evaluateExpression(char ex, int value1, int value2) {
        switch(ex) {
            case '/':
                return  Integer.parseInt(String.valueOf(value2))/Integer.parseInt(String.valueOf(value1));
            case '*':
                return Integer.parseInt(String.valueOf(value2))*Integer.parseInt(String.valueOf(value1));
            case '+':
                return Integer.parseInt(String.valueOf(value2))+Integer.parseInt(String.valueOf(value1));
            case '-':
                return Integer.parseInt(String.valueOf(value2))-Integer.parseInt(String.valueOf(value1));
        }
        return  0;
    }
}
