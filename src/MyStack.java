public class MyStack<T> {

    MyLinkedList<T> newStack;


    public MyStack() {
        this.newStack = new MyLinkedList<T>();
    }

    public void push(T insert) {
        newStack.add(insert);
    }
//
    public T pop() {
        int size = newStack.getSize();

        MyLinkedList.LinkNode removeNode = newStack.search(size - 1);
        MyLinkedList.LinkNode prevNode = newStack.search(size - 2);

        if(size == 0) {
            System.out.println("존재하지 않음");
            return null;
        }
        removeNode.nextNode = null;
        removeNode.data = null;
        prevNode.nextNode = null;

        T removed = newStack.getTail().data;
        newStack.setTail(prevNode);
        newStack.setSize(size - 1);

        return removed;
    }

}

