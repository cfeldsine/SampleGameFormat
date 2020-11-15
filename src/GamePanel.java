import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;



public class GamePanel extends JPanel {
    private Timer timer;
    private boolean w,a,s,d;
    private Image image;


    public GamePanel(){
        setLayout(null);
        setOpaque(true);
        this.setBackground(new Color(100,100,200));
        setUpKeyMappings();
        setUpTimer();
        repaint();
        openImages();
    }


    private void tick(){
        if (w){
            System.out.print("w");
        }
        if (a){
            System.out.print("a");
        }
        if (s){
            System.out.print("s");
        }
        if (d){
            System.out.print("d");
        }
        System.out.println();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(50,50,100,100);
        g.drawImage(image, 100,100,null);
    }


    private void setUpKeyMappings() {
        this.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "beginRight");
        this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "endRight");
        this.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "beginLeft");
        this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "endLeft");
        this.getInputMap().put(KeyStroke.getKeyStroke("pressed W"), "beginUp");
        this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "endUp");
        this.getInputMap().put(KeyStroke.getKeyStroke("pressed S"), "beginDown");
        this.getInputMap().put(KeyStroke.getKeyStroke("released S"), "endDown");


        this.getActionMap().put("beginRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d = true;
            }
        });

        this.getActionMap().put("endRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d=false;
            }
        });

        this.getActionMap().put("beginLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=true;
            }
        });

        this.getActionMap().put("endLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=false;
            }
        });
        this.getActionMap().put("beginUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w=true;

            }
        });

        this.getActionMap().put("endUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w=false;
            }
        });
        this.getActionMap().put("beginDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s=true;
            }
        });

        this.getActionMap().put("endDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s=false;
            }

        });
        this.requestFocusInWindow();


    }

    private void setUpTimer() {
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tick();
            }
        });
        timer.start();
    }

    private void openImages() {
        if (image == null) {
            try {
                URL url = getClass().getResource("images/user-male.png");
                image = ImageIO.read(url);
            } catch (Exception e) {
                System.out.println("Image could not be opened: " + "images/" + "red" + ".png");
                e.printStackTrace();
            }
        }
    }
}
