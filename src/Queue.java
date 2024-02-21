public class Queue {

    int size;
    Node front;
    Node rear;
    static final int mexSize = 10;

    public Queue(){ //implement  constructor method
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty(){ //Check if the queue is empty or not
        return front == null;
    }

    public boolean isFull(){ //check if the queue is full or not.In here it never becomes full.
        return false;
    }

    public int size() { //return the current size of the queue
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void enqueue(Car car){ // enqueue method
        Node newNode  = new Node(car);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Car dequeue(){ // dequeue method
        if (isEmpty()){
            System.out.println("Queue is Empty. Cannot dequeue");
            return null;
        }
        Car removedCar = front.car;
        front = front.next;

        if(front == null){
            rear = null;
        }
        return removedCar;
    }

    public Car peek(){ // peek method
        if (isEmpty()){
            System.out.println("Queue is Empty. Cannot Peek.");
            return null;
        }
        return front.car;
    }

    public Car selectItem(int index) { //select and return the car object at the specified index in the queue
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot select item.");
            return null;
        }
        Node current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.car;
    }

    public void display() { // display method
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.car + " ");
            current = current.next;
        }
        System.out.println();
    }
}


