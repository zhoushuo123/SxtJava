package com.zs.Collection.List;

/**
 * @author zs
 * List是有序的可重复的容器
 * 有序：List每个元素都有索引标记
 * 可重复：List允许加入重复的元素。跟确切的将List通常允许满足e1.equals(e2)的元素重复加入容器
 * List接口常用的实现类 ArrayList ，LinkedList，Vector（线程安全）
 * ArrayList特点：查询效率高，增删效率低，线程不安全
 */
public class Test_MyList <E>{
    private  Object[] elementData;
    private int size;

    private static final  int DEFALT_CAPACITY = 10;

    public Test_MyList(){ //初始化一个大小位10的数组容器
        elementData = new Object[DEFALT_CAPACITY];
    }
    public Test_MyList(int capacity){
        //capacity 容器  初始化一个大小为capacity的数组容器
        if (capacity<0){
            throw new RuntimeException("容器的容量不能位负数");
        }else if (capacity==0){
            elementData = new Object[DEFALT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }
    public void add(E element){//加进元素
        //什么时候扩容？？
        if(size==elementData.length){
            //怎么扩容
            Object[]  newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
            //>> 右移  位移的优先级小于运算符的优先级
        }
        elementData[size++] = element;
    }
    //get方法
    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    //set方法
    public void set(E element,int index){
      checkRange(index);
      elementData[index]=element;
    }
    //checkRange 判断索引合法性
    public  void checkRange(int index){
        //索引合法判断[0,size]  10 0-9
        if(index<0||index>size-1){
            //不合法
            throw new RuntimeException("索引不合法"+index);
        }
    }

    //remove 移除

    //移除整个对象
    public  void remove(E element){
        //element,将它和所有元素挨个比较，获得第一个比较位true的，返回
        for(int i=0;i<size;i++){
            if(element.equals(get(i))) {
               remove(i);//移除一个元素
            }
        }
    }
// 移除一个元素
    public void  remove(int index){
        checkRange(index);
        //a,b,c,d,e,f
        //a,b,d,e,f
        int numMoved =elementData.length-index-1;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
       elementData[--size]=null;
    }

    @Override
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0 ;i<size;i++){
            sb.append(elementData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
    public static void main(String[] args) {
        Test_MyList<String>  list = new Test_MyList<String>(6);
        for(int i=0;i<10;i++){
            list.add("zhou"+i);
        }
        list.remove(3);
        System.out.println(list);
    }

}
