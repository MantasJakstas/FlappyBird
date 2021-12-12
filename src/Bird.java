import java.awt.*;

public class Bird extends Objects{
    private int gravity = -2;
    private Rectangle bird;
    public Bird() {
        bird = new Rectangle(Panel.WIDTH , Panel.HEIGHT, 20, 20);
    }
    public void birdLogic() {
        bird.y += gravity;
        if (gravity < 15) {
            gravity += 1;
        }
    }

    public void bark(String mes) {
        System.out.println(mes);
    }

    public void move(int movement) {
        if(gravity < -5) {
            gravity -= 1;
        }else gravity -= movement;
    }

    @Override
    public void drawObject(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(bird.x,bird.y, 20,20);
    }

    @Override
    void reset() {
        bird.x = 200;
        bird.y = 200;
        gravity = 1;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public Rectangle getBird() {
        return bird;
    }

}
