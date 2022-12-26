package ClassicExam.array;

public class NC276 {

    /**
     * 构建乘积数组
     * <p>
     * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=196&tqId=39727&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int[] multiply(int[] A) {

        if (A.length <= 1) {
            return A;
        }

        int[] rs = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int dump = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                dump = dump * A[j];
            }
            rs[i] = dump;
        }
        return rs;

    }


    public static void main(String[] args) {
        NC276 nc276=new NC276();
        int[] a=new int[]{100,50};
        int[] multiply = nc276.multiply(a);
        for (int i = 0; i < multiply.length; i++) {
            System.out.println(multiply[i]);
        }

    }



}
