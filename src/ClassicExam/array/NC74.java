package ClassicExam.array;

public class NC74 {

    /**
     * 数字在升序数组中出现的次数
     * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=196&tqId=37106&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&difficulty=2&tags=578&difficulty=2&judgeStatus=undefined&tags=578&title=
     */

    // 双指针解法：
    public int GetNumberOfK(int[] array, int k) {

        int count = 0;
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (array[mid] == k) {
                count++;
                int up = mid + 1;
                int down = mid - 1;
                while (up < array.length && array[up] == k) {
                    up++;
                    count++;
                }
                while (down >= 0 && array[down] == k) {
                    down--;
                    count++;
                }
                break;
            }
            if (array[mid] > k) {
                r = mid - 1;
            }
            if (array[mid] < k) {
                l = mid + 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {


        NC74 nc74=new NC74();
        int[] arr={1,3,4,5};
        int i = nc74.GetNumberOfK(arr, 6);
        System.out.println(i);


    }


}
