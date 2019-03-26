import java.util.Random;

public class LoopQuene<E> implements Quene<E> {

    private  E[] data;
    private  int front,tail;
    private  int size;

    public int getCapacity(){
        return  data.length-1;
    }
    public LoopQuene(int capacity){
        data = (E[])new Object[capacity+1];
        front = tail = size = 0 ;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail+1)% data.length;
    }

    private void resize(int capacity){
        E[] newData = (E[]) new Object[capacity+1];
        for(int i =0;i < size;i++){
            newData[i] = data[( i+front ) % data.length];

        }
        front=0;
        tail =size;
        data = newData;
    }

    @Override
    public E dequene() {
        if(isEmpty()){
            throw new IllegalArgumentException("cannot");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size--;
        if(size == getCapacity()/4&& getCapacity()/2 !=0 ){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw  new IllegalArgumentException("Quene is Empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail==front;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQuene: size:%d capacity:%d\n front [",size,getCapacity()));
        for(int i = front;i != tail;i = (i+1)%data.length){
            sb.append(data[i]);
            if((i+1)%data.length != tail){
                sb.append(", ");
            }
        }
        sb.append(" ] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
//        Quene<Integer> q = new LoopQuene<>(10);
//        for (int i = 1 ; i <10 ; i++){
//            q.enqueue(i);
//            System.out.println(q);
//            if(i%3==0){
//                q.dequene();
//                System.out.println(q);
//            }
//
//        }
    }
}
