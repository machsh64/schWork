package Training;

import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-23 00:25
 * @description: 课程的初始定价为 v 元；每报名 m 个学员，课程的定价就要提升 a 元。
 * 由于课程能够容纳的学生有限，因此报名到 n 人的时候就停止报名。
 * 现在老师想知道，当课程停止报名时，一共可以获得多少学费呢？
 * <p>
 * 输入输出格式
 * 输入格式
 * 一行四个使用空格隔开的整数，分别为 n,v,m,a 。
 * 输出格式
 * 一行一个整数，表示答案。
 * <p>
 * 输入输出样例
 * 输入样例
 * 5 1 1 1
 * 输出样例
 * 15
 **/
public class CZhi2020A {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(fee(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt()));
       /* System.out.println(fee(5,1,1,1));  //15*/
    }

    public static int fee(int n,int v,int m,int a) {
        int fee = 0;
        int set = 0;
        for(int i = 0; i < n; i++){
            ++set;
            fee += v;
            if (set == m){
                v += a;
                set = 0;
            }
        }return fee;
    }
}


