package com.zs.Collection.List;

public class Node {
    Node previous;
    Node next;
    Object element;
//构造器的生成 ：右键——>Generate——>Constructor  // 按Shift多选
    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
