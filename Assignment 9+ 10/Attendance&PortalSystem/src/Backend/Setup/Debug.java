package Backend.Setup;

import javax.swing.JOptionPane;

public class Debug {

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static int confirmMessage (String message){
        return JOptionPane.showConfirmDialog(null, message);
    }
}
