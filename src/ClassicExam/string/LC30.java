package ClassicExam.string;

import java.util.*;

public class LC30 {

    /**
     * 串联所有单词的子串 https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
     */


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int total = words.length * words[0].length();
        int cell = words[0].length();
        if (s.length() <= 0 || total > s.length()) {
            return list;
        }

        // exampleTest.hashtable + 滑动窗口
        Map<String, Integer> allwords = new HashMap<>();
        for (String word : words) {
            allwords.put(word, allwords.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + total <= s.length(); i++) {
            String substring = s.substring(i, i + total);
            Map<String, Integer> curr_words = new HashMap<>();
            // 字串固定长度分割
            int l = 0;
            int rights = 0;
            while (l + cell <= substring.length()) {
                String s1 = substring.substring(l, l + cell);
                if (!allwords.containsKey(s1)) {
                    break;
                }
                curr_words.put(s1, curr_words.getOrDefault(s1, 0) + 1);
                if (allwords.get(s1) < curr_words.get(s1)) {
                    break;
                }
                rights++;
                l += cell;
            }

            if (rights == words.length) {
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        LC30 lc30 = new LC30();
//        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String s = "barfoothefoobarman";
        String s = "aaa";
//        String[] arr = {"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
//        String[] arr = {"foo","bar"};
        String[] arr = {"a","a"};

        List<Integer> substring = lc30.findSubstring(s, arr);
        System.out.println(substring);


    }


}
