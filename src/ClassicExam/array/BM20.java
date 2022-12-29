package ClassicExam.array;

public class BM20 {

    /**
     * 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
     * <p>
     * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=295&tqId=23260&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */

    /**
     * 暴力，超时
     */
    public int InversePairs(int[] array) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                    count %= 1000000007;
                }
            }
        }

        return count;
    }

    /**
     * 采用归并排序解法
     */





    public static void main(String[] args) {

        BM20 bm20 = new BM20();
        int[] nums = {1, 2, 3};
        int i = bm20.InversePairs(nums);
        System.out.println(i);
    }


}
