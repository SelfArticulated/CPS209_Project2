import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The GamePlay class is a panel that calculates the current hit count and miss count
 * It creates a pop-up JFrame that appears when the user wins or loses the game
 * */
public class GamePlay extends JPanel{

    //creates the labels and text fields which display the counters
    private static int hitCount;
    private static int missCount;
    private JTextArea l2 = new JTextArea();
    private JTextArea l4 = new JTextArea();

    //the constructor adds all information to the panel
    public GamePlay(int miss){
        this.setPreferredSize(new Dimension(200, 700));
        this.setBackground(new Color(200, 120, 240));
        missCount = miss;
        JLabel l1 = new JLabel("Hits:");
        JLabel l3 = new JLabel("Misses Left:");
        l2.setText(String.valueOf(hitCount));
        l4.setText(String.valueOf(missCount));
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
    }

    //getters
    public int getHits(){ return hitCount; }
    public int getMiss(){ return missCount; }

    //increments the hit value - checks if all ships have been hit
    public void incHits(){ 
        hitCount++;
        l2.setText(String.valueOf(hitCount)); 
        if (hitCount == Ships.getPoints().size()){
            Ships.getPoints().clear();
            Ships.getCoords().clear();
            WinGame();
        }
    }

    //decrements the miss counter - checks if user is out of miss clicks
    public void decMiss(){ 
        missCount--; 
        l4.setText(String.valueOf(missCount));
        if (missCount == 0){
            Ships.getPoints().clear();
            Ships.getCoords().clear();
            LoseGame();
        }
    }

    //run if the user wins the game
    //creates a new WinGame panel
    public static void WinGame(){
        JFrame f = new JFrame("WIN!");
        f.add(new WinPanel());
        f.pack();
        f.setVisible(true);
    }

    //runs if the user loses the game
    public static void LoseGame(){
        JFrame f = new JFrame("LOSE");
        f.add(new LosePanel());
        f.pack();
        f.setVisible(true);
    }
}

/**
 * the panel to be displayed if the user wins the game
 */
class WinPanel extends JPanel{

    Timer timer = new Timer();

    public WinPanel(){
        this.setPreferredSize(new Dimension(500, 500));
        timer.schedule(task1, 10000);
    }

    //paints a smiley face on the panel, and a label with the word "WIN!"
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
         g2d.setColor(Color.YELLOW);
        g2d.fill(new Ellipse2D.Double(50, 50, 400, 400));
        g2d.setColor(Color.BLACK);
        g2d.fill(new QuadCurve2D.Double(100, 280, 250, 500, 400, 280));
        g2d.fill(new Ellipse2D.Double(150, 150, 50, 50));
        g2d.fill(new Ellipse2D.Double(320, 150, 50, 50));
        JLabel label = new JLabel();
        label.setBounds(200, 200, 200, 100);
        label.setFont(label.getFont().deriveFont(144.0f));
        label.setText("WIN!");
        this.add(label);
    }

    TimerTask task1 = new TimerTask(){
        @Override
        public void run(){
            System.exit(0);
            timer.cancel();
        }
    };


}

/**
 * the panel to be displayed if the user loses the game
 */
class LosePanel extends JPanel {

    Timer timer = new Timer();

    public LosePanel(){
        this.setPreferredSize(new Dimension(500, 500));
        timer.schedule(task1, 10000);
    }

    //Paints a dramatically upset sad face on the JPanel, as well as the word "LOSE" in a jLabel
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
         g2d.setColor(Color.YELLOW);
        g2d.fill(new Ellipse2D.Double(50, 50, 400, 400));
        g2d.setColor(Color.BLACK);
        g2d.fill(new QuadCurve2D.Double(100, 380, 250, -5, 400, 380));
        g2d.fill(new Ellipse2D.Double(150, 150, 50, 50));
        g2d.fill(new Ellipse2D.Double(320, 150, 50, 50));
        JLabel label = new JLabel();
        label.setBounds(200, 200, 200, 100);
        label.setFont(label.getFont().deriveFont(144.0f));
        label.setText("LOSE!");
        this.add(label);

    }

    TimerTask task1 = new TimerTask(){
        @Override
        public void run(){
            System.exit(0);
            timer.cancel();
        }
    };

}


