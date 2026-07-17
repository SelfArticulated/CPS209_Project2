
/* Programmer: Sydney Driegen
 * Toronto Metropolitan University CPS209 Project 2
 * 
 * This program is a simple, single-player game that resembles Hasbro's Battleship.
 * The program creates a battleship gameboard and randomly places 5 ships of differing lenghts on the playing field.
 * The gameboard is made up of 100 JButtons, whic change colour when clicked.
 * If the user clicks a button where a ship is placed, the button will turn red, and the hits counter will increase.
 * If the user clicks a button where no ship is placed, the button will turn blue, and the miss counter will decrease.
 * The game can be won if the hit counter is equivalent to the sum of lengths of all the ships. In this case, a win screen will appear.
 * The game can be lost if the miss counter is equivalent to 0. In this case, a lose counter will appear.
 * This game can be played with a differing miss counter which can be updated in this class to alter the difficulty
 * Likewise, in this class, the number of ships and their lengths can be updated. Note that the ships may NOT exceed length 10.
 * 
 * This program optimizes the use of multiple JFrames which contain their own components. The main JFrame contains panels with a series of
 * buttons, labels, and text areas.
 * The win/lose JFrames contain 2D shapes to create happy/sad faces depending on whether the game is won or lost.
 * The actionlistener is defined in the BtnClick class.
 */

import javax.swing.*;

public class Runner {

    private static Testbox a;
    private static GamePlay b;

    public static void main(String[] args) throws Exception {
        
        JFrame f = new JFrame("Ship Wars!");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        a = new Testbox();
        b = new GamePlay(30);
        panel.add(a);
        panel.add(b);
        f.add(panel);
        f.pack();
        f.setVisible(true);

        Ships s1 = new Ships(5);
        Ships s2 = new Ships(4);
        Ships s3 = new Ships(3);
        Ships s4 = new Ships(2);
        Ships s5 = new Ships(3);
        s1.LayShips();
        s2.LayShips();
        s3.LayShips();
        s4.LayShips();
        s5.LayShips();
    }

    public static Testbox getBox(){
        return a;
    }
    public static GamePlay getGame(){
        return b;
    }
}
