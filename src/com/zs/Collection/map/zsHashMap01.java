package com.zs.Collection.map;

/**
 * @program: SxtJava
 * @description: 增加泛型的HashMap
 * @author: 周硕
 * @create: 2020-07-31 19:30
 **/
public class zsHashMap01<K,V>{
    Node3[] table;
    int size;

    public zsHashMap01() {
        table = new Node3[16];
    }
    /**
     *实现添加map值
     *@param  KEY  vlaue
     */
    public void put( K KEY,V vlaue){
        Node3 newNode = new Node3();
        newNode.hash=MyHash(KEY,table.length);
        newNode.key=KEY;
        newNode.value=vlaue;
        newNode.next=null;

        Node3 temp = table[newNode.hash];

        if(temp==null){
            table[newNode.hash]=newNode;
        }else {
            while (temp!=null){
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
    public V get(K key) {
        Node3 temp = table[MyHash(key,table.length)];
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
            return (V)temp.value;
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
            Node3 temp = table[i];
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
    public int MyHash(K KEY,int length){
        //System.out.println("hash in number"+ (KEY.hashCode()%length));  取模，效率低 不用减一
        //System.out.println("hash in number"+ (KEY.hashCode()&(length-1))); 位运算，按位与；效率高
        //TODO: 位运算 & <<  这些符号不太懂 ，并且按位与 ，异或 ，等操作应该知道如何计算 ，写篇博客
        return  KEY.hashCode()&(length-1);
    }



    public static void main(String[] args) {
        zsHashMap01<Integer,String> map = new zsHashMap01();
        map.put(12,"二");
        map.put(45,"三");
        map.put(56,"四");
        map.put(54,"你好");
        map.put(68,"helloword");
        System.out.println(map);
        System.out.println(map.get(12));
        map.put(12,"12");
        System.out.println(map.get(12));
    }
}


