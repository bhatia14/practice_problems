package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] strings = new String[]{"i","love","leetcode","i","love","coding"};
        topKFrequent(strings, 2);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        List<Words> list = new ArrayList<>();
        for(int i=0;i< words.length;i++){
            if(map.containsKey(words[i])){
                int x= map.get(words[i]);
                map.put(words[i],++x);
            }
            else {
                map.put(words[i],1);
            }
        }

        List<Words> finalList = list;
        map.forEach((s, integer) -> {
            Words w = new Words();
            w.setCount(integer);
            w.setWord(s);
            finalList.add(w);
        });
        list = list.stream().sorted(Comparator.comparing(Words::getWord)).collect(Collectors.toList());
        list = list.stream().sorted(Comparator.comparing(Words::getCount).reversed()).collect(Collectors.toList());

        List<String> sol = new ArrayList<>();

        for(int i=0;i<k;i++){
            sol.add(list.get(i).getWord());
        }
        return sol;
    }

    public static class Words{
        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        private String word;
        private Integer count;

    }
}
