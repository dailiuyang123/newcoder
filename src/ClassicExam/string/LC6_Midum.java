package ClassicExam.string;

import java.util.List;

public class LC6_Midum {

    /**
     * z 子型变换
     */
    public String convert(String s, int numRows) {

        int length = s.length();

        List<Character>[] map = new List[numRows];

        int cycle = numRows * 2 - 2;
        int curr_hight = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int w = 0;


            map[curr_hight].add(w, c);
            if (curr_hight == numRows - 1) {
                curr_hight += -1;
            }
            if (curr_hight == 0) {
                curr_hight += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {

            String s1 = String.valueOf(map[i]);
            sb.append(s1);

        }
        return sb.toString();
    }


}
