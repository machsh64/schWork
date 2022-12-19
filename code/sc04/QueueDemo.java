package sc04;

import java.util.*;

/**
 * @program: easc
 * @author: Ren
 * @create: 2022-09-20 23:33
 * @description: 队列的方式判断字符串是否为回文
 **/
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("输入一个字符串，以@为末尾符号");
            String str = scan.next();

            //将字符串分为char字母传入队列
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '@') {
                    queue.add(str.charAt(i));
                } else {
                    break;
                }
            }

            if (isOverCome(queue)) {
                System.out.println("该字符串是回文");
            } else {
                System.out.println("该字符串不是回文");
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("数据输入错误");
        }catch (NoSuchElementException e){
            System.out.println("队列为空");
        }catch (IllegalStateException e){
            System.out.println("队列已满");
        }
    }

    //判断字符串是否为回文
    public static boolean isOverCome(Queue<Character> queue) throws NoSuchElementException {
        int len = queue.size();
        char[] chars = new char[len];
        boolean isOverCome = true;
        for (int i = 0; i < len / 2; i++) {
            chars[i] = queue.remove();
            if (len % 2 != 0) {
                queue.remove();
            }
        }

        int len1 = queue.size();
        for (int i = len1 - 1; i >= 0; i--) {
            if (queue.remove() != chars[i]) {
                isOverCome = false;
                break;
            }
        }
        return isOverCome;
    }
}

