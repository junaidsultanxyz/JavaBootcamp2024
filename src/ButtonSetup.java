import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonSetup {
    public String code;
    public JButton button;

    public ButtonSetup(JButton button, String code){
        this.button = button;
        this.code = code;

        this.button.setBackground(Color.white);
        this.button.setForeground(Color.black);
        this.button.setBorderPainted(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.CENTER);

        if (this.code.charAt(0) == '0'){
            this.button.setIcon(new ImageIcon("src/ButtonImage.png"));
        }
        else if (this.code.charAt(0) == '$'){
            this.button.setIcon(new ImageIcon("src/OrangeButton.png"));
        }
        else if (this.code.charAt(0) == '&'){
            this.button.setIcon(new ImageIcon("src/BigBlueButton.png"));
        }
        else if (this.code.charAt(0) == '_'){
            if (this.code.equalsIgnoreCase("_SHIFT") || this.code.equalsIgnoreCase("_ALPHA")){
                this.button.setForeground(Color.blue);
                this.button.setIcon(new ImageIcon("src/ButtonImageScientific.png"));
            }
            else if (this.code.equalsIgnoreCase("_DELETE") || this.code.equalsIgnoreCase("_CLEAR_SCREEN")){
                this.button.setForeground(Color.red);
                this.button.setIcon(new ImageIcon("src/ButtonImageScientific.png"));
            }
            else{
                this.button.setForeground(Color.black);
                this.button.setIcon(new ImageIcon("src/ButtonImageScientific.png"));
            }
            
        }
    }
}
