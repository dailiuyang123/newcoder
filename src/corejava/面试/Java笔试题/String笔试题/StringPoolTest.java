package corejava.面试.Java笔试题.String笔试题;

public class StringPoolTest {
				/**
					* 2025/9/16
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								String s1 = "abc";
								String s2 = new String("abc");
								String s3 = s2.intern();
								System.out.println(s1 == s2);
								System.out.println(s1 == s3);
//								StringBuffer  线程安全/ synchronized
				
				}
				
}
