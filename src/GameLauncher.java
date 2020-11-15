import javax.swing.*;

class GameLauncher {
    public static void main(String[] args){
        GameFrame gf = new GameFrame();
        gf.add(new GamePanel());
        gf.pack();
        gf.setSize(800,800);
        gf.setResizable(false);
        gf.setVisible(true);

        gf.setDefaultCloseOperation(gf.EXIT_ON_CLOSE);
    }
}
