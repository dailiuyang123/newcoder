package corejava;

public class ValueTest {
				/**
					* 2025/7/17
					* URL ：
					* 题目描述：
					**/
				
				
				/**
					* @Param StringBuilder sb 复制的sb的引用
					*/
				public static void valueStringBuilder(StringBuilder sb) {
								// 通过拷贝的引用，对值进行修改
								sb.append(" world");
								// 拷贝的引用指向新对象,原本引用值不变
								sb = new StringBuilder("world");
								// world
								System.out.println("函数内部，复制sb引用指针："+sb);
				}
				
				public static void valueInt(int a) {
								a++;
				}
				
				public static void main(String[] args) {
								System.out.println("===============Java是值传递，不是引用传递=====================");
								System.out.println("===============引用对象：拷贝引用地址=====================");
								StringBuilder sb = new StringBuilder("hello");
								valueStringBuilder(sb);
								// hello world
								System.out.println(sb);
								
								System.out.println("--------------------基本类型：值传递-----------------------------");
								int a = 0;
								valueInt(a);
								System.out.println(a);
				}
				
				
}
