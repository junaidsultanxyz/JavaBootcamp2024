
package Backend;

/**
 *
 * @author Junaid Sultan
 */
public class Other {
    public static boolean isValidNumber(String input){
        try {
            Double.parseDouble(input);
            return true;
        }
        catch (Exception e) { return false;}
    }
}
