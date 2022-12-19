package sc03;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-16 15:07
 * @description: 质数
 **/
public class PrimeNum {

    public static void main(String[] args) {
        PrimeNum.prime(100);
    }

    public static void prime(int num) {
        if (num == 1) {

        }
        if (num == 2) {
            System.out.println(num);
        }
        if (num > 2) {
            for (int i = 2; i <= num; i++) {
                boolean isFlag = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag)
                System.out.println(i);
            }
        }
    }
}

