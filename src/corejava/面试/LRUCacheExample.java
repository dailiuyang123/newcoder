package corejava.面试;

public class LRUCacheExample {
				/**
					* 2025/9/15
					* URL ：
					* 题目描述：
					**/
				public static void main(String[] args) {
								实现线程安全的LRU缓存.ThreadSafeLRUCache cache = new 实现线程安全的LRU缓存.ThreadSafeLRUCache(3);
								cache.put("one", 1);
								cache.put("two", 2);
								cache.put("three", 3);
								System.out.println("初始缓存: " + cache);
								
								// 访问元素，这会改变LRU顺序
								System.out.println("获取two: " + cache.get("two")); // 2
								System.out.println("访问后缓存: " + cache); // [one=1, three=3, two=2]
								// 添加新元素，会淘汰最近最少使用的元素
								cache.put("four", 4);
								System.out.println("添加第四个元素后: " + cache); // [three=3, two=2, four=4]
				
				}
}
