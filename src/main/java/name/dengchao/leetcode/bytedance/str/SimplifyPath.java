package name.dengchao.leetcode.bytedance.str;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;
            else if (part.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else stack.push(part);
        }
        StringBuilder stb = new StringBuilder();
        for (String s : stack) stb.append("/").append(s);
        return stb.length() == 0 ? "/" : stb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath test = new SimplifyPath();
        System.out.println(test.simplifyPath("/a/../../b/../c//.//"));
    }
}
