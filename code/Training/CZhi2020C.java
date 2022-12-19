package Training;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-23 00:58
 * @description:
 * 传智专修学院总共召集了 n 位志愿者,第 i 位志愿者有一个工作时长 ti ，以及他负责的工作的难度系数 ki
 * 一名志愿者的贡献度可以用 ki * ti 确定。
 * 现在要为这些志愿者的贡献度从大到小排个序，
 * 请你完成这个任务。
 * 相同贡献度的志愿者以工作时长较长的排在前面。
 * 如果贡献和时长一样，那么编号小的志愿者排在前面。
 *
 * 输入输出格式
 * 输入格式
 * 一行一个整数 n ，表示志愿者的数量。 接下来 n 行，每行两个使用空格隔开的整数 t_i,k_i ，表示第 i 名志愿者的时间和难度系数。
 * 输出格式
 * 一行，共 n个整数，第 i 个数表示排名为 i 的志愿者的序号，从 1 开始编号。
 * 请注意本题时限为 5s，输入输出规模较大，请注意常数因素对耗时的影响，我们不会给使用 Java 和 Python 的选手增加额外的运行时间。
 * 输入输出样例
 *
 * 输入样例 #1
 * 3
 * 1 2
 * 2 3
 * 3 4
 * 输出样例 #1
 * 3 2 1
 **/
public class CZhi2020C {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tem(3)));
    }

    public static int[] tem(int n){
        Scanner scan = new Scanner(System.in);
        int [][]tem = new int[n][2];

        for(int i = 0; i < n; i++){
            tem[i][0] = scan.nextInt()*scan.nextInt();
            tem[i][1] = i + 1;
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if (tem[j][0] < tem[j+1][0]){
                    int temp = tem[j][0];
                    int temp1 =tem[j][1];
                    tem[j][0] = tem[j+1][0];
                    tem[j][1] = tem[j+1][1];
                    tem[j+1][0] = temp;
                    tem[j+1][1] = temp1;
                }
            }
        }

        int []soc = new int[n];
        for(int i = 0; i < n; i++){
            soc[i] = tem[i][1];
        }
        return soc;
    }
}


