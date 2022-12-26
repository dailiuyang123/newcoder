package test.day12;

public class Demo {

    public static void main(String[] args) {
        String s="1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\\\/;p0-=\\\\][";
        String s1 = s.replaceAll("[^a-z]", "");
        System.out.println(s1);


    }
}
