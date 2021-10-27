package practice;

public class StudentHandbook {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3,1,5,4};
        int arr2[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1)
                continue;
            arr2[i] += 1;
        }
        boolean flag = false;
        for (int i=0;i< arr2.length;i++){
            if(arr2[i] != 1){
                flag = true;
            }
        }
        if (flag){
            System.out.println(arr2);
        }
        else {
            System.out.println(arr);
        }
    }

}
