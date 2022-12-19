package sc02;

import java.util.Stack;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-13 08:34
 * @description:
 **/
public class MInStackTest {
    public static void main(String[] args) {

        MinStack sta = new MinStack();
        sta.push(3);
        sta.push(4);
        sta.push(2);
        sta.push(6);

        System.out.println(sta.top());   //栈顶元素
        System.out.println(sta.min());   //栈内最小元素

        System.out.println();

        //将栈内所有元素出栈
        int sizeOfStack = sta.Stack.size();
        for (int i = 0; i < sizeOfStack; i++) {
            System.out.println(sta.pop());
        }

        System.out.println();

        Stack<java.io.Serializable> Stack = new Stack<>();
        Stack.push(1);
        Stack.push("a");
        Stack.push("v");
        Stack.push(2);
        Stack.push(6);

        //将栈内所有元素出栈
        int sizeOfStack1 = Stack.size();
        for (int i = 0; i < sizeOfStack1; i++) {
            System.out.println(Stack.pop());
        }


    }
}

class MinStack {
    Stack<Integer> Stack;
    java.util.Stack<Integer> Stack1;

    public MinStack() {
        //初始化栈
        this.Stack = new Stack<>();
        this.Stack1 = new Stack<>();
    }

    public void push(int x) {
        //将元素入栈
        Stack.push(x);
        //判断从大到小压入栈Stack1
        if (Stack1.isEmpty()) {    //isEmpty判断栈是否为空栈
            Stack1.push(x);
        } else if (Stack1.peek() < x) {
            Stack1.push(Stack1.peek());
        } else {
            Stack1.push(x);
        }

    }

    public String pop() {
        //两个栈顶一起出栈
        return "Stack: "+Stack.pop() + "  Stack1: " + Stack1.pop();
    }

    public int top() {
        //栈顶元素
        return Stack.peek();
    }

    public int min() {
        //栈1Stack的栈顶元素为最小元素
        return Stack1.peek();
    }
}
