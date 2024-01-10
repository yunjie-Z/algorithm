package com.zyj.matrix;

public class test {
    public static void main(String[] args) {
       A a = new A(2);
       change(a);
        System.out.println(a.a);
    }

    public static void change(A a){
        a.a = 1;
    }

    static class A{
        long a;
        A(long a){
            this.a = a;
        }
    }
}
