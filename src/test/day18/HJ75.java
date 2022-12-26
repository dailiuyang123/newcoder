package test.day18;

import java.util.Scanner;

public class HJ75 {

    // 最长公共子串

    public static void main(String[] args) {

        Scanner in =new Scanner(System.in);

        String s = in.nextLine();
        String l = in.nextLine();
        if(s.length()>l.length()){
            String t=s;
            s=l;
            l=t;
        }
        int max=0;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j+i<=s.length();j++){
                if(l.indexOf(s.substring(j,j+i)) !=-1){
                    max=i;
                    continue;
                }
            }

        }
        System.out.println(max);

    }

}
