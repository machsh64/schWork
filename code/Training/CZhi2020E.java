package Training;

import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-23 00:14
 * @description: 哈兰·斯威提是 YYH Land 远近闻名的注铅骰子爱好者。
 * 有一天他碰到了这么一个问题：
 * 你有一枚 6 个面的骰子，分别写了 1,2,3,4,5,6 ，每一面朝上的概率是均等的。
 * 现在哈兰想知道，如果他投掷 n 次，并且将结果按顺序写在纸上成为一个数。
 * (比如说如果哈兰扔了 3 次，分别是 3,2,5 ，那么他最后得到的数就是 325 )
 * 他现在想知道这个数是 k 的倍数的可能情况有多少种，其中 k 是一个特定的数。
 * 由于这个方案数可能会很大，所以请你输出结果对 10^9+7 取模的结果。
 * <p>
 * 输入输出格式
 * 输入格式
 * 一行两个整数 n,k ，意义如题所示。
 * 输出格式
 * 一行一个整数，表示答案。
 * 输入样例
 * 2 11
 * 输出样例
 * 6
 **/
public class CZhi2020E {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(pos(scan.nextInt(),scan.nextInt()));
        /*System.out.println(pos(2,11));  //6*/
    }

    //抛出筛子获取次数
    public static int pos(int n, int k) {
        int len = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            len += Math.pow(10, i);
        }

        for (int i = len; i <= len*6; i++) {
            if (i % k == 0) {
                ++num;
            }
        }return num;
    }
}
