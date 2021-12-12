
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener, ActionListener
{
    public static final int WIDTH = 200, HEIGHT = 400;
    private final Bird bird = new Bird();
    ArrayList<Pipes> pipes = new ArrayList<>();
    private int time = 0;
    private boolean gameover = true;
    private int score = 0;

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


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        bird.drawObject(g);
        drawWall(g);
        drawString(g);

    }
    public void addPipe(){
        pipes.add(new Pipes(150));
    }
    public void removePipe(){
        pipes.remove(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameover) {
            for (Pipes r : pipes) {
                r.move(5);
            }
            time++;
            if (time % 90 == 0) {
               addPipe();
            }
            bird.birdLogic();

            for (Pipes r : pipes) {
                if( (r.getPipeBottom().contains(bird.getBird().x,bird.getBird().y)) || ((r.getPipeTop().contains(bird.getBird().x,bird.getBird().y)) )){
                    gameover = false;
                }
                if(bird.getBird().x == r.getPipeTop().x){
                    score++;
                }
                if(r.getPipeTop().x == 0){
                    removePipe();
                }
            }
            repaint();
        }
    }

    public void drawWall(Graphics g){
        for(Pipes r: pipes) {
            r.drawObject(g);
        }
    }
    public void drawString(Graphics g){
        Font font = new Font("Arial", Font.BOLD, 30);
        g.setColor(Color.BLUE);
        g.setFont(font);
        g.drawString("Score "+score,15,30);
    }
    public void reset(){
        bird.reset();
        removePipe();
        removePipe();
        score = 0;
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
            //System.out.println(gravity);
           bird.move(15);
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