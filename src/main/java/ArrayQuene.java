public class ArrayQuene<E> implements Quene<E> {

    private Array<E> array;

    public ArrayQuene(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQuene(){
        array = new Array<>();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequene() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Quene: [");
        for(int i = 0;i < getSize();i++){
            sb.append(array.get(i));
            if(i != getSize()-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        Quene<Integer> q = new ArrayQuene<>();
        for (int i = 1 ; i <10 ; i++){
            q.enqueue(i);
            System.out.println(q);
            if(i%3==0){
                q.dequene();
                System.out.println(q);
            }

        }
    }
}
