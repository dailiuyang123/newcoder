package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NC74 {

    /**
     * 数字在生序数组中出现的次数
     */

    public int GetNumberOfK(int[] array, int k) {

        int cont = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                cont++;
            }
        }
        return cont;

    }


}
