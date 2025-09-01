package corejava;

public class Thread_State {
				/**
					* 2025/9/1
					* URL ：
					* 题目描述：
					**/
				
				public static void main(String[] args) throws InterruptedException {
								// 获取当前JVM中的所有线程
								Thread a = new A();
								Thread b = new A();
								// 线程对象创建
								System.out.println(a.getName() + ":" + a.getState());
								// 线程启动
								a.start();
								System.out.println(a.getName() + ":" + a.getState());
								b.start();
								
								System.out.println(System.currentTimeMillis());
								// 主线程等待
								Thread.sleep(1000);
								System.out.println(a.getName() + ":" + a.getState());
								System.out.println(b.getName() + ":" + b.getState());
								a.join();
								b.join();
								System.out.println(System.currentTimeMillis());
								System.out.println("Main end:"+A.a+"------------------");
								// 线程结束
								System.out.println(a.getName() + ":" + a.getState());
				}
				
				static class A extends Thread {
								
								static int a = 0;
								
								static Object lock = new Object();
								
								public void run() {
												
												for (int i = 0; i < 1000; i++) {
																synchronized (lock) {
																				a++;
																				if (i == 0) {
																								try {
																												Thread.sleep(5000);
																								} catch (InterruptedException e) {
																												throw new RuntimeException(e);
																								}
																				}
																}
												}
												
								}
				}
				
				
}
