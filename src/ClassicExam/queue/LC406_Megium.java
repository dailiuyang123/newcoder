package ClassicExam.queue;

import java.util.*;

public class LC406_Megium {


    /**
     * 根据身高重建队列 https://leetcode.cn/problems/queue-reconstruction-by-height/
     * <p>
     * 假设有打乱顺序的一群人站成一根队列，数组people 表示队列中一些人的属性
     * 每个people[i]=[h1,k1] 表示第i个人的身高为hi，前面正好有ki个身高大于或等于
     * hi的人。
     */
    public int[][] reconstructQueue(int[][] people) {

        // 根据身高，进行排序降序，k升序

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        // 创建一个list集合便于插入操作。

        List<int[]> list = new LinkedList<>();

        for (int[] person : people) {

            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][2]);


    }


    public static void main(String[] args) {

        LC406_Megium lc406_megium = new LC406_Megium();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = lc406_megium.reconstructQueue(people);


    }


}
