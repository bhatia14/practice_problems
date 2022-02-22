package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BusiestServer {
    public static void main(String[] args) {
        int k=3;
        int[] a = new int[]{1,2,3,4,5};
        int[] load = new int[]{5,2,3,3,3};
        System.out.println(busiestServers(k, a, load).get(0));
    }

    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> list11 = new ArrayList<>();
        int[] servers = new int[k];
        int[] list1 = new int[k];
        int z=0;

        for(int i=0;i<k;i++){
            servers[i]=0;
            list1[i]=0;
        }


        for(int i=0;i<arrival.length;i++){
            for(int j=0;j<k;j++){
                if(servers[j] > 0){
                    servers[j]--;
                }
            }

            for(int j=0;j<k;j++){
                if(servers[j] == 0) {
                    servers[j] = load[i];
                    int x = list1[j];
                    list1[j]= ++x;
                    break;
                }
            }
        }
        //System.out.println(list1[0]);
        List<Integer> result = Arrays
                                .stream(list1)
                                .boxed()
                                .sorted()
                                .limit(1).collect(Collectors.toList());
        return result;
    }
}
