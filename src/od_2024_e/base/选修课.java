package od_2024_e.base;

import java.util.*;
import java.util.stream.Collectors;

public class 选修课 {
				/**
					* 2024/11/14
					* URL ： https://blog.csdn.net/qfc_128220/article/details/130765442
					* 题目描述：
					**/
				public static void main(String[] args) {
								
								Scanner in =new Scanner(System.in);
								String s1 = in.nextLine();
								String s2 = in.nextLine();
								
								HashMap<String,Integer> k1=new HashMap<>();
								HashMap<String,Integer> k2=new HashMap<>();
								
								for (String s : s1.split(";")) {
												String[] split = s.split(",");
												k1.put(split[0],Integer.valueOf(split[1]));
								}
								
								for (String s : s2.split(";")) {
												String[] split = s.split(",");
												k2.put(split[0],Integer.valueOf(split[1]));
								}
								List<Stu> list=new ArrayList<>();
								for (String s : k1.keySet()) {
												if (k2.containsKey(s)){
														list.add(new Stu(s.substring(0,5),s,k1.get(s)+k2.get(s)));
												}
								}
								if(list.isEmpty()){
												System.out.println("NULL");
								}else {
												Map<String, List<Stu>> collect = list.stream().collect(Collectors.groupingBy(Stu::getNo));
												collect.keySet().stream().sorted().forEach(o->{
																System.out.println(o);
																List<Stu> list1 = collect.get(o);
																list1.sort((a,b)->{
																				if(a.sum!=b.sum){
																								return b.sum-a.sum;
																				}else {
																								return a.stu_no.compareTo(b.stu_no);
																				}
																});
																List<String> collect1 = list1.stream().map(Stu::getStu_no).collect(Collectors.toList());
																System.out.println(String.join(";",collect1));
												});
								}
				}
				
				static class Stu{
							public 	String no;
								
							public 	String stu_no;
								
							public 	Integer sum;
								
								public Stu(String no, String stu_no, Integer sum) {
												this.no = no;
												this.stu_no = stu_no;
												this.sum = sum;
								}
								
								public String getNo() {
												return no;
								}
								
								public void setNo(String no) {
												this.no = no;
								}
								
								public String getStu_no() {
												return stu_no;
								}
								
								public void setStu_no(String stu_no) {
												this.stu_no = stu_no;
								}
								
								public Integer getSum() {
												return sum;
								}
								
								public void setSum(Integer sum) {
												this.sum = sum;
								}
				}
				
}
