public class Functions {

    public static void ReloadScreen(){
        Calculator.SCREEN.setText(Calculator._SCREEN_MESSAGE);
        Calculator.SCREEN.repaint();
    }


    
    public static void ReloadIndicator(){
        if (Calculator._IS_SHIFT) {
            Calculator.IndicatorText.setText("Shift");
            Calculator.IndicatorText.setBounds(10, 0, 30, 14);
        }
        else if (Calculator._IS_ALPHA) {
            Calculator.IndicatorText.setText("Alpha");
            Calculator.IndicatorText.setBounds(40, 0, 30, 14);
        }
        else {Calculator.IndicatorText.setText(""); }
        
        Calculator.IndicatorText.repaint();
    }



    public static void ReloadArithmeticIndicator(){
        if (Calculator._OPERATOR == '+') {
            Calculator.SCREEN_ARITHMETIC_TEXT.setText("+");
            Calculator.SCREEN_ARITHMETIC_TEXT.setBounds(10, 0, 30, 14);
        }
        else if (Calculator._OPERATOR == '-') {
            Calculator.SCREEN_ARITHMETIC_TEXT.setText("-");
            Calculator.SCREEN_ARITHMETIC_TEXT.setBounds(10, 0, 30, 14);
        }
        else if (Calculator._OPERATOR == 'x') {
            Calculator.SCREEN_ARITHMETIC_TEXT.setText("x");
            Calculator.SCREEN_ARITHMETIC_TEXT.setBounds(10, 0, 30, 14);
        }
        else if (Calculator._OPERATOR == '/') {
            Calculator.SCREEN_ARITHMETIC_TEXT.setText("/");
            Calculator.SCREEN_ARITHMETIC_TEXT.setBounds(10, 0, 30, 14);
        }
        else { Calculator.SCREEN_ARITHMETIC_TEXT.setText(""); }
        
        
        Calculator.SCREEN_ARITHMETIC_TEXT.repaint();
    }

    public static double  Calculate(char operator){
        double answer = 0;

        if (operator == '+') {
            answer = Calculator.NUM_1 + Calculator.NUM_2;
        }
        else if (operator == '-') {
            answer = Calculator.NUM_1 - Calculator.NUM_2;
        }
        else if (operator == 'x') {
            answer = Calculator.NUM_1 * Calculator.NUM_2;
        }
        else if (operator == '/') {
            answer = Calculator.NUM_1 / Calculator.NUM_2;
        }

        return answer;
    }
}
