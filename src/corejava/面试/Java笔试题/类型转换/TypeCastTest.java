package corejava.面试.Java笔试题.类型转换;

public class TypeCastTest {
				/**
					* 2025/9/16
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								int i = 128;
								byte b = (byte) i;
								System.out.println(b);
								
								float a = 0.1f;
								float c = 0.2f;
								float d = a + c;
								
							
								char ch='中'; // char 占两个字节，可以存放中文字符
								
								System.out.println(d);
								System.out.println(0.1 + 0.2);
								System.out.println(d == 0.3f); // true
								System.out.println(d == (0.1 + 0.2)); // false
								System.out.println(d == (0.1f + 0.2f)); // true
								
								// 浮点数运算,类型以精度最大的为准
								float v = 1 + 0.1f;
								System.out.println(v == 1.1f);
								System.out.println(v == (1 + 0.1f));
								
								double v1 = 0.1f + 0.2d;
								
								// 25/2 的结果是什么?
								double doubleValue = 25 / 2;
								System.out.println("double d=35/2 : d:" + doubleValue);
								
				}
				
				protected static void test() {
				
				}
}
