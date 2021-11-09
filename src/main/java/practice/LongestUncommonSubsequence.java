package practice;

public class LongestUncommonSubsequence {

    public static void main(String[] args) {
        String[] strs = new String[]{"aaa", "aa"};
        int lus = -1;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if(i==j){
                    continue;
                }
                if(longestUncommonSubsequence(strs[i], strs[j])){
                    if(strs[i].length() > lus){
                        lus = strs[i].length();
                    }

                }
            }
        }
        System.out.println(lus);
    }

    private static boolean longestUncommonSubsequence(String a, String b) {
//        if(a.length() > b.length()){
//            return false;
//        }
        String[] ar = a.split("");
        String[] br = b.split("");


        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < br.length; j++) {
                if (ar[i].equalsIgnoreCase(br[j])) {
                    if (i == ar.length - 1) {
                        return false;
                    }
                    i++;
                }
                break;
            }

        }
        return true;
    }
}
