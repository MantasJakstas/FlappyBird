import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Pipes {
    public Rectangle pipeTop;
    public Rectangle pipeBottom;
    public int speed = 5;
    public ArrayList<Pipes> pipes = new ArrayList<>();



   public Pipes(){
       //int width = StartGui.WIDTH;
       Random rand = new Random();
       int n = rand.nextInt(500)+100;
       pipeTop = new Rectangle(StartGui.WIDTH,0,50,n);
       int gap = 150;
       int left = StartGui.WIDTH - n - gap;
       pipeBottom = new Rectangle(StartGui.WIDTH,n+gap,50,left);

   }

}
