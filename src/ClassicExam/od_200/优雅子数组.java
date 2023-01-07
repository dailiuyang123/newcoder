package ClassicExam.od_200;

import java.util.*;

public class 优雅子数组 {

    /**
     *
     *
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split("\\ ");
        int n = Integer.valueOf(split[0]);
        int k = Integer.valueOf(split[1]);
        String s2 = in.nextLine();
        String[] split1 = s2.split("\\ ");


        Set<String> rs = new HashSet<>();

        for (int i = 0; i < split1.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j = i; j < split1.length; j++) {
                map.put(split1[j], map.getOrDefault(split1[j], 0) + 1);
                if (map.get(split1[j]) >= k) {
                    rs.add(split1[j]);
                }
            }
        }

        System.out.println(rs.size());

    }


}
