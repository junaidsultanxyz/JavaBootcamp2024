import javax.swing.JButton;

public class ButtonFunction{
    public static void ButtonConfigure(JButton button, String name){

        if (name.charAt(0) == '_'){

            switch (name){
                case "_SHIFT":
                {   
                    button.addActionListener( e -> {
                        if (Calculator._IS_SHIFT == true){
                            Calculator._IS_SHIFT = false;
                            Calculator._IS_ALPHA = false;
                        }
                        else
                        {
                            Calculator._IS_SHIFT = true;
                            Calculator._IS_ALPHA = false;
                        }
    
                        Functions.ReloadIndicator();
    
                    });
                }break;
    
                case "_ALPHA":
                {
                    button.addActionListener( e -> {
                        if (Calculator._IS_ALPHA == true){
                            Calculator._IS_SHIFT = false;
                            Calculator._IS_ALPHA = false;
                        }
                        else
                        {
                            Calculator._IS_SHIFT = false;
                            Calculator._IS_ALPHA = true;
                        }
    
                        Functions.ReloadIndicator();
    
                    });
                }break;
    
                case "_SINE":
                {
                    button.addActionListener( e -> {
                        if (Calculator._IS_SHIFT) {
                            Calculator._SCREEN_MESSAGE = "" + CalculateSineInverse(Calculator._SCREEN_MESSAGE);
                            Calculator._IS_SHIFT = false;
                        }
                        else { Calculator._SCREEN_MESSAGE = "" + CalculateSine(Calculator._SCREEN_MESSAGE); }
    
                        Functions.ReloadIndicator();
                        Functions.ReloadScreen();
                    });
                    
                }break;
    
                case "_COSINE":
                {
                    button.addActionListener( e -> {
                        if (Calculator._IS_SHIFT) {
                            Calculator._SCREEN_MESSAGE = "" + CalculateCosineInverse(Calculator._SCREEN_MESSAGE);
                            Calculator._IS_SHIFT = false;
                        }
                        else {  Calculator._SCREEN_MESSAGE = "" + CalculateCosine(Calculator._SCREEN_MESSAGE); }
    
                        Functions.ReloadIndicator();
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_TANGENT":
                {   
                    button.addActionListener( e -> {
                        if (Calculator._IS_SHIFT) {
                            Calculator._SCREEN_MESSAGE = "" + CalculateTangentInverse(Calculator._SCREEN_MESSAGE);
                            Calculator._IS_SHIFT = false;
                        }
                        else { Calculator._SCREEN_MESSAGE = "" + CalculateTangent(Calculator._SCREEN_MESSAGE); }
    
                        Functions.ReloadIndicator();
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_STANDARD_DEVIATION":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalcuateStandardDeviation(Calculator._SCREEN_MESSAGE);
    
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_MEAN":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalculateMean(Calculator._SCREEN_MESSAGE);
    
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_MEDIAN":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalculateMedian(Calculator._SCREEN_MESSAGE);
    
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_MODE":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalculateMode(Calculator._SCREEN_MESSAGE);
    
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_LOG":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalculateLog(Calculator._SCREEN_MESSAGE);

                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_SQUARE_ROOT":
                {
                    button.addActionListener( e -> {

                        Calculator._SCREEN_MESSAGE = "" + CalculateSquareRoot(Calculator._SCREEN_MESSAGE);
                        
                        Functions.ReloadScreen();
                    });
    
                }break;
    
                case "_EXPONENT":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE += "^";

                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_NATURAL_LOG":
                {
                    button.addActionListener( e -> {
                        Calculator._SCREEN_MESSAGE = "" + CalculateLogNatural(Calculator._SCREEN_MESSAGE);
                        
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_DELETE":
                {
                    button.addActionListener( e -> {
                        if (! (Calculator._SCREEN_MESSAGE.length() == 0))
                            Calculator._SCREEN_MESSAGE = Calculator._SCREEN_MESSAGE.substring(0, Calculator._SCREEN_MESSAGE.length() - 1);
                        
                        Functions.ReloadScreen();
                    });
                }break;
    
                case "_CLEAR_SCREEN":
                {
                    button.addActionListener( e -> {
                        Calculator._IS_ALPHA = false;
                        Calculator._IS_SHIFT = false;
                        Calculator._SCREEN_MESSAGE = "";
                        Calculator._OPERATOR = '0';

                        Functions.ReloadArithmeticIndicator();
                        Functions.ReloadIndicator();
                        Functions.ReloadScreen();
                    });
                }break;
    
    
            }
        }


    }

    public static void ConfigureNumberButtons(JButton button){
        button.addActionListener(e -> {
            Calculator._SCREEN_MESSAGE += button.getText();
            Functions.ReloadScreen();
        });
    }

    public static void ConfigureAnswerButtons(JButton button, String code){
            button.addActionListener( e -> {

                switch(code){
                    case "&ANSWER":
                    {   
                        Calculator._SCREEN_MESSAGE += Calculator._LAST_ANS;
                    }break;
    
                    case "&EQUALS":
                    {   
                        if (CheckPower(Calculator._SCREEN_MESSAGE)){
                            Calculator.NUM_2 = CalculatePower(Calculator._SCREEN_MESSAGE);
                        }
                        else { Calculator.NUM_2 = Double.parseDouble(Calculator._SCREEN_MESSAGE); }

                        if (CheckPower(Calculator._SCREEN_MESSAGE) && Calculator.NUM_1 == 0){
                            Calculator._OPERATOR = '+';
                        }
                        
                        Calculator._LAST_ANS = Functions.Calculate(Calculator._OPERATOR);

                        if (Calculator._LAST_ANS % 1 == 0){

                            Calculator._SCREEN_MESSAGE = "" + (int) Calculator._LAST_ANS;
                        }
                        else { Calculator._SCREEN_MESSAGE = "" + Calculator._LAST_ANS; }

                        Calculator._OPERATOR = '0';

                    }break;
                }


                Functions.ReloadScreen();
                Functions.ReloadArithmeticIndicator();
            });
    }

    public static void ConfigureArithmeticNumbers(JButton button, String code){
        button.addActionListener( e -> {

            switch(code){
                case "$ADD":
                {
                    Calculator._OPERATOR = '+';

                    if (CheckPower(Calculator._SCREEN_MESSAGE)){
                        Calculator.NUM_1 = CalculatePower(Calculator._SCREEN_MESSAGE);
                    }
                    else { Calculator.NUM_1 = Double.parseDouble(Calculator._SCREEN_MESSAGE); }

                    Calculator._SCREEN_MESSAGE = "";

                }break;

                case "$SUBTRACT":
                {   
                    Calculator._OPERATOR = '-';

                    if (CheckPower(Calculator._SCREEN_MESSAGE)){
                        Calculator.NUM_1 = CalculatePower(Calculator._SCREEN_MESSAGE);
                    }
                    else { Calculator.NUM_1 = Double.parseDouble(Calculator._SCREEN_MESSAGE); }

                    Calculator._SCREEN_MESSAGE = "";

                }break;

                case "$MULTIPLY":
                {   
                    Calculator._OPERATOR = 'x';
                    
                    if (CheckPower(Calculator._SCREEN_MESSAGE)){
                        Calculator.NUM_1 = CalculatePower(Calculator._SCREEN_MESSAGE);
                    }
                    else { Calculator.NUM_1 = Double.parseDouble(Calculator._SCREEN_MESSAGE); }

                    Calculator._SCREEN_MESSAGE = "";

                }break;

                case "$DIVIDE":
                {   
                    Calculator._OPERATOR = '/';
                    
                    if (CheckPower(Calculator._SCREEN_MESSAGE)){
                        Calculator.NUM_1 = CalculatePower(Calculator._SCREEN_MESSAGE);
                    }
                    else { Calculator.NUM_1 = Double.parseDouble(Calculator._SCREEN_MESSAGE); }

                    Calculator._SCREEN_MESSAGE = "";

                }break;
            }

            Functions.ReloadScreen();
            Functions.ReloadArithmeticIndicator();
        });
    }

    public static double CalculateMean(String input){
        double answer = 0;

        String[] temp = input.split(",");
        double[] data = new double[temp.length];



        for (int i = 0; i < temp.length; i++){
            data[i] = Double.parseDouble(temp[i]);
            answer += data[i];
        }

        return answer/data.length;
    }

    public static double CalculateMode(String input){

        String[] temp = input.split(",");
        double[] data = new double[temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = Double.parseDouble(temp[i]);
        }


        double maxValue = 0, maxCount = 0;
        
        for (int i = 0; i < data.length; ++i) {
            int count = 0;
            for (int j = 0; j < data.length; ++j) {
                if (data[j] == data[i])
                ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = data[i];
            }
        }
        return maxValue;

    }

    public static double CalculateMedian(String input){
        double answer = 0;

        String[] temp = input.split(",");
        double[] data = new double[temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = Double.parseDouble(temp[i]);
        }

        if (data.length % 2 == 0){
            int midPoint = data.length/2;
            answer = (data[midPoint] + data[midPoint + 1])/2;
        }
        else { answer = data[data.length/2]; }

        return answer;
    }

    public static double CalcuateStandardDeviation(String input){
        String[] temp = input.split(",");
        double[] data = new double[temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = Double.parseDouble(temp[i]);
        }

        
        double sum = 0.0;
        for (double i : data) {
            sum += i;
        }

        int length = data.length;
        double mean = sum / length;

        double standardDeviation = 0.0;
        for (double num : data) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / length);
    }

    public static double CalculateLog(String input){
        double num = Double.parseDouble(input);

        return Math.log10(num);
    }

    public static double CalculateLogNatural(String input){
        double num = Double.parseDouble(input);

        return Math.log(num);
    }

    public static double CalculateSquareRoot(String input){
        double num = Double.parseDouble(input);

        return Math.sqrt(num);
    }

    public static double CalculateSine(String input){
        double num = Double.parseDouble(input);

        return Math.sin(num);
    }

    public static double CalculateSineInverse(String input){
        double num = Double.parseDouble(input);

        return Math.asin(num);
    }

    public static double CalculateCosine(String input){
        double num = Double.parseDouble(input);

        return Math.cos(num);
    }

    public static double CalculateCosineInverse(String input){
        double num = Double.parseDouble(input);

        return Math.acos(num);
    }

    public static double CalculateTangent(String input){
        double num = Double.parseDouble(input);

        return Math.tan(num);
    }

    public static double CalculateTangentInverse(String input){
        double num = Double.parseDouble(input);

        return Math.atan(num);
    }

    public static boolean CheckPower(String input){
        if (input.indexOf('^') != -1){
            return true;
        }
        else { return false; }
    }

    public static double CalculatePower(String input){
        int index = input.indexOf('^');
        double num1 = Double.parseDouble(input.substring(0, index));
        double num2 = Double.parseDouble(input.substring(index + 1, input.length()));

        return Math.pow(num1, num2);
    }
}