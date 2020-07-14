package com.algorithm.stack;

import java.util.Scanner;

public class Pipei {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str= scanner.next();
            System.out.println("str:"+str+"----->"+isOk(str));
        }
    }

    /**
     * 整体思路：
     *      如果是（{ [ 则直接的入栈
     *      如果是）}] 则出站一个值，
     *      如果能匹配上就继续匹配，
     *      如果不成功直接返回false
     * @param str
     * @return
     */

    private static boolean isOk(String str) {
          //构建一个栈
        MyStack<Character> stack = new ArrayStack<Character>(16);
        char[] chars = str.toCharArray();
        for (char item:chars) {
            switch (item){
                case '(':
                case '{':
                case '[':
                    stack.push(item);
                    break;
                case ')':
                    Character pop = stack.pop();
                    if (pop == null) {
                        return false;
                    }else if (pop.equals('(')){
                        break;
                    }else {
                        return false;
                    }
                case '}':
                    Character pop2 = stack.pop();
                    if (pop2 == null) {
                        return false;
                    }else if (pop2.equals('{')){
                        break;
                    }else {
                        return false;
                    }
                case ']':
                    Character pop3 = stack.pop();
                    if (pop3 == null) {
                        return false;
                    }else if (pop3.equals('[')){
                        break;
                    }else {
                        return false;
                    }

            }
        }
        return  stack.isEmpty();
    }
}
