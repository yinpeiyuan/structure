public class LinkedList<E> {

    private  class  Node{
        private E e;
        private Node next;

        public  Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public  Node(E e){
            this.e = e;
        }
        public  Node(){
            this(null,null);
        }
        public String toString(){
            return  e.toString();
        }
    }
    private Node dummyHead ;
    private  int size;
    public LinkedList(){
       dummyHead = new Node(null,null);
        size = 0;
    }
    public int getSize(){
        return size ;
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if(index < 0 && index > size){
            throw new IllegalArgumentException("fail");
        }

        Node pre = dummyHead ;
            for(int i = 0; i < index ;i++ ){
                pre = pre.next;
            }
            pre.next = new Node(e,pre.next);
            size++;



    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        Node goal = dummyHead ;
        for(int i =0 ;i <= index ; i++){
             goal =  goal.next;
        }
        return goal.e;
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size);
    }
    //update

    public void set(E e,int index){
        Node goal = dummyHead ;
        for(int i =0;i <= index;i++){
            goal =goal.next;
        }
        goal.e = e;
    }
    public boolean contains(E e){
        Node goal = dummyHead.next;
        while (goal!=null){
            if(goal.e == e){
                return true;
            }
            goal = goal.next;
        }
        return false;
    }
    public E remove(int index){
        Node pre = dummyHead;
        for(int i = 0; i < index;i++){
            pre = pre.next;
        }
        Node retNode = pre.next;

        pre.next=retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return  remove(size-1);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList : ");
        Node goal = dummyHead.next;
        while (goal!=null){

            sb.append(goal+"->");
            goal = goal.next;

        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i= 0;i < 5;i++){
            linkedList.addFirst(i);

        }
        linkedList.add(2,4);
        System.out.println(linkedList);
        linkedList.remove(4);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
    }
}
