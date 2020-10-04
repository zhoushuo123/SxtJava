package com.zs.Collection.List;

public class ZsLinkedList {
    private Node first;
    private Node last;

    private int size;
//添加元素
    public void add(Object obj) {
        Node node = new Node(obj);
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        Node temp = first;
        sb.append("[");
        while (temp!=null){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }


    public static void main(String[] args) {
        ZsLinkedList link1 = new ZsLinkedList();
        link1.add("a");
        link1.add("b");
        link1.add("c");
        System.out.println(link1);
    }
}
