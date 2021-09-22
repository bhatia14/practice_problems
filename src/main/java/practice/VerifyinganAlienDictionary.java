package practice;

import java.util.HashMap;

public class VerifyinganAlienDictionary {
    public static void main(String[] args) {
        String[] words = new String[]{"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        String order = "zkgwaverfimqxbnctdplsjyohu";
        System.out.println(isAlienSorted(words, order));
    }

    private static boolean isAlienSorted(String[] words, String order) {
        char[] orderArray = order.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < orderArray.length; i++) {
            map.put(orderArray[i], i + 1);
        }

        for (int i = 0; i < words.length; i++) {
            {
                if (i == words.length - 1) {
                    return true;
                }
                char[] wordChar = words[i].toCharArray();
                char[] wordChar2 = words[i + 1].toCharArray();
                int len = 0;
                if (wordChar.length > wordChar2.length) {
                    len = wordChar2.length;
                } else {
                    len = wordChar.length;
                }

                if(map.get(wordChar[0]) < map.get(wordChar2[0])){
                    continue;
                }

                for (int j = 0; j < len; j++) {

                   if(map.get(wordChar[j]) > map.get(wordChar2[j])){
                       return false;
                   }

                }

                    if(words[i].substring(0, len).equals(words[i+1].substring(0,len))
                    && wordChar.length > wordChar2.length){
                        return false;
                    }
                }


            }

        return true;
    }
}
