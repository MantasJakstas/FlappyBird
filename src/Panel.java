
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.plaf.PanelUI;

public class Panel extends JPanel implements KeyListener, ActionListener
{
    public int WIDTH = 200, HEIGHT = 400;
    public Rectangle bird = new Rectangle(WIDTH , HEIGHT, 20, 20);
    public int birdY = 0, gravity = 2;
    public int time = 0;
    //Pipes pipe = new Pipes();
    public ArrayList<Pipes> pipes = new ArrayList<>();
    public boolean gameover = true;
    public int score = 0;
    public Font font;


    public Panel(){
        Timer timer = new Timer(20,this);
        timer.start();
        setFocusable(true);
        addKeyListener(this);
        JLabel jScore = new JLabel();
        jScore.setLocation(50,50);
        jScore.setText("Score: ");
        jScore.setSize(60,20);
    }
    public void addPipe(){
        pipes.add(new Pipes());
    }
    public void removePipe(){
        pipes.remove(0);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        //System.out.println("paintComponent has been calles");
        super.paintComponent(g);
        //System.out.println(WID);
        draw(g);
        drawWall(g);
        drawString(g);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("action performed");
        //System.out.println(pipe.speed);
        if(gameover) {
            for (Pipes r : pipes) {
                r.pipeTop.x -= 5;
                r.pipeBottom.x -= 5;
            }
            time++;
            if (time % 90 == 0) {
                addPipe();
            }


            bird.y += gravity;
            if (gravity < 15) {
                gravity += 1;
            }
            //System.out.println(bird.y);
            for (Pipes r : pipes) {
                //System.out.println(r.pipeTop.height);
                /*if((bird.y <= r.pipeTop.height && bird.x == r.pipeTop.x)|| (bird.y >= 800-r.pipeBottom.height && bird.x == r.pipeBottom.x )){
                    //System.out.println("Collison");
                    gameover = false;
                }*/
                if( (r.pipeBottom.contains(bird.x,bird.y)) || ((r.pipeTop.contains(bird.x,bird.y)) )){
                    gameover = false;
                }
                if(bird.x == r.pipeTop.x){
                    score++;
                }
                if(r.pipeTop.x == 0){
                    removePipe();
                }
            }


            repaint();
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(bird.x,bird.y, bird.width,bird.height);
    }
    public void drawWall(Graphics g){
        for(Pipes r: pipes) {
            g.setColor(Color.BLACK);
            g.fillRect(r.pipeTop.x, r.pipeTop.y, r.pipeTop.width, r.pipeTop.height);

            g.setColor(Color.BLACK);
            g.fillRect(r.pipeBottom.x, r.pipeBottom.y, r.pipeBottom.width, r.pipeBottom.height);
        }

    }
    public void drawString(Graphics g){
        font = new Font("Arial", Font.BOLD, 30);
        g.setColor(Color.BLUE);
        g.setFont(font);
        g.drawString("Score "+score,15,30);
    }
    public void reset(){
        bird.x = 200;
        bird.y = 200;
        score = 0;
        gravity = 1;
        removePipe();
        removePipe();
        //removePipe();
        time = 0;
        gameover = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("key pressed");
        if(e.getKeyCode() == e.VK_SPACE){
            System.out.println(gravity);
            if(gravity < -5) {
                gravity -= 1;
            }else gravity -= 15;
        }
        if(e.getKeyCode() == e.VK_W){
            System.out.println("Added a pipe");
            addPipe();
        }
        if(e.getKeyCode() == e.VK_R){
            System.out.println("R");
            reset();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}