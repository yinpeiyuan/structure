public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
            array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
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
        Stack<Integer> stack = new ArrayStack<>();
        for(int i = 0;i < 5 ;i++) {
            stack.push(1);
            System.out.println(stack);
        }
        for(int i = 0;i < 7 ;i++){
            stack.pop();
            System.out.println(stack);
        }

    }

}
