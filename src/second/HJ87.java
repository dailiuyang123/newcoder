package second;

import java.util.Scanner;

public class HJ87 {

    /*
     * 密码强度等级
     *
     * */


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int score = 0;

        int length = s.length();

        if (length >= 8) {
            score += 25;
        } else if (length >= 5) {
            score += 10;
        } else {
            score += 5;
        }
        boolean hasA = false;
        boolean hasa = false;

        if (!s.equals(s.replaceAll("[A-Z]", ""))) {
            hasA = true;
            score += 10;
        }
        if (!s.equals(s.replaceAll("[a-z]", ""))) {
            hasa = true;
            score += 10;
        }

        boolean hasShuZi = false;
        if (!s.equals(s.replaceAll("[0-9]", ""))) {
            hasShuZi = true;
            int i = s.length() - s.replaceAll("[0-9]", "").length();
            if (i > 1) {
                score += 20;
            } else if (i == 1) {
                score += 10;
            }
        }
        boolean iszifu = false;
        if (s.replaceAll("[a-z0-9A-Z]", "").length() > 1) {
            iszifu = true;
            score += 25;
        } else if (s.replaceAll("[a-z0-9A-Z]", "").length() == 1) {
            iszifu = true;
            score += 10;
        }

        if (hasShuZi && (hasa || hasA)) {
            score += 2;
            if (iszifu) {
                score += 1;
                if (hasa && hasA) {
                    score += 2;
                }
            }
        }

        if (score >= 90) {
            System.out.println("VERY_SECURE");
            return;
        }

        if (score >= 80) {
            System.out.println("SECURE");
            return;
        }

        if (score >= 70) {
            System.out.println("VERY_STRONG");
            return;
        }

        if (score >= 60) {
            System.out.println("STRONG");
            return;
        }

        if (score >= 50) {
            System.out.println("AVERAGE");
            return;
        }

        if (score >= 25) {
            System.out.println("WEAK");
            return;
        }
        System.out.println("VERY_WEAK");

    }

}
