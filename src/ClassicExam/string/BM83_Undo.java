package ClassicExam.string;

public class BM83_Undo {

    /**
     * 字符串变形
     * <p>
     * https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=295&tqId=44664&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */
    public String trans(String s, int n) {
        // write code here
        String[] s1 = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            String substring = s1[i];
            for (int j = 0; j < substring.length(); j++) {
                char c = substring.charAt(j);
                if (Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }

            if (i > 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BM83_Undo bm83Undo =new BM83_Undo();
        String this_is_a_sample = bm83Undo.trans("h i ", 4);
        System.out.println(this_is_a_sample);
    }


}
