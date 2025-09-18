package corejava.面试.Java笔试题.类加载;

public class Child extends  Parent{
				/**
					* 2025/9/16
					* URL ：
					* 题目描述：
					**/
				static {
								System.out.println("子类静态代码块");
				}
				
				{
								System.out.println("子类普通代码块");
				}
				
				public Child() {
								System.out.println("子类构造方法");
				}
				
}
