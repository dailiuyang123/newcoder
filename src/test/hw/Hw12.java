package test.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hw12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String[] arr= s.split(" ");
        String e="";
        for(int i=arr.length-1;i>=0;i--){
            e+=arr[i]+" ";
        }
        System.out.println(e);
    }

    public static void withPriorityQueue() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>();
        String s = "";
        while ((s = br.readLine()) != null) {
            pq.offer(s);
        }
        br.close();

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
