package test.day16;

import java.util.Arrays;

public class SayNumberGame {

    //一百个小朋友围坐在一起，报数


    public static void main(String[] args) {

        int M = 3;
        int[] arr = new int[100];
        int step = 1;
        int count = 100;
        for (int i = 0; i < 101; i++) {
            if (i == 100) {
                i = 0;
            }
            if (step == M && arr[i] == 0) {
                arr[i] = 1;
                step = 1;
                count -= 1;
                if (count < M) {
                    break;
                }
            }
            if (arr[i] == 0) {
                step += 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                System.out.print(i+1+" ");
            }
        }
//        System.out.println(Arrays.toString(arr));


    }

}
