package practice;

import java.util.*;

public class GenerateParentheses_WithoutLibrary {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        HashSet<String> set = new HashSet<>();
        List<String> strings = new ArrayList<>();
        for (; ; ) {
            set.add(random(n * 2, "()"));
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

    public static String random(int count, String chars) {
        return chars == null ? random(count, 0, 0, false, false, (char[]) null, RANDOM) : random(count, chars.toCharArray());
    }

    public static String random(int count, char... chars) {
        return chars == null ? random(count, 0, 0, false, false, (char[]) null, RANDOM) : random(count, 0, chars.length, false, false, chars, RANDOM);
    }

    public static String random(int count, int start, int end, boolean letters, boolean numbers, char[] chars, Random random) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        } else if (chars != null && chars.length == 0) {
            throw new IllegalArgumentException("The chars array must not be empty");
        } else {
            if (start == 0 && end == 0) {
                if (chars != null) {
                    end = chars.length;
                } else if (!letters && !numbers) {
                    end = 1114111;
                } else {
                    end = 123;
                    start = 32;
                }
            } else if (end <= start) {
                throw new IllegalArgumentException("Parameter end (" + end + ") must be greater than start (" + start + ")");
            }

//            int zero_digit_ascii = true;
//            int first_letter_ascii = true;
            if (chars == null && (numbers && end <= 48 || letters && end <= 65)) {
                throw new IllegalArgumentException("Parameter end (" + end + ") must be greater then (" + 48 + ") for generating digits or greater then (" + 65 + ") for generating letters.");
            } else {
                StringBuilder builder = new StringBuilder(count);
                int gap = end - start;

                while (true) {
                    while (count-- != 0) {
                        int codePoint;
                        if (chars == null) {
                            codePoint = random.nextInt(gap) + start;
                            switch (Character.getType(codePoint)) {
                                case 0:
                                case 18:
                                case 19:
                                    ++count;
                                    continue;
                            }
                        } else {
                            codePoint = chars[random.nextInt(gap) + start];
                        }

                        int numberOfChars = Character.charCount(codePoint);
                        if (count == 0 && numberOfChars > 1) {
                            ++count;
                        } else if ((!letters || !Character.isLetter(codePoint)) && (!numbers || !Character.isDigit(codePoint)) && (letters || numbers)) {
                            ++count;
                        } else {
                            builder.appendCodePoint(codePoint);
                            if (numberOfChars == 2) {
                                --count;
                            }
                        }
                    }

                    return builder.toString();
                }
            }
        }
    }


}
