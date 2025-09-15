package corejava.面试;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 实现线程安全的LRU缓存 {
				/**
					* 2025/9/13
					* URL ：
					* 题目描述：请你实现一个 LRU（最近最少使用）缓存，要求线程安全。
					**/
				
				static class ThreadSafeLRUCache<K, V> {
								
								private final Map<K, Node> cache;
								
								private final int capacity;
								
								private final Node head;
								
								private final Node tail;
								
								// 读写锁
								private final ReadWriteLock lock = new ReentrantReadWriteLock();
								private final Lock readLock = lock.readLock();
								private final Lock writeLock = lock.writeLock();
								
								
								ThreadSafeLRUCache(int capacity) {
												this.cache = new HashMap<>();
												this.capacity = capacity;
												
												// 初始化头尾节点
												this.head = new Node<>(null, null);
												this.tail = new Node<>(null, null);
												head.next = tail;
												tail.prev = head;
								}
								
								
								// ToDo 双向链表相关方法
								
								// 添加节点到链表头部
								private void addHead(Node node) {
												node.prev = head;
												node.next = head.next;
												
												// todo 赋值语句顺序，错误导致堆溢出！！！
												head.next.prev = node;
												head.next = node;
												
								}
								
								// 删除节点
								private void removeNode(Node node) {
												node.prev.next = node.next;
												node.next.prev = node.prev;
								}
								
								// 移动节点到链表头部
								private void moveToHead(Node node) {
												removeNode(node);
												addHead(node);
								}
								
								// 删除链表尾部节点
								private void removeTail() {
												Node node = tail.prev;
												removeNode(node);
								}
								
								@Override
								public String toString() {
												readLock.lock();
												try {
																StringBuilder sb = new StringBuilder();
																sb.append("[");
																Node current = head.next;
																while (current != tail) {
																				sb.append(current.key).append("=").append(current.value);
																				if (current.next != tail) {
																								sb.append(", ");
																				}
																				current = current.next;
																}
																sb.append("]");
																return sb.toString();
												} finally {
																readLock.unlock();
												}
								}
								
								// 获取缓存
								public V get(K key) {
												readLock.lock();
												try {
																if (!cache.containsKey(key)) {
																				return null;
																}
																
																Node node = cache.get(key);
																// 将访问的节点移动到链表头部（表示最近使用）
																moveToHead(node);
																return (V) node.value;
												} finally {
																readLock.unlock();
												}
								}
								
								// 添加缓存
								public void put(K key, V value) {
												
												writeLock.lock();
												try {
																if (cache.containsKey(key)) {
																				Node node = cache.get(key);
																				node.value = value;
																				moveToHead(node);
																				removeNode(node);
																} else {
																				Node node = new Node<>(key, value);
																				
																				cache.put(key, node);
																				addHead(node);
																				
																				if (cache.size() > capacity) {
																								removeTail();
																								cache.remove(tail.key);
																				}
																				
																}
												} finally {
																writeLock.unlock();
												}
												
								}
								
								// 删除缓存
								public void remove(K key) {
												writeLock.lock();
												try {
																if (cache.containsKey(key)) {
																				Node node = cache.get(key);
																				removeNode(node);
																				cache.remove(key);
																}
												}finally {
																writeLock.unlock();
												}
								}
								
								// 清空缓存
								public void clear() {
												writeLock.lock();
												try {
																cache.clear();
																head.next = tail;
																tail.prev = head;
												} finally {
																writeLock.unlock();
												}
								}
								
								
								class Node<K, V> {
												K key;
												V value;
												Node<K, V> prev;
												Node<K, V> next;
												
												public Node(K key, V value) {
																this.key = key;
																this.value = value;
												}
								}
								
								
				}
				
				
}
