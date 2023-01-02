package ClassicExam.dp;

public class NC68_跳台阶 {


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
     * （先后次序不同算不同的结果）。
     */
    public int jumpFloor(int target) {

        int[] cache = new int[target + 1];

        if (target <= 2) {
            return target;
        }

        cache[1] = 1;
        cache[2] = 2;

        int begin = 3;
        while (begin <= target) {
            cache[begin] = cache[begin - 1] + cache[begin - 2];
            begin++;
        }

        return cache[target];

    }


    public static void main(String[] args) {
        NC68_跳台阶 nc68_跳台阶 = new NC68_跳台阶();
        int i = nc68_跳台阶.jumpFloor(1);
        System.out.println(i);
    }


}
