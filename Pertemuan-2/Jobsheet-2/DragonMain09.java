public class DragonMain09 {
    public static void main(String[] args) {
        Dragon09 dragon1 = new Dragon09(6, 12, 12, 15);
        dragon1.moveLeft();
        dragon1.moveLeft();
        dragon1.moveDown();
        dragon1.moveUp();
        dragon1.moveDown();
        dragon1.moveDown();
        dragon1.moveDown();
        dragon1.moveRight();
        dragon1.moveDown(); 
        dragon1.moveRight(); //method tidak tereksekusi karena sudah game over
        dragon1.moveUp(); //method tidak tereksekusi karena sudah game over     
        dragon1.moveUp(); //method tidak tereksekusi karena sudah game over     
    }
}