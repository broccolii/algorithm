package com.kingkong.leetcode.ImplementQueueUsingStacks;

import java.util.Stack;

public class Solution {
    private Stack<Integer> in = new Stack<>(), out = new Stack<>();

    private void transferIfEmpty() {
        if (out.empty())
            while (!in.empty())
                out.push(in.pop());
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transferIfEmpty();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        transferIfEmpty();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }
}
