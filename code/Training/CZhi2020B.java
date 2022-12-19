package Training;

import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-23 00:47
 * @description: 所有学生会有一个卷面得分，这个得分一定是一个 [0,100] 之间的整数。
 * 如果卷面得分在 90 分以上，那么他的 GPA(加权平均成绩) 就是满分 4.0 。
 * 如果卷面得分在 60 - 89 之间，那么他每比 90 分少 1 分，那么他的分数就会在 4.0 的基础上减少 0.1 。
 * 如果卷面得分不到 60 分，那么善良的老师会给他照顾。
 * 具体来说，如果他的分数为 x ，那么老师会把他的分数调整为 sqrt{x} * 10 (向下取整) ，再计算他的 GPA。
 * 如果经过调整该学生的得分依旧没满 60 ，那么他就挂科了，GPA 就是 0 分。
 * 现在给你一个人的期末卷面得分，请你输出他的最终 GPA
 * <p>
 * 输入输出格式
 * 输入格式
 * 一行一个整数 x ，表示该人的期末得分。
 * 输出格式
 * 一个小数点后只有一位的浮点数，表示该同学获得的GPA。 请注意，如果有 .0 请保留。
 * 输入输出样例
 * 输入样例
 * 99
 * 输出样例 #1
 * 4.0
 * 输入样例 #2
 * 88
 * 输出样例 #2
 * 3.8
 * 输入样例 #3
 * 12
 * 输出样例 #3
 * 0.0
 **/
public class CZhi2020B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(Gpa(scan.nextInt()));
    }

    public static double Gpa(int x) {
        double Gpa = 4.0;
        if (x < 90 && x > 59) {
            Gpa -=(90 - x) * 0.1;
        } else {
            x = (int) Math.sqrt(x) * 10;
            if (x > 59){
                Gpa -=(90 - x) * 0.1;
            }else {
                Gpa = 0;
            }
        }
        return Gpa;
    }
}





















