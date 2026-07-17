//necessary libraries are imported
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/*
The JPanel that holds the game field.
The Panel is layed out in a grid format to hold 100 JButtons in a 10 by 10 grid
 */
public class Testbox extends JPanel {

    private static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}; //A list of the first 10 alphabetic characters, used to label the grid
    private static HashMap<String, JButton> btns = new HashMap<String, JButton>(); //A hashmap with each key (coordinate String, ex. B4) linked to a specific JButton on the grid

    /**
     * The constructor for this class defines the size and layout of the jpanel
     * It also adds the buttons and sets their initial background color to white
     * Each button is given a custom Action Listener, defined in the BtnClick class
     */
    public Testbox(){
        this.setPreferredSize(new Dimension(700, 700));
        this.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++){
            for (int j = 1; j < 11; j++){
                JButton btn = new JButton(letters[i] + String.valueOf(j));
                btns.put(letters[i] + String.valueOf(j), btn);
                btn.setBackground(Color.WHITE);
                btn.addActionListener(new BtnClick(btn));
                this.add(btn);
            }
        }
    }

    //public getters to access private variables in this class
    public static char[] getLetters() { return letters; }
    public static HashMap<String, JButton> getMap() { return btns; }
    public JButton getButton(String e){ return btns.get(e); }

}
