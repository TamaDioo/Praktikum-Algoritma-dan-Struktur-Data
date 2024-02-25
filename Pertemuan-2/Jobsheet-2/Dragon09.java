public class Dragon09 {
    int x, y, width, height;
    boolean gameOver;

    public Dragon09(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void moveLeft() {
        x--;
        if (x < 0 || x > width) {
            detectCollision(x, y);
        } else {
            if (gameOver != true) {
                position();
            } 
        }
    }

    void moveRight() {
        x++;
        if (x < 0 || x > width) {
            detectCollision(x, y);
        } else {
            if (gameOver != true) {
                position();
            } 
        } 
    }

    void moveUp() {
        y--;
        if (y < 0 || y > height) {
            detectCollision(x, y);
        } else {
            if (gameOver != true) {
                position();
            }      
        }
    }

    void moveDown() {
        y++;
        if (y < 0 || y > height) {
            detectCollision(x, y);
        } else {
            if (gameOver != true) {
                position();
            }         
        }
    }

    void detectCollision(int x, int y) {
        System.out.println("Game Over!");
        gameOver = true;
    }

    void position() {
        System.out.println("Position : x = " + x +", y = " + y); 
    }
}