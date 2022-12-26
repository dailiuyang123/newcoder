package ClassicExam.array;

public class NC77_M奇前偶后 {

    /**
     * 调整数组顺序使奇数位于偶数前面(一)
     * <p>
     * 输入一个长度为 n 整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * <p>
     * https://www.nowcoder.com/practice/ef1f53ef31ca408cada5093c8780f44b?tpId=196&tqId=37110&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&difficulty=3&tags=578&difficulty=3&judgeStatus=undefined&tags=578&title=
     */
    public int[] reOrderArray(int[] array) {
        // write code here

        int[] rs = new int[array.length];

        int index = 0;

        // 奇数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                rs[index] = array[i];
                index++;
            }
        }

        // 偶数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                rs[index] = array[i];
                index++;
            }
        }

        return rs;
    }



}
