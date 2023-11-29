public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> ls = new MyLinkedList<Integer>();
//
//
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);

        System.out.println(ls.toString());

        ls.forEach(System.out::println);

//        MyStack<Integer> st = new MyStack<>();
//        st.push(1);
//        st.push(2);

//        System.out.println(st);


//        System.out.println(ls.forEachRemaining());


    }
}
