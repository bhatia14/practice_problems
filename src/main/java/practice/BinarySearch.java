package practice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = new int[]{1,2,3,4,5,6};
        int value=0;
        int find=2;

        int start = 0;
        int end = list.length-1;
        //int mid = 0;

        while(start <= end) {
            value = start + (end-1)/2;
            if(list[value] == find) {
                break;
            }
            else if (list[value] < find){
                start = value+1;
            }
            else {
                end = value-1;
            }
        }

        System.out.println(value);
    }
}
