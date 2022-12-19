package sc05;

import java.util.Arrays;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-23 10:18
 * @description: 输出100以内的斐波拉集数列
 **/
public class NumList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numList(10)));

    }

    public static int[] numList(int n) {
        int[] num = new int[n];


        num[0] = 1;
        num[1] = 1;
        int i;

        for (i = 2; i < n; i++) {
            int m = num[i - 1] + num[i - 2];
            if (m > n) {
                break;
            }
            num[i] = m;
        }

        int[] ints = new int[i];
        System.arraycopy(num, 0, ints, 0, i);
        return ints;
    }
}
