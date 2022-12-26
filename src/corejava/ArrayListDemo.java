package corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        String[] a={"a","b","c"};
        List<String> strings = Arrays.asList(a);
        ArrayList arrayList=new ArrayList();
        for (String string : strings) {
            System.out.println(string);
        }

    }

}
