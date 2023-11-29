public class MyQueue<T> {
    MyLinkedList<T> newStack;


    public MyQueue() {
        this.newStack = new MyLinkedList<T>();
    }

    public void add(T insert) {
        newStack.add(insert);
    }
    //
    public T poll() {
        int size = newStack.getSize();

        MyLinkedList.LinkNode removeNode = newStack.search(0);

        if(size == 0) {
            System.out.println("존재하지 않음");
            return null;
        }
        newStack.setHead(removeNode.nextNode);
        T removed = newStack.getHead().data;

        removeNode.nextNode = null;
        removeNode.data = null;

        newStack.setSize(size - 1);

        return removed;
    }
}
