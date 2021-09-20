package practice;

public class LargestPalindromeProduct {
    public static void main(String[] args) {
        int n = 5;
        int number = (int) (Math.pow(10, n) - 1);
        int lowerBound = (int) (Math.pow(10, n - 1) - 1);
        boolean flag;
        int sol = 0;
        int tempNumb = number;
        int i;
        int tempCount = 0;
        int tempCount2 = 0;
        while (tempNumb != 0) {
            for (i = number; i > lowerBound; i--) {
                flag = checkPalindrome(tempNumb * i);
                if (flag && sol < tempNumb * i) {
                    sol = tempNumb * i;
                    tempCount = tempNumb;
                    tempCount2 = i;
                    break;
                }
            }
            if (tempNumb < lowerBound) {
                break;
            }
            tempNumb--;
        }
        System.out.println(sol % 1337);
    }

    private static boolean checkPalindrome(int number) {

        String str = number + "";

        int strLength = str.length();
        String reverseStr = "";
        for (int i = (strLength - 1); i >= 0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
        if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
            return true;
        }
        return false;
    }
}
