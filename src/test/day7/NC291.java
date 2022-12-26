//package test.day7;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NC291 {
//
//
//    public static void main(String[] args) {
//
//        NC291 nc291 = new NC291();
//        int nthDigit = nc291.findNthDigit(1000000000);
//        List<Integer> list = new ArrayList<>();
//        ArrayDeque<> dq = new ArrayDeque<>();
//        System.out.println(nthDigit);
//    }
//
//    public String trans(String s, int n) {
//        // write code here
//        String[] arr = s.split(" ");
//        s = "";
//        for (int i = arr.length - 1; i >= 0; i--) {
//            for ( int j = 0; j < arr[i].length(); j++) {
//                if(arr[i].charAt(j)-'Z'>0){
//                    s+=(arr[i].charAt(j)+"").toLowerCase();
//                }else{
//                    s+=arr[i].charAt(j).toLowerCase();
//                }
//            }
//            s+=" ";
//
//        }
//        return s;
//    }
//
//
//    public int findNthDigit(int n) {
//
//        if(n<=9){
//            return n;
//        }
//        // write code here
//        int i = 0;
//        int cur = 0;
//        while (cur <= n) {
//            cur += (i + "").length();
//            i++;
//
//        }
//        System.out.println(i+":"+cur);
//
//        String a =( i + "").charAt((i + "").length() - cur % n) + "";
//        return Integer.valueOf(a);
//    }
//
//
//}
