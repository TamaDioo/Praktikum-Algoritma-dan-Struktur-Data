public class StackKonversi09 {
    int size, top;
    int[] tumpukanbiner;

    public StackKonversi09() {
        this.size = 32; //asumsi 32 bit
        tumpukanbiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh");
        } else {
            top++;
            tumpukanbiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanbiner[top];
            top--;
            return data;
        }
    }
}
