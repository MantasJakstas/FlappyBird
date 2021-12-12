
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class StartGui extends JPanel {
    public static int WIDTH = 800, HEIGHT = 800;
    public StartGui(){
        JFrame frame = new JFrame();
        frame.setSize(WIDTH,HEIGHT);
        frame.add(new Panel());
        frame.setTitle("Flappy Bird");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)  {
       new StartGui();
    }

}
