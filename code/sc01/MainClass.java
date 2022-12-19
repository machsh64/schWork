package sc01;

/**
 * @program: schoolwork
 * @description:
 * @author: Ren
 * @create: 2022-08-31 08:53
 **/
public class MainClass {
    public static void main(String[] args) {
        //method1: 多态 非匿名类的匿名的对象
        /*
        method(new A());
        method(new B());
        method(new C());

    public static void method(ShowWin s){
        s.show();
    }
 */

        //method2: 代理设计模式
         new Proxy(new A());
         new Proxy(new B());
         new Proxy(new C());

    }
}

interface out{
     void show();
}

/*
abstract class ShowWin{
    public abstract void show();
}
*/

class A implements out{
    {
        show();
    }

    @Override
    public void show() {
        System.out.println("im A");
    }
}

class B implements out{
    {
        show();
    }

    @Override
    public void show() {
        System.out.println("im B");
    }
}

class C implements out{
    {
        show();
    }
    @Override
    public void show() {
        System.out.println("im C");
    }
}

class Proxy implements out{
    private out o;

    public Proxy(out o){
        this.o = o;
    }

    @Override
    public void show() {
        o.show();
    }
}
