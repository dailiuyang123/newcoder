package ClassicExam.string;

public class BM22_比较版本号 {

    /**
     * 牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
     * 现在给你2个版本号version1和version2，请你比较他们的大小
     * 版本号是由修订号组成，修订号与修订号之间由一个"."连接。1个修订号可能有多位数字组成，修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
     * 每个版本号至少包含1个修订号。
     * 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。
     * <p>
     * 比较规则：
     * 一. 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。比如"0.1"和"0.01"的版本号是相等的
     * 二. 如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，"1.1"的版本号小于"1.1.1"。因为"1.1"的版本号相当于"1.1.0"，第3位修订号的下标为0，小于1
     * 三.  version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
     * <p>
     * https://www.nowcoder.com/practice/2b317e02f14247a49ffdbdba315459e7?tpId=295&tqId=1024572&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=/exam/oj
     */
    public int compare(String version1, String version2) {
        // write code here

        String[] split = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int max = Math.max(split.length, split2.length);
        for (int i = 0; i < max; i++) {

            int i1 = 0;
            if (i < split.length) {
                i1 = Integer.valueOf(split[i]);
            }

            int i2 = 0;
            if (i < split2.length) {
                i2 = Integer.valueOf(split2[i]);
            }

            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }

        return 0;

    }


    public static void main(String[] args) {
        BM22_比较版本号 bm22_比较版本号 = new BM22_比较版本号();
        int compare = bm22_比较版本号.compare("0.226", "0.36");
        System.out.println(compare);
    }


}
