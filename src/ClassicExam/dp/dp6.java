package ClassicExam.dp;

import java.util.Scanner;

public class dp6 {

    /**
     *  连续子数组最大和
     *  https://www.nowcoder.com/practice/1718131e719746e9a56fb29c40cc8f95?tpId=230&tqId=2225856&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=230
     */
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }

        int max = max(arr);


        System.out.println(max);
    }


    public static int max(int[] arr){

        if(arr==null|| arr.length==0){
            return -1;
        }
        // 数组最大值
        int res=arr[0];
        // 当前节点
        int curr=arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 当前节点值，与前一节点+当前节点值 ，取最大值
            curr=Math.max(arr[i],curr+arr[i]);
            res =Math.max(res,curr);
        }

        return res;
    }


}
