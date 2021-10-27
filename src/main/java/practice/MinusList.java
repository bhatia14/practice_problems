package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinusList {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();

        a.add("hello");
        a.add("i");
        a.add("love");
        a.add("Coding");

        HashSet<String> hs = new HashSet<>(a);



        List<String> b = new ArrayList<>();

        b.add("hello");
        b.add("i");
        b.add("love");
        b.add("too");

      //  HashSet<String> hs2 = new HashSet<>(b);
        System.out.println(b.removeAll(a));
        System.out.println(b);

    }
}
