package practice;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();

        int number1 = formNumber(num1Char);
        int number2 = formNumber(num2Char);

        return ""+number1*number2;


    }

    private static int formNumber(char[] num1Char) {
        int numConvert1[] = new int[num1Char.length];
        for (int i = 0; i < num1Char.length; i++) {
            switch (num1Char[i]) {
                case '0':
                    numConvert1[i] = 0;
                    break;
                case '1':
                    numConvert1[i] = 1;
                    break;
                case '2':
                    numConvert1[i] = 2;
                    break;
                case '3':
                    numConvert1[i] = 3;
                    break;
                case '4':
                    numConvert1[i] = 4;
                    break;
                case '5':
                    numConvert1[i] = 5;
                    break;
                case '6':
                    numConvert1[i] = 6;
                    break;
                case '7':
                    numConvert1[i] = 7;
                    break;
                case '8':
                    numConvert1[i] = 8;
                    break;
                case '9':
                    numConvert1[i] = 9;
                    break;
            }
        }
        int val=0;
        int j=0;
        for(int i=numConvert1.length-1;i>=0;i--){
            val+=numConvert1[i]*Math.pow(10,j);
            j++;
        }
        return val;
    }
}
