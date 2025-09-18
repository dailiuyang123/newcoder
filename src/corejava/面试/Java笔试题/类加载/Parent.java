package corejava.面试.Java笔试题.类加载;

public class Parent {
				/**
					* 2025/9/16
					* URL ：
					* 题目描述：
					**/
				static {
								System.out.println("父类静态代码块");
				}
				
				{
								System.out.println("父类普通代码块");
				}
				
				public Parent() {
								System.out.println("父类构造方法");
				}
				
				void show() {
								System.out.println("父类show方法");
				}
}
