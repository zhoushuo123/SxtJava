package com.zs.Collection.map;

import javax.swing.*;

/**
	 *手动创建简单的HashMap()类。熟悉HashMAap的底层实现
	 *@author 周硕
	 *@date 2020-07-31 16:36
	 */
public class zsHashMap {
    Node2[] table;
    int size;

    public zsHashMap() {
        table = new Node2[16];
    }
    /**
        *实现添加map值
        *@param  KEY  vlaue
        */
    public void put(Object KEY,Object vlaue){
        Node2 newNode = new Node2();
        newNode.hash=MyHash(KEY,table.length);
        newNode.key=KEY;
        newNode.value=vlaue;
        newNode.next=null;

        Node2 temp = table[newNode.hash];

        if(temp==null){
            table[newNode.hash]=newNode;
        }else {
            while (temp.next!=null){
                if(temp.key!=KEY) {
                    temp = temp.next;
                }else {
                    temp.value =vlaue;
                    return;
                }
            }
            temp.next=newNode;
        }
        size++;
    }
    /**
        *获得map对象的元素个数
        *@return size
        */
    public int getSize(){
        return size;
    }
    /**
        *通过key值得到value
        *@param  key
        *@return value
        */
    public Object get(Object key) {
        Node2 temp = table[MyHash(key,table.length)];
        while (temp != null) {
            if (temp.key == key) {
                break;
            } else {
                temp = temp.next;
            }
        }
        if (temp == null) {
            throw new IllegalAccessError("key值不存在！！！");
        } else {
            return temp.value;
        }
    }

    @Override
    /**
        *重写toString方法 实现map的正确显示
        *@return map中所有元素的字符串之和
        */
    public String toString(){
        StringBuffer index = new StringBuffer("[");
        for (int i=0 ;i <table.length;i++){
            Node2 temp = table[i];
            while (temp!=null) {
                index.append( temp.key + ":" + temp.value + "," );
                temp=temp.next;
            }
        }
       index.setCharAt(index.length()-1,']');
        return index.toString();
    }

    /**
        *
        *@param KEY length:table 数组的长度
        *@return 利用key计算出的hash值
        */

    public int MyHash(Object KEY,int length){
        //System.out.println("hash in number"+ (KEY.hashCode()%length));  取模，效率低 不用减一
        //System.out.println("hash in number"+ (KEY.hashCode()&(length-1))); 位运算，按位与；效率高
        //TODO: 位运算 & <<  这些符号不太懂 ，并且按位与 ，异或 ，等操作应该知道如何计算 ，写篇博客
        return  KEY.hashCode()&(length-1);
    }



    public static void main(String[] args) {
        zsHashMap map = new zsHashMap();
        map.put("12","二");
        map.put("three","三");
        map.put("four","四");
        System.out.println(map.MyHash("one",16));
        System.out.println(map.MyHash("two",16));
        System.out.println(map.MyHash("three",16));
        System.out.println(map);
        System.out.println(map.get("12"));
    }
}

