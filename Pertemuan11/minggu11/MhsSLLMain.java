package Pertemuan11.minggu11;

public class MhsSLLMain {
    public static void main(String[] args) {
        MhsSLL mhsLL = new MhsSLL();
        mhsLL.addFirst(111, "Anton");
        mhsLL.print();   
        mhsLL.insertAfter(111, 112, "Prita");
        mhsLL.print();
        mhsLL.insertAt(2, 113, "Yusuf");
        mhsLL.print();
        mhsLL.addLast(115, "Sari");
        mhsLL.print();
        mhsLL.insertAfter(113, 114, "Doni");
        mhsLL.print();
    }
}