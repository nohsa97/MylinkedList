import java.util.Iterator;
import java.util.function.Consumer;
import java.util.*;

public class MyLinkedList<T> implements Iterator {

    private int pointer = 0;

    private LinkNode<T> head = null;
    private LinkNode<T> tail = null;
    private int size = 0;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public LinkNode<T> getHead() {
        return head;
    }

    public void setHead(LinkNode<T> head) {
        this.head = head;
    }

    public LinkNode<T> getTail() {
        return tail;
    }

    public void setTail(LinkNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public class LinkNode<T> {
        T data;
        LinkNode<T> nextNode;

        LinkNode(T insert) {
            this.data = insert;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "data=" + data +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }


    public LinkNode<T> search(int index) {
        LinkNode<T> x = head;

        for(int i = 0 ; i < index ; i++ ){
            x = x.nextNode;
        }

        return x;
    }

    public void addFirst(T insert) {
        LinkNode<T> newLN = new LinkNode<T>(insert);

        newLN.nextNode = head;
        head = newLN;
        size++;

        if(newLN.nextNode == null) {
            tail = head;
        }
    }

    public void addLast(T insert) {
        LinkNode<T> newLN = new LinkNode<T>(insert);

        tail.nextNode = newLN;
        tail = newLN;
        size++;

    }

    public void add(T insert) {
        if(size == 0) {
            addFirst(insert);
            return;
        }
        addLast(insert);
        return;
    }

    public void add(T insert, int index) {

        LinkNode<T> prevNode = search(index - 1);
        LinkNode<T> nextNode = prevNode.nextNode;
        LinkNode<T> newLN = new LinkNode<T>(insert);

        prevNode.nextNode = newLN;
        newLN.nextNode = nextNode;
        size++;
    }

    public T get (int index) {

        LinkNode<T> searchNode = search(index);
        return searchNode.data;
    }



    public T delete(int index) {
        LinkNode<T> removeNode = search(index);
        LinkNode<T> nextNode = removeNode.nextNode;
        LinkNode<T> prevNode = search(index - 1);

        T removed = removeNode.data;

        if(index == 0) {
            head = removeNode.nextNode;
            removeNode.data = null;
            removeNode.nextNode = null;
            size--;
            return removed;
        }

        if(index == size - 1) {
            tail = prevNode;
            prevNode.nextNode = null;
            removeNode.data = null;
            removeNode.nextNode = null;
            size--;
            return removed;
        }

        prevNode.nextNode = nextNode;
        removeNode.nextNode = null;
        removeNode.data = null;
        size--;


        return removed;
    }

    @Override
    public boolean hasNext() {

        if(size == 0) {
            System.out.println("내용 없음");
            return false;
        }

        if(pointer < size) {
            return true;
        }

        return false;
    }

    @Override
    public Object next() {
        LinkNode<T> x = head;

        if(pointer >= size) {
            System.out.println("불가능한 접근 입니다");
            return false;
        }

        if(size == 0){
            System.out.println("실행 불가");
            return false;
        }

        for(int i = 0 ; i < size ; i++ ){
            if(pointer == 0){
                pointer++;
                return x.data;
            }

            x = x.nextNode;
            if(i == pointer - 1){
               pointer++;
               return x.data;
            }
        }
        return null;
    }


    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }
}
