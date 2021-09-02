package practice;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        HashSet<String> set = new HashSet<>();
        List<String> strings = new ArrayList<>();
        for (; ; ) {
            set.add(RandomStringUtils.random(n * 2, "()"));
            if (set.size() == Math.pow(4, n)) {
                break;
            }
        }
        set.forEach(s -> {
            Deque<Character> stack = new ArrayDeque<>();
            if (checkSequence(stack, s)) {
                strings.add(s);
            }
        });
        return strings;
    }

    private static boolean checkSequence(Deque<Character> stack, String s) {
        char[] val = s.toCharArray();
        for (int i = 0; i < val.length; i++) {
            char x = val[i];
            if (x == '(') {
                stack.push(val[i]);
                continue;
            }
            switch (x) {
                case ')':
                    char x1;
                    try {
                        x1 = stack.pop();
                    } catch (Exception e) {
                        return false;
                    }
                    if (x1 != '(') {
                        return false;
                    }
                    break;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

}
