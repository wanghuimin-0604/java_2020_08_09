package hash.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-15
 * Time:21:28
 * 一万年太久，只争朝夕，加油
 */
class Cat{
    private String name="小猫";
    public void eat(String food){
        System.out.println(name+"正在吃"+food);

    }

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }
}
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
     testField();
     testMethod();
     testConstructor();
        /*//获取类对象,获取到类的说明书，才能开始后面的反射操作
        //1、直接通过全限定类名获取(包名+类名)，这一种方式最为灵活
        Class catClass=Class.forName("hash.demo.Cat");
        //2、通过类的实例来获取
        //Cat cat=(Cat)catClass.newInstance();
       Cat cat=new Cat("咪咪");
        Class catClass2=cat.getClass();
        //3、通过类来直接获取
        Class catClass3=Cat.class;
        System.out.println(catClass==catClass2);
        System.out.println(catClass==catClass3);*/
    }
    public static void testInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1、通过全定类名
        Class catClass=Class.forName("hash.demo.Cat");
         //借助反射实例化
        Cat cat=(Cat)catClass.newInstance();
    }
    public static void testField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //获取类对象
        Class catClass=Class.forName("hash.demo.Cat");
        //借助类对象，获取到指定的属性对象
        Field field=catClass.getDeclaredField("name");
        //破门而入（破环封装、解决private属性的问题）
        field.setAccessible(true);
        //根据图纸来修改/获取对象的相关字段
        Cat cat=new Cat();
        //可以通过get方法获取对应属性，set修改属性
        field.set(cat,"咪咪");
        String name=(String)field.get(cat);
        System.out.println(name);
    }
    public static void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class catClass=Class.forName("hash.demo.Cat");
        //根据名字，获取到指定的method对象
        //多个eat方法，里面的逻辑不一样,取的是eat里面只有一个参数的版本（参数的数量和类型去区分）
        Method method=catClass.getMethod("eat",String.class);
        //借助method对象调用指定的方法
        Cat cat=new Cat();
        method.invoke(cat,"鱼");
    }
    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class catClass=Class.forName("hash.demo.Cat");
        Constructor constructor=catClass.getConstructor(String.class);
        constructor.setAccessible(true);
        Cat cat=(Cat)constructor.newInstance("小黑");
        cat.eat("猫粮");
    }
}
