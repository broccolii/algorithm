# [20. Valid Parentheses (Easy)](https://leetcode.com/problems/valid-parentheses/)

## Description


Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example:**

```
Input: "()"
Output: true

Input: "()[]{}"
Output: true
```

## 解法 1
通过一个辅助栈,左括号入栈, 右括号出栈的方式遍历字符串, 最后判断栈是否为空;
```java
class Solution {
    public boolean isValid01(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                }

                if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                }

                if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
```

## 解法 2

在解法 1 的基础上, 遇到左括号直接压入右括号来优化代码实现;

```java
class Solution {
    public boolean isValid02(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ) stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (stack.isEmpty() || s.charAt(i) != stack.pop()) return false;
        }

        return stack.isEmpty();
    }
}
```
