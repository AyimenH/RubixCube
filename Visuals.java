import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;

public class Visuals implements KeyListener {

    public static JFrame frame;
    RubixCube cube;
    

    public Visuals(){
        cube = new RubixCube();
        frame = new JFrame();
        int WIDTH = 900;
        int HEIGHT = 900;
        int offset = 380;

        frame.setBounds(10,10,WIDTH,HEIGHT);
        frame.setUndecorated(true);
        JPanel pn = new JPanel(){
            public void paint(Graphics g){
                g.setColor(Color.BLACK);
                g.fillRect(0,0,WIDTH,HEIGHT);

                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        String color = cube.front[j][i];
                        switch(color){
                            case "W":
                                g.setColor(Color.WHITE);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                            case "Y":
                                g.setColor(Color.YELLOW);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                            case "R":
                                g.setColor(Color.RED);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                            case "B":
                                g.setColor(Color.BLUE);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                            case "G":
                                g.setColor(Color.GREEN);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                            case "O":
                                g.setColor(Color.ORANGE);
                                g.fillRect(offset+50*i,offset+50*j,45,45);
                                break;
                        }
                    }
                }
            }
        };
        frame.add(pn);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        cube.rotate(e.getKeyChar());
        cube.move(e.getKeyChar());
        frame.repaint();
        cube.print();
    }

}
