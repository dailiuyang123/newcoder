package ClassicExam.string;

public class NC229 {

    /**
     * 判断字符串是否唯一
     * <p>
     * https://www.nowcoder.com/practice/fb08c63e2c4f4f7dbf41086e46044211?tpId=196&tqId=39463&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=/exam/oj?tab=%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587&topicId=196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */

    public boolean isUnique(String str) {
        // write code here
        int[] ascc = new int[128];

        for (int i = 0; i < str.length(); i++) {
            if (ascc[str.charAt(i)] == 0) {
                ascc[str.charAt(i)] = 1;
            } else {
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args) {
        NC229 nc229=new NC229();
        boolean unique = nc229.isUnique("nowcOder");
        System.out.println(unique);
    }


}
