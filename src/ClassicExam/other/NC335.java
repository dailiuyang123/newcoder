package ClassicExam.other;

public class NC335 {

    /**
     * excel 表列序号
     */

    public int getNumber(String S) {
        // write code here
        S = S.toUpperCase();
        int sum = 0;

        int carry = 1;
        for (int i = S.length() - 1; i >= 0; i--) {
            int curr = (S.charAt(i) - 'A') + 1;
            sum += curr * carry;
            carry = carry * 26;
        }

        return sum;

    }

    public static void main(String[] args) {

        NC335 nc335 = new NC335();
        int aa = nc335.getNumber("m");
        System.out.println(aa);

    }


}
