public class Array<E> {
    private  E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return  data.length;
    }
    public boolean isEmpty(){
        return  size==0;
    }
    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){

        if(index<0 || index>size){
            throw  new IllegalArgumentException("Add fail");
        }
        if(size == data.length){
             resize(2 * data.length);
        }

        for(int i = size-1; i>=index; i--){
                data[i+1] =data[i];
            }
        data[index]=e;
        size++;
        }

        private  void resize(int newCapacity){
            E[] newData = (E[])new Object[newCapacity];
            for(int i = 0;i < size;i++){
                newData[i] = data[i];
            }
            data = newData;
        }


    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("size=%d,capacity=%d\n",size,data.length));
        res.append("Array=[");
        for(int i=0;i<=size-1;i++){
            res.append(data[i]);
                if(i!=size-1){
                    res.append(",");
                }
        }
        res.append("]");
        return res.toString();
    }

    public E get(int index){
        if(index < 0||index >= size){
            throw new IllegalArgumentException("Get fail");
        }
        return data[index];
    }

    public E getLast(){
        return  get(size-1);
    }

    public E getFirst(){
        return  get(0);
    }
    public void set(int index,E e){
        if(index < 0||index >= size){
            throw new IllegalArgumentException("Get fail");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for(int i = 0; i < size ; i++){
            if(data[i].equals(e)){
                return true;
            }

        }
        return false;
    }

    public int find(E e){
        for(int i = 0;i < size;i++){
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    public E remove(int index){
        if(index < 0||index >= size){
            throw new IllegalArgumentException("Get fail");
        }
        E ret = data[index];
        for(int i=index+1;i < size ;i++ ){
            data[i-1] =data[i];
        }


        size--;
        data[size]=null;
        if(size < data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    public void  removeElement(E e){
        int index = find(e);

        if(index != -1){
            remove(index);
        }

    }

    public static void main(String[] args) {
        Student student1 = new Student("may",20);
        Student student2 = new Student("may2",20);
        Student student3 = new Student("ma4",20);
        Array<Student> array = new Array<>();
        int i = 0;
        while ( i<15){
        array.addLast(student1);
        array.addLast(student2);
        array.addLast(student3);
        i++;
        }

        System.out.println(array.toString());
        i = 0;
        while (i < 16){
          array.removeElement(student1);
            i++;
        }

        System.out.println(array.toString());
    }
}
