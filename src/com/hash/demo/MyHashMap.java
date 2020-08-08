package hash.demo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-15
 * Time:14:38
 * 一万年太久，只争朝夕，加油
 */
public class MyHashMap {
    class Node{
        public int key;
        public int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array=new Node[101];
    private int size=0;//当前哈希表的实际元素个数

    public void put(int key,int value){
        //根据key带入到哈希函数中计算得到下标
        int index=hashFunc(key);
        //根据下标得到对应的链表
        Node head=array[index];
        //先判断key是否存在
        for(Node cur=head;cur!=null;cur=cur.next){
            if(cur.key==key){
                cur.value=value;
                return;
            }
        }
        //如果没找到key再插入
        //链表头插
        Node newNode=new Node(key,value);
        newNode.next=head;
        array[index]=newNode;
        size++;

    }

    private int hashFunc(int key) {
        return (key%array.length);
    }

    public Integer get(int key){
        //根据key得到hash值
        int index=hashFunc(key);
        //在对应的链表上查找指定的key
        Node head=array[index];
        for(Node cur=head;cur!=null;cur=cur.next) {
            if (cur.key == key) {
                return cur.value;
            }

        }
        //没找到
        return null;

    }
    public void remove(int key){
        //删除
        //根据key找到下标
        int index=hashFunc(key);
        Node head=array[index];
        //前驱节点
        Node prev=head;
        Node cur=head;
        for(;cur!=null;cur=cur.next){
            if(cur.key==key){

            }
        }
    }

    public static void main(String[] args) {
        MyHashMap m=new MyHashMap();
        m.put(2,4);
        m.put(3,6);
        System.out.println(m.get(2));
    }
}
