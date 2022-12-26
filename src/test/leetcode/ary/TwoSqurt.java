package test.leetcode.ary;

public class TwoSqurt {


    //    判断一个非负整数是否是两个整数地平方和
    public static boolean judgeSquareSum(int target) {

        int l = 0, r = (int) Math.sqrt(target);
        while (l <= r) {
            int twoPow = l * l + r * r;
            if (target == twoPow) {
                return true;
            } else if (target > twoPow) {
                l++;
            } else {
                r++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int target=8;
        boolean b = judgeSquareSum(target);
        System.out.println(b);


    }


}
