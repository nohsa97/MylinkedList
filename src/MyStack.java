
public class MyStack<T> extends MyLinkedList{


    public MyStack() {
        super();
    }

    public void push(T insert) {
        addLast(insert);
    }

    public T pop() {
        int size = getSize();

        LinkNode prevNode = search(size - 1);
        LinkNode nextNode = prevNode.nextNode;

        if(size == 0) {
            System.out.println("존재하지 않음");
            return null;
        }
        setTail(prevNode);
        prevNode.nextNode = null;
        prevNode.data = null;
        T removed = (T)getTail().data;

        return removed;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                ", tail=" + getTail() +
                ", size=" + getSize() +
                '}';
    }


}
//    public T delete(int index) {
//        LinkNode<T> removeNode = search(index);
//        LinkNode<T> nextNode = removeNode.nextNode;
//        LinkNode<T> prevNode = search(index - 1);
//
//        T removed = removeNode.data;
//
//        if(index == 0) {
//            head = removeNode.nextNode;
//            removeNode.data = null;
//            removeNode.nextNode = null;
//            size--;
//            return removed;
//        }
//
//        if(index == size - 1) {
//            tail = prevNode;
//            prevNode.nextNode = null;
//            removeNode.data = null;
//            removeNode.nextNode = null;
//            size--;
//            return removed;
//        }
//
//        prevNode.nextNode = nextNode;
//        removeNode.nextNode = null;
//        removeNode.data = null;
//        size--;
//
//
//        return removed;
//    }
