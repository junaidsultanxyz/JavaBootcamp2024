package Backend.Setup;

public class Functions {
    public static boolean IntegerVerify (String input){

        try{
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
