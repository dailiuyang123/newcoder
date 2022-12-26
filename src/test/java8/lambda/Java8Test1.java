package test.java8.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Test1 {


    /*
     * java 8 lambda 表达式测试
     *
     * */
    public static void main(String[] args) {

        List<String> list = Arrays.asList("tom", "jerry");

        list.forEach(s -> System.out.println(s));

        //  1. 多线程 调用

        //  1.1 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello word by inner class");
            }
        }).start();

        //  1.2 使用lambda expression
        new Thread(()->{
            System.out.println("hello word by lambda expression");
        }).start();


        // 1.3 使用 lambda expression 进行排序
        Comparator<String> sortByname=(String s1,String s2)->(s1.compareTo(s2));
        list.sort(sortByname);


        //  POJO Person 集合
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };
        // 1.4 filter
        System.out.println(" 薪资超过1800女性员工：");
        javaProgrammers.stream()
                .filter((p)->p.getSalary()>1800)
                .filter(p->p.getGender().equals("female"))
                .forEach((p)-> System.out.printf(" %s",p.getFirstName()));


        // 1.5 排序

        List<Person> collect = javaProgrammers.stream()
                .sorted((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("薪水收入排名 后五名：");
        collect.stream()
                .forEach((p)->{
                    System.out.println(p.getFirstName()+"："+p.getSalary());
                });


        // 1.6 map 于 flatmap
        Map<Integer, Person> map = javaProgrammers.stream().collect(Collectors.toMap(Person::getAge, Function.identity(),(oldValue,newValue)->oldValue));
        System.out.println(map.getClass());
        System.out.println(map.size());





    }

}


