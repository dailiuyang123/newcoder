package ClassicExam.hashtable;

import java.util.*;

public class HJ8 {

    /**
     * 合并表记录
     *
     */

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            map.put(key,map.getOrDefault(key,0)+value);
        }

        Set<Integer> integers = map.keySet();
        ArrayList<Integer> integers1 = new ArrayList<>(integers);
        Collections.sort(integers1);
        for (int i = 0; i < integers1.size(); i++) {
            System.out.println(integers1.get(i)+" "+map.get(integers1.get(i)));
        }


    }


}
