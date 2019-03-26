public interface Quene<E> {

    void  enqueue(E e);

    E dequene();
    E getFront();

    int getSize();

    boolean isEmpty();

}
