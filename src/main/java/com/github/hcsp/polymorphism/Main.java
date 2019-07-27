package com.github.hcsp.polymorphism;

public class Main {
    interface 会跑 {
        String getName();

        default void 跑() {
            System.out.println(getName() + "跑啊跑啊跑");
        }
    }

    interface 会游泳{
        String getName();

        default void 游泳() {
            System.out.println(getName() + "游啊游啊游");
        }
    }

    abstract static class Animals{
        String name;

        public Animals(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class 猫 extends Animals implements 会跑 {
        猫() {
            super("小花猫");
        }
    }

    static class 鱼 extends Animals implements 会游泳 {
        鱼() {
            super("鱼");
        }
    }

    // 现在 乌龟 想要同时复用会跑和会游泳的代码
    // 请尝试通过接口的默认方法实现mixin
    // 从而实现最大程度的代码复用
    //
    static class 乌龟 extends Animals implements 会游泳,会跑 {

        乌龟() {
            super("乌龟");
        }
    }

        public static void main(String[] args) {
        new 乌龟().跑();
        new 乌龟().游泳();
    }
}
