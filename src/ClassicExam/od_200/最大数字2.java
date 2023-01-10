package ClassicExam.od_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 最大数字2 {

    /**
     *  题目描述
     * 给定一个由纯数字组成以字符串表示的数值，现要求字符串中的每个数字最多只能出现2次，超过的需要进行删除；
     *
     * 删除某个重复的数字后，其它数字相对位置保持不变。
     *
     * 如”34533″，数字3重复超过2次，需要删除其中一个3，删除第一个3后获得最大数值”4533″
     *
     * 请返回经过删除操作后的最大的数值，以字符串表示。
     *
     * 输入描述
     * 第一行为一个纯数字组成的字符串，长度范围：[1,100000]
     *
     * 输出描述
     * 输出经过删除操作后的最大的数值
     *
     * 用例
     * 输入	34533
     * 输出	4533
     *
     */
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        String string1 = in.nextLine();
        int[] nums = new int[string1.length()];
        for(int i=0; i<string1.length(); i++){
            nums[i] =string1.charAt(i) - 48;
        }

        get_max_number(nums);
    }

    // 字符串去重后个数
    public static void get_max_number(int[] nums) {
        // 统计出现次数 + 已经使用的次数
        HashMap<Integer,Integer> cnt = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> st_cnt = new HashMap<Integer,Integer>();

        for (int v : nums) {
            Integer num = cnt.get(v);
            cnt.put(v, num == null ? 1 : num + 1);
        }

        // 栈
        List<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        for (int x : nums) {
            // 已经使用2次，直接跳过
            if (st_cnt.containsKey(x) && st_cnt.get(x) == 2) {
                cnt.put(x, cnt.get(x)-1);
                continue;
            }
            // 当前数字大于栈尾数字，且栈尾数字出现超过2次
            while (x > res.get(res.size() - 1) && cnt.containsKey(res.get(res.size() - 1)) &&  cnt.get(res.get(res.size() - 1)) > 2) {
                cnt.put(res.get(res.size() - 1), cnt.get(res.get(res.size() - 1))-1);
                st_cnt.put(res.get(res.size() - 1), st_cnt.get(res.get(res.size() - 1))-1);
                res.remove(res.size() - 1);
            }
            res.add(x);
            Integer num = st_cnt.get(x);
            st_cnt.put(x, num == null ? 1 : num + 1);
        }

        for (int i = 1; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }


}
