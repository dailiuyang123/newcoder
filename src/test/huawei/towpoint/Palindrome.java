package test.huawei.towpoint;

public class Palindrome {

//    题目描述：可以删除一个字符，判断是否能构成回文字符串。
//
//    所谓的回文字符串，是指具有左右对称特点的字符串，例如 "abcba" 就是一个回文字符串。


    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {



    }


}
