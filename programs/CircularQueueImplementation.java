public class CircularQueueImplementation {
    static class Queue {
        int arr[];
        int size;
        int front;
        int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("The Queue is full");
                return;
            }

            if (isEmpty()) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("The Queue is empty");
                return -1;
            }

            int result = arr[front];

            if (front == rear) {
                // Queue has only one element
                front = rear = -1;
            } 
            else {
                front = (front + 1) % size;
            }

            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("The Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5); // This will fill the queue
        // q.add(6); // This will show "The Queue is full"

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
