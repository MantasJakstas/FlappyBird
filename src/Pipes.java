import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pipes extends Objects {
    private Rectangle pipeTop;
    private Rectangle pipeBottom;
    public ArrayList<Pipes> pipes = new ArrayList<>();

   public Pipes(int gap){
       Random rand = new Random();
       int n = rand.nextInt(500)+100;
       pipeTop = new Rectangle(StartGui.WIDTH,0,50,n);
       int left = StartGui.WIDTH - n - gap;
       pipeBottom = new Rectangle(StartGui.WIDTH,n+gap,50,left);

   }
/*   public void bark(String mes) {
       System.out.println(mes);
   }*/
    public void move(int movement) {
        pipeTop.x -= movement;
        pipeBottom.x -= movement;
    }
    @Override
    void drawObject(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(pipeTop.x, pipeTop.y, pipeTop.width, pipeTop.height);
        g.fillRect(pipeBottom.x, pipeBottom.y, pipeBottom.width, pipeBottom.height);
    }
    @Override
    void reset() {
    }
    public Rectangle getPipeTop() {
        return pipeTop;
    }
    public Rectangle getPipeBottom() {
        return pipeBottom;
    }
}
