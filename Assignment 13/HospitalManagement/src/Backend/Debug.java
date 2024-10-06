
package Backend;

import javax.swing.JOptionPane;

/**
 *
 * @author Junaid
 */
public class Debug {
    public static void showMessage (String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public static boolean isValidNumber (String input){
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    
    public static int confirmMessage (String message){
        return JOptionPane.showConfirmDialog(null, message);
    }

}
