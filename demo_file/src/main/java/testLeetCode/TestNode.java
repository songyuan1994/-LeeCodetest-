package testLeetCode;

public class TestNode {
	private Node head = null;

	
	/**
     * 增加操作
     *         直接在链表的最后插入新增的结点即可
     *         将原本最后一个结点的next指向新结点
     */
    public void addNode(Node node){
        //链表中有结点，遍历到最后一个结点
        Node temp = head;    //一个移动的指针(把头结点看做一个指向结点的指针)
        while(temp.next != null){    //遍历单链表，直到遍历到最后一个则跳出循环。
            temp = temp.next;        //往后移一个结点，指向下一个结点。
        }
        temp.next = node;    //temp为最后一个结点或者是头结点，将其next指向新结点
    }
    
    /**
     * 计算链表长度
     */
    public int length(){
    	int len = 0;
    	Node temp = head;
    	while(temp.next != null){
    		temp = head.next;
    		len++;
    	}
    	return len;
    }
    
    /**
     * insertNodeByIndex:在链表的指定位置插入结点。
     *         插入操作需要知道1个结点即可，当前位置的前一个结点
     * index:插入链表的位置，从1开始
     * node:插入的结点
     */
    public void insertNodeByIndex(int index,Node node){
        //首先需要判断指定位置是否合法，
        if(index<1||index>length()+1){
            System.out.println("插入位置不合法。");
            return;
        }
        int length = 1;            //记录我们遍历到第几个结点了，也就是记录位置。
        Node temp = head;        //可移动的指针
        while(head.next != null){//遍历单链表
            if(index == length++){        //判断是否到达指定位置。
                //注意，我们的temp代表的是当前位置的前一个结点。
                //前一个结点        当前位置        后一个结点
                //temp            temp.next     temp.next.next
                //插入操作。
                node.next = temp.next;            
                temp.next = node;                
                return;
            }
            temp = temp.next;
        }
    }
}
