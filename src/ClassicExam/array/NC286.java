package ClassicExam.array;

public class NC286 {

    /**
     * 调整数组顺序使奇数位位于偶数位前面
     * https://www.nowcoder.com/practice/0c1b486d987b4269b398fee374584fc8?tpId=196&tqId=39737&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int[] reOrderArrayTwo(int[] array) {
        // write code here

        // 双指针解法
        int l = 0, r = array.length - 1;

        while (l < r) {

            if (array[l] % 2 == 0 && array[r] % 2 == 1) {
                // 交换位置：
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }

            if (array[l] % 2 == 1 && array[r] % 2 == 0) {
                l++;
                r--;
            }

            if (array[l] % 2 == 0 && array[r] % 2 == 0) {
                r--;
            }

            if (array[l] % 2 == 1 && array[r] % 2 == 1) {
                l++;
            }


        }

        return array;

    }


    public static void main(String[] args) {

        NC286 nc286=new NC286();
        int[] arr={1,4,4,3};
        int[] ints = nc286.reOrderArrayTwo(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }


}
