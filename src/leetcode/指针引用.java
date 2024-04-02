package leetcode;

import java.util.Collection;

public class 指针引用 {

    public static void main(String[] args) {
        User U1;

        User cpU1 = new User(1);

        U1 = cpU1;

        U1.name="tom";

        System.out.println(cpU1);

        int a=8;
        f(a);
        System.out.println(a);
    }


    public static void f(int a){
        a=16;
        System.out.println("f(a)="+a);
    }

}


class User {

    String name;

    int age;

    public User(int age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}