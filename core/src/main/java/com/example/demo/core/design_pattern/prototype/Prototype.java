package com.example.demo.core.design_pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 原型模式
 * 浅拷贝、深拷贝
 */
@Data
public class Prototype implements Cloneable {

    private String name;
    private int cloneType;
    private /*final*/ A a = new A("a");// final 修饰的变量，不支持再次赋值，因此不能深拷贝

    public Prototype(String name) {
        this.name = name;
        System.out.println("constructor method:" + this.name);
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Prototype copy = (Prototype) super.clone();
        // ==1, shallow clone
        if (this.cloneType == 1) {
            return copy;
        }
        // otherwise, deep clone
        copy.setA(new A(a.getSubName() + "_copy"));
        return copy;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype("p1");
        p1.setCloneType(1);
        p1.setA(new A("a1"));

        Prototype p2 = p1.clone();

        System.out.println(p1);
        System.out.println(p2);

        System.out.println("p2.a == p1.a ? " + (p2.getA() == p1.getA()));

        System.out.println();

        Prototype p3 = new Prototype("p3");
        p3.setCloneType(0);
        p3.setA(new A("a3"));

        Prototype p4 = p3.clone();

        System.out.println(p3);
        System.out.println(p4);

        System.out.println("p4.a == p3.a ? " + (p4.getA() == p3.getA()));

    }
}

@Data
@AllArgsConstructor
class A {
    private String subName;
}
