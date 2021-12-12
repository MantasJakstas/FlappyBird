import java.awt.*;

abstract class Objects {

    public Objects() {
    }
/*    public void bark(String mes){
        System.out.println(mes);
    }*/
    public void move(int movement){
        movement += 10;
    }
    /*abstract void move();*/
    abstract void drawObject(Graphics g);
    abstract void reset();


}
