package offer;

import publicUtil.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/*
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Q06 {
    public static void main(String[] args) {

    }

    //递归实现
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        func(arr, listNode);
        return arr;
    }

    private void func(ArrayList<Integer> arr, ListNode node) {
        if (node == null) return;
        func(arr, node.next);
        arr.add(node.val);
    }

    //栈实现
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack stack = new Stack();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(stack.size());
        while (!stack.isEmpty()) {
            arr.add((int) stack.pop());
        }
        return arr;
    }
}
