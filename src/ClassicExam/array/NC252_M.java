package ClassicExam.array;

public class NC252_M {

    /**
     * 多数组中位数
     * https://www.nowcoder.com/practice/b6bb0bce88894108bfc23e9b7b012420?tpId=196&tqId=39670&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&page=1&tags=5058&difficulty=undefined&judgeStatus=undefined&tags=5058&title=
     */
    public int getUpMedian(int[] arr1, int[] arr2) {
        // write code here


        int sum = arr1.length + arr2.length;
        int[] cache = new int[sum];
        int mis = (sum / 2 + sum % 2) - 1;

        //
        int index_1 = 0;
        int index_2 = 0;
        try {
            for (int i = 0; i <= mis; i++) {


                if (index_1 >= arr1.length) {
                    cache[i] = arr2[index_2];
                    index_2++;
                    continue;
                }

                if (index_2 >= arr2.length) {
                    cache[i] = arr1[index_1];
                    index_1++;
                    continue;
                }

                if (arr1[index_1] > arr2[index_2]) {
                    cache[i] = arr2[index_2];
                    index_2++;
                    continue;
                }

                if (arr1[index_1] < arr2[index_2] ) {
                    cache[i] = arr1[index_1];
                    index_1++;
                    continue;
                }

                if (arr1[index_1] == arr2[index_2]) {
                    cache[i] = arr1[index_1];
                    index_1++;
                    i++;
                    cache[i] = arr2[index_2];
                    index_2++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cache[mis];

    }

    public static void main(String[] args) {
        NC252_M nc252_m = new NC252_M();

        int[] num = {1, 2, 3, 3, 4, 9, 10, 11, 12, 13, 14, 15};
        int[] num2 = {4, 15, 15, 25, 31, 36, 37, 43, 44, 47, 48, 50};
        int upMedian = nc252_m.getUpMedian(num, num2);
        System.out.println(upMedian);


    }


}
