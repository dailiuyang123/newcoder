package od_2024_e.回溯;

import java.util.*;

public class 外卖员跑单组合 {
				/**
					* 2025/3/20
					* URL ：
					* 题目描述：题目描述
					* 某城市片区有两个外卖站点，考虑到夜间也有外卖需求，但是需求不多，因此每个站点至多安排 5 个外卖员值夜班。
					* <p>
					* 当有外卖订单产生时，哪个站点能抢单成功，取决于该站点的值班人数，具体规则如下：
					* <p>
					* 当订单数量达到 1 个运力标准时，站点值班人数优先级为：5 > 2 > 4 > 3 > 1，即优先 5 人值班的站点抢单成功，次优 2 人值班的站点抢单成功，.....，依次类推
					* 当订单数量达到 2 个运力标准时，站点值班人数优先级为：5 > 4 > 3 > 2
					* 当订单数量达到 3 个运力标准时，站点值班人数优先级为：4 > 5 > 3
					* 当订单数量达到 4 个运力标准时，站点值班人数优先级为：5 > 4
					* 当订单数量达到 5 个运力标准时，此时只要站点有 5 人值班，那么就有机会抢单成功
					* 当订单数量达到 10 个运力标准时，只有两个站点都有 5 人值班，才能抢单成功。
					* 当站点抢单成功后，假设此站点有 m 个人值班，订单需要 n 个（人）运力，那么请输出 m 选 n 的所有跑单组合。
					* <p>
					* 输入描述
					* 第一行首先输入一个整数 x，表示站点 1 的值班人数，之后输入 x 个正整数，分别代表对应外卖员的工号，输入的数据之间以空格分隔。
					* <p>
					* 第二行首先输入一个整数 y，表示站点 2 的值班人数，之后输入 y 个正整数，分别代表对应外卖员的工号，输入的数据之间以空格分隔。
					* <p>
					* 第三行输入外卖订单到达的运力标准 n。
					* <p>
					* 注意：
					* <p>
					* 0 ≤ x,y ≤ 5
					* 不会存在重复工号，工号取值 [1, 100]
					* 运力标准 n 只会取值 1，2， 3，4，5，10
					* 输出描述
					* 每个跑单组合输出一行，组合内元素之间以空格分隔。
					**/
				
				
				static Map<Integer, List<Integer>> map = new HashMap<>();
				
				static ArrayList<ArrayList<String>> res = new ArrayList<>();
				
				static {
								map.put(1, Arrays.asList(new Integer[]{5, 2, 4, 3, 1}));
								map.put(2, Arrays.asList(new Integer[]{5, 4, 3, 2}));
								map.put(3, Arrays.asList(new Integer[]{4, 5, 3}));
								map.put(4, Arrays.asList(new Integer[]{5, 4}));
								map.put(5, Arrays.asList(new Integer[]{5}));
				}
				
				
				public static void main(String[] args) {
								Scanner in = new Scanner(System.in);
								int x = in.nextInt();
								int[] numx = new int[x];
								for (int i = 0; i < x; i++) {
												numx[i] = in.nextInt();
								}
								int y = in.nextInt();
								int[] numy = new int[y];
								for (int i = 0; i < y; i++) {
												numy[i] = in.nextInt();
								}
								int n = in.nextInt();
								
								if (map.containsKey(n)) {
												if (x < n && y < n) {
																System.out.println("null");
																return;
												}
												if (x < n && y >= n) {
																dfs(0, n, numy, new LinkedList<>());
												}
												
												if (y < n && x >= n) {
																dfs(0, n, numx, new LinkedList<>());
												}
												
												List<Integer> list = map.get(n);
												if (list.indexOf(x) < list.indexOf(y)) {
																dfs(0, n, numx, new LinkedList<>());
												} else if (list.indexOf(x) > list.indexOf(y)) {
																dfs(0, n, numy, new LinkedList<>());
												} else {
																dfs(0, n, numx, new LinkedList<>());
																dfs(0, n, numy, new LinkedList<>());
												}
												
												for (ArrayList<String> re : res) {
																String join = String.join(" ", re);
																System.out.println(join);
												}
												return;
												
								} else {
												if (x + y == 10) {
																StringJoiner sj = new StringJoiner(" ");
																for (int i : numx) {
																				sj.add(i + "");
																}
																for (int i : numy) {
																				sj.add(i + "");
																}
																System.out.println(sj.toString());
																return;
												} else {
																System.out.println("null");
																return;
												}
								}
								
				}
				
				private static void dfs(int index, int n, int[] nums, LinkedList<String> path) {
								
								if (path.size() == n) {
												res.add(new ArrayList<>(path));
												return;
								}
								
								for (int i = index; i < nums.length; i++) {
												path.addLast(nums[i]+"");
												dfs(i + 1, n, nums, path);
												path.removeLast();
								}
				}
				
				
}
