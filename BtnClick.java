import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class defines what happends when a button in the game field is clicked
 * If the arraylist of ship coordinates contains the text on the button pressed, the incHits method in the gameplay class is called
 * If the button pressed does not match a ship coordinate, the decMiss method in the Gameplay class is called
 * This class implements the ActionListener interface, acting as a custom ActionListener that is added to each button upon creation
 */
public class BtnClick implements ActionListener{

    private JButton btn;

    public BtnClick(JButton btn){
        this.btn = btn;
    }

    // This method is called when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e){

         /* the following code will only run if the label of the button exists as an element in the Ships coordinate arraylist.
            If the button label has been removed from the arraylist, this method does nothing. */
        if (e.getSource() == btn){
            if (Ships.getCoords().indexOf(btn.getText()) != -1){
                btn.setBackground(Color.RED); //changes the colour of the JButton to indicate a "hit"
                Ships.removePoint(btn.getText()); //remove this coordinate from the ship arraylist
                Runner.getGame().incHits(); //run the incHits() method in the GamePlay class
            } else {
                btn.setBackground(Color.BLUE); //changes the colour of the JButton to indicate a "miss"
                Runner.getGame().decMiss(); //run the decMiss() method in the GamePlay class
            }
            
        }
    }
}
