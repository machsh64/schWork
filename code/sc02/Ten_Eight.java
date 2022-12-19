package sc02;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-13 09:18
 * @description: 十进制转换为八进制 八进制转换为十进制
 **/
public class Ten_Eight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            //测试十进制转八进制
            System.out.println("输入十进制的数(非负数)：");
            int tenNum = scan.nextInt();
            System.out.println("八进制的数为：" + Across.toEightHex(tenNum));

            System.out.println("*****************");

            //测试八进制转十进制
            System.out.println("输入八进制的数(非负数)：");
            int eightHex = scan.nextInt();
            System.out.println("十进制的数为：" + Across.toTentHex(eightHex));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Across {

    //十进制到八进制的转换
    public static int toEightHex(int tenHex) throws RuntimeException {
        Stack<Integer> Stack = new Stack<>();

        //将十进制数转换为八进制压入栈内
        if (tenHex > 0) {
            while (tenHex > 0) {
                Stack.push(tenHex % 8);
                tenHex /= 8;
            }

            int sizeOfStack = Stack.size();   //保存栈长度
            int eightHex = 0;

            //出栈，将栈内元素转换为整数类型
            while (!Stack.isEmpty()) {
                for (int i = 0; i < sizeOfStack; i++) {
                    eightHex += Stack.pop() * Math.pow(10, Stack.size());
                }
            }
            return eightHex;
        } else {
            throw new negativeException("数值必须为正数！");
        }

    }

    //八进制到十进制的转换
    public static int toTentHex(int eightHex) throws RuntimeException {
        Stack<Integer> Stack = new Stack<>();

        //将八进制数转换为十进制压入栈内
        if (eightHex > 0) {
            int pow = 0;
            while (eightHex > 0) {
                Stack.push(((int) (Math.pow(8, pow++)) * (eightHex % 10)));
                eightHex /= 10;
            }

            int sizeOfStack = Stack.size();   //保存栈长度
            int tenHex = 0;

            //出栈，将栈内元素转换为整数类型
            while (!Stack.isEmpty()) {
                for (int i = 0; i < sizeOfStack; i++) {
                    tenHex += Stack.pop();
                }
            }
            return tenHex;
        } else {
            throw new negativeException("数值必须为正数！");
        }

    }

}

class negativeException extends RuntimeException {
    static final long serialVersionUID = -7034897190745766939L;

    public negativeException() {
       
    }

    public negativeException(String msg) {
        super(msg);
    }
}
