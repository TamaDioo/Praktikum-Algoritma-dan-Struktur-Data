public class BinaryTreeArrayMain09 {
    public static void main(String[] args) {
        BinaryTreeArray09 bta = new BinaryTreeArray09();
        int[] data = {6,4,8,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        System.out.print("\nInOrder Traversal : ");
        bta.traverseInOrder(0);
        System.out.print("\nPreOrder Traversal : ");
        bta.traversePreOrder(0);
        System.out.print("\nPostOrder Traversal : ");
        bta.traversePostOrder(0);
        System.out.println("\n");
    }
}