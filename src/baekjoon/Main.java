package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String in = bf.readLine();

        Stack<Character> stack = new Stack<>();

        boolean flag = false;

        int mul = 1;
        int result = 0;
        //

        for(int i=0; i<in.length(); i++)
            switch (in.charAt(i)) {
                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;
                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break;
                    }
                    if (in.charAt(i - 1) == '(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break;
                    }
                    if (in.charAt(i - 1) == '[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;
            }

    }
}