package second;

public class NC73 {

    /**
     * 给一个长度为 N的数组，数组种有一个数字出现的次数超过数组长度的一半
     * ，请找出这个数字
     */


    public static void main(String[] args) {


    }

    // 滑动窗口
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int l = array.length / 2;
        for (int i = 0; i + l < array.length; i++) {
            if (array[i] == array[i + l]) {
                return array[i];
            }
        }

        return 0;
    }


}
