package test.leetcode.ary;

import java.util.Arrays;

public class TwoSum {

//    双指针 解法

    public static void main(String[] args) {
        int[] a = {-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = -2;

        int[] r= solution(a,target);
        if(r!=null){
            System.out.println(r[0]+","+r[1]);
        }


    }


//    题目描述：在有序数组中找出两个数，使它们的和为 target。

    public static int[] solution(int[] a, int target) {
        // target <= max  直接返回
        int r = a.length - 1;
        if (a[0]>0 && target < a[0]) {
            return null;
        } else {
            while (r >= 0) {
                for (int l = 0; l < r; l++) {
                    if (a[l] + a[r] == target) {
                        return new int[]{l, r};
                    } else if (a[l] + a[r] > target) {
                        break;
                    }
                }
                r--;
            }
            return null;
        }
    }


    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
