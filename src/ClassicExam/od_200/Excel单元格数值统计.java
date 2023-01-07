package ClassicExam.od_200;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Excel单元格数值统计 {

    /**
     * 题目描述
     * Excel工作表中对选定区域的数值进行统计的功能非常实用。
     * <p>
     * 仿照Excel的这个功能，请对给定表格中选中区域中的单元格进行求和统计，并输出统计结果。
     * <p>
     * 为简化计算，假设当前输入中每个单元格内容仅为数字或公式两种。
     * <p>
     * 如果为数字，则是一个非负整数，形如3、77
     * <p>
     * 如果为公式，则固定以=开头，且仅包含下面三种情况：
     * <p>
     * 等于某单元格的值，例如=B12
     * 两个单元格的双目运算（仅为+或-），形如=C1-C2、C3+B2
     * 单元格和数字的双目运算（仅为+或-），形如=B1+1、100-B2
     * 注意：
     * <p>
     * 公式内容都是合法的，例如不存在，=C+1、=C1-C2+B3,=5、=3+5
     * 不存在循环引用，例如A1=B1+C1、C1=A1+B2
     * 内容中不存在空格、括号
     * 输入描述
     * 第一行两个整数rows cols，表示给定表格区域的行数和列数，1<=rows<=20，1<=cols<=26。
     * 接下来rows行，每行cols个以空格分隔的字符串，表示给定表格values的单元格内容。
     * 最后一行输入的字符串，表示给定的选中区域，形如A1:C2。
     * <p>
     * 输出描述
     * 一个整数，表示给定选中区域各单元格中数字的累加总和，范围-2,147,483,648 ~ 2,147,483,647
     * <p>
     * 备注
     * 表格的行号1~20，列号A~Z，例如单元格B3对应values[2][1]。
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int rows = in.nextInt();
        int cols = in.nextInt();

        String[][] map = new String[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                map[i][j] = in.next();
            }
        }

        String end = in.next();

        String[] point = end.split("\\:");

        String begin = point[0];
        String ends = point[1];

        int[] begin_xy = getXY(begin);
        int[] end_xy = getXY(ends);

        int counts = 0;

        for (int i = begin_xy[0]; i <= end_xy[0]; i++) {

            for (int j = begin_xy[1]; j <= end_xy[1]; j++) {
                if (map[i][j].startsWith("=")) {  // 公式
                    String temp = map[i][j].substring(1);
                    if (temp.contains("+") || temp.contains("-")) {

                        String[] objs = temp.replaceAll("[+-]", " ").split("\\ ");

                        for (int k = 0; k < objs.length; k++) {
                            if (!Character.isDigit(objs[k].charAt(0))) {
                                int[] xy = getXY(objs[k]);
                                String s = map[xy[0]][xy[1]];
                                temp = temp.replaceAll(objs[k], s);
                            }
                        }
                        counts += eval(temp);
                    } else {
                        int[] xy = getXY(temp);
                        counts += Integer.valueOf(map[xy[0]][xy[1]]);
                    }
                } else {                        // 数字
                    counts += Integer.valueOf(map[i][j]);
                }

            }
        }

        System.out.println(counts);

    }

    public static int[] getXY(String point) {
        int[] points = new int[2];
        int j = point.charAt(0) - 'A';
        int i = Integer.valueOf(point.substring(1)) - 1;
        points[0] = i;
        points[1] = j;
        return points;
    }


    public static int eval(String s) {

        int rs = 0;
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine javascript = scriptEngineManager.getEngineByName("javascript");
        try {
            String string = javascript.eval(s).toString();
            rs = Integer.valueOf(string);
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }

        return rs;
    }


}
