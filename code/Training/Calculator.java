package Training;

/**
 * @program: easc
 * @author: Ren  https://github.com/machsh64
 * @create: 2024-03-07 20:27
 * @description:
 **/
public class Calculator {
    private final double num1;
    private final double num2;

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    //加
    public double add() {
        return num1 + num2;
    }

    //减
    public double subtract() {
        return num1 - num2;
    }

    //乘
    public double multiply() {
        return num1 * num2;
    }

    //除
    public double divide() {
        return 0;
    }
}

class CalculatorDev extends Calculator {
    private final double num1;
    private final double num2;

    public CalculatorDev(double num1, double num2) {
        super(num1, num2);
        this.num1 = num1;
        this.num2 = num2;
    }

    // 继承后重写父类方法
    @Override
    public double divide() {
        if (num2 == 0) {
            throw new ArithmeticException("分母不能为0");
        }
        return (double) num1 / num2;
    }

    public static void main(String[] args) {
        CalculatorDev dev = new CalculatorDev(4, 2);

        System.out.println("4,2 加法:" + dev.add());        //   4,2 加法:6.0
        System.out.println("4,2 减法:" + dev.subtract());   //   4,2 减法:2.0
        System.out.println("4,2 乘法:" + dev.multiply());   //   4,2 乘法:8.0
        System.out.println("4,2 除法:" + dev.divide());     //   4,2 除法:2.0
    }
}