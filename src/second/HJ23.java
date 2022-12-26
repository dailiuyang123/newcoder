package second;

import java.util.*;
import java.util.stream.Stream;

public class HJ23 {

    /**
     * 删除字符串中出现次数最少的字符
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Integer min = map.values().stream().filter(o -> o > 0).sorted().findFirst().get();

        for (Character character : map.keySet()) {
            if (map.get(character).equals(min)) {
                s = s.replaceAll(character + "", "");
            }
        }

        System.out.println(s);

    }


}
