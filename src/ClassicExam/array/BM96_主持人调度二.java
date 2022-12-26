package ClassicExam.array;

import java.util.Arrays;
import java.util.Comparator;

public class BM96_主持人调度二 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            //新开始的节目大于上一轮结束的时间，主持人不变
            if (start[i] >= end[j]) {
                j++;
            } else { //主持人增加
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        BM96_主持人调度二 bm96_主持人调度二 = new BM96_主持人调度二();
        int[][] arr = {{1, 3}, {2, 4}};
        int i = bm96_主持人调度二.minmumNumberOfHost(2, arr);
        System.out.println(i);

    }


}
