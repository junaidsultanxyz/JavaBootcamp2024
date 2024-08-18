
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

public class Calculator {
    public static boolean _IS_SHIFT = false,
            _IS_ALPHA = false;

    public static double _LAST_ANS;
    public static char _OPERATOR;
    public static double NUM_1 = 0, NUM_2 = 0, ANSWER;

    public static String _SCREEN_MESSAGE = "";

    public static int _BUTTON_FONT_SIZE = 25;

    public static JTextField SCREEN;
    public static JLabel IndicatorText;
    public static JLabel SCREEN_ARITHMETIC_TEXT;
    public static JPanel SCREEN_ARITHMETIC;


    public static ArrayList<ButtonSetup> AnswerButtonList;
    public static ArrayList<ButtonSetup> ArithmeticButtonList;
    public static ArrayList<ButtonSetup> NumberButtonList;
    public static ArrayList<ButtonSetup> ScientificButtonsList;




    public static void main(String[] args) throws Exception {
        /*--------------------------------------------------------------------------------FRAME MEASUREMENTS */
        
        final int _FRAME_WIDTH = 600;
        final int _FRAME_HEIGHT = 800;

        /*--------------------------------------------------------------------------------MAIN JFRAME */
        JFrame MAIN_FRAME = new JFrame("Scientific Calculator");
        MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MAIN_FRAME.setSize(_FRAME_WIDTH, _FRAME_HEIGHT);
        MAIN_FRAME.setBackground(Color.white);
        MAIN_FRAME.setLayout(null);
        MAIN_FRAME.setResizable(false);

        JPanel MAIN_PANEL = new JPanel();
        MAIN_PANEL.setBounds(0, 0, _FRAME_WIDTH, _FRAME_HEIGHT);
        MAIN_PANEL.setBackground(Color.white);
        MAIN_PANEL.setLayout(null);
        MAIN_FRAME.add(MAIN_PANEL);

        /*--------------------------------------------------------------------------------INDICATOR BAR */
        JPanel INDICATOR = new JPanel();
        INDICATOR.setBounds(0, 0, _FRAME_WIDTH, 14);
        INDICATOR.setLayout(null);
        INDICATOR.setBackground(Color.white);
        INDICATOR.setVisible(true);

        IndicatorText = new JLabel();
        IndicatorText.setForeground(Color.BLUE);
        IndicatorText.setFont(new Font("Calibri", Font.BOLD, 12));
        INDICATOR.add(IndicatorText);

        /*--------------------------------------------------------------------------------DISPLAY SCREEN */
        String _SCREEN_FONT = "Calibri";
        int _SCREEN_FONT_SIZE = 40;
        
        SCREEN = new JTextField();
        SCREEN.setBounds(10, 25, _FRAME_WIDTH - 35, 60);
        SCREEN.setText(" ");
        SCREEN.setEditable(false);
        SCREEN.setCaretColor(Color.BLACK);
        SCREEN.setBorder(BorderFactory.createEmptyBorder());
        SCREEN.setBackground(Color.white);
        SCREEN.setForeground(Color.black);
        SCREEN.setFont(new Font(_SCREEN_FONT, Font.BOLD, _SCREEN_FONT_SIZE));
        SCREEN.setVisible(true);

        SCREEN_ARITHMETIC = new JPanel();
        SCREEN_ARITHMETIC.setBounds(10, 85, _FRAME_WIDTH - 35, 30);
        SCREEN_ARITHMETIC.setLayout(null);
        SCREEN_ARITHMETIC.setBackground(Color.white);

        SCREEN_ARITHMETIC_TEXT = new JLabel();
        SCREEN_ARITHMETIC_TEXT.setForeground(Color.BLUE);
        SCREEN_ARITHMETIC_TEXT.setFont(new Font("Calibri", Font.BOLD, 15));
        SCREEN_ARITHMETIC.add(SCREEN_ARITHMETIC_TEXT);
        
        /*--------------------------------------------------------------------------------SCIENTIFIC BUTTONS PANEL */
        
        JPanel SCIENTIFIC_BUTTONS = new JPanel();
        SCIENTIFIC_BUTTONS.setBounds(10, 141, _FRAME_WIDTH - 35, 408 - 180);
        SCIENTIFIC_BUTTONS.setLayout(new GridLayout(3, 5, 10, 10));
        SCIENTIFIC_BUTTONS.setBackground(Color.white);
        SCIENTIFIC_BUTTONS.setVisible(true);
        
        /*------------------------------------------------------------------------BUTTONS */
        ScientificButtonsList = new ArrayList<>();

        ScientificButtonsList.add(new ButtonSetup(new JButton("shift"), "_SHIFT"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("alpha"), "_ALPHA"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("sin"), "_SINE"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("cos"), "_COSINE"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("tan"), "_TANGENT"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("S.D"), "_STANDARD_DEVIATION"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("mean"), "_MEAN"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("med."), "_MEDIAN"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("mode"), "_MODE"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("log"), "_LOG"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("\u221A"), "_SQUARE_ROOT"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("x^"), "_EXPONENT"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("ln"), "_NATURAL_LOG"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("DEL"), "_DELETE"));
        ScientificButtonsList.add(new ButtonSetup(new JButton("AC"), "_CLEAR_SCREEN"));
        
        for (ButtonSetup button: ScientificButtonsList){
            ButtonFunction.ButtonConfigure(button.button, button.code);
            button.button.setFont(new Font("Calibri", Font.BOLD, 21));
            SCIENTIFIC_BUTTONS.add(button.button);
        }

        /*--------------------------------------------------------------------------------NUMBER BUTTONS PANEL */
        JPanel NUMBER_BUTTONS = new JPanel();
        NUMBER_BUTTONS.setBounds(10, 410 - 20, 351 - 15, 350);
        NUMBER_BUTTONS.setLayout(new GridLayout(4, 3, 10, 10));
        NUMBER_BUTTONS.setBackground(Color.white);
        NUMBER_BUTTONS.setVisible(true);
        
        
        /*------------------------------------------------------------------------BUTTONS */
        NumberButtonList = new ArrayList<>();
        
        NumberButtonList.add(new ButtonSetup(new JButton("7"), "0SEVEN"));
        NumberButtonList.add(new ButtonSetup(new JButton("8"), "0EIGHT"));
        NumberButtonList.add(new ButtonSetup(new JButton("9"), "0NINE"));
        NumberButtonList.add(new ButtonSetup(new JButton("4"), "0FOUR"));
        NumberButtonList.add(new ButtonSetup(new JButton("5"), "0FIVE"));
        NumberButtonList.add(new ButtonSetup(new JButton("6"), "0SIX"));
        NumberButtonList.add(new ButtonSetup(new JButton("1"), "0ONE"));
        NumberButtonList.add(new ButtonSetup(new JButton("2"), "0TWO"));
        NumberButtonList.add(new ButtonSetup(new JButton("3"), "0THREE"));
        NumberButtonList.add(new ButtonSetup(new JButton("0"), "0ZERP"));
        NumberButtonList.add(new ButtonSetup(new JButton(","), "0COMA"));
        NumberButtonList.add(new ButtonSetup(new JButton("."), "0DECIMAL"));
        
        for (ButtonSetup button: NumberButtonList){
            ButtonFunction.ConfigureNumberButtons(button.button);
            button.button.setFont(new Font("Calibri", Font.BOLD, _BUTTON_FONT_SIZE));
            NUMBER_BUTTONS.add(button.button);
        }
        
        /*--------------------------------------------------------------------------------ARITHMETIC PANEL */
        JPanel ARITHMETIC_BUTTONS = new JPanel();
        ARITHMETIC_BUTTONS.setBounds(356, 410 - 20, 218, 168);
        ARITHMETIC_BUTTONS.setLayout(new GridLayout(2, 2, 10, 10));
        ARITHMETIC_BUTTONS.setBackground(Color.WHITE);
        ARITHMETIC_BUTTONS.setVisible(true);
        

        /*------------------------------------------------------------------------BUTTONS */
        ArithmeticButtonList = new ArrayList<>();
        
        ArithmeticButtonList.add(new ButtonSetup(new JButton("x"), "$MULTIPLY"));
        ArithmeticButtonList.add(new ButtonSetup(new JButton("/"), "$DIVIDE"));
        ArithmeticButtonList.add(new ButtonSetup(new JButton("+"), "$ADD"));
        ArithmeticButtonList.add(new ButtonSetup(new JButton("-"), "$SUBTRACT"));

        for (ButtonSetup button: ArithmeticButtonList){
            ButtonFunction.ConfigureArithmeticNumbers(button.button, button.code);
            button.button.setFont(new Font("Calibri", Font.BOLD, _BUTTON_FONT_SIZE));
            ARITHMETIC_BUTTONS.add(button.button);
        }
        
        /*--------------------------------------------------------------------------------ANSWER BUTTON PANEL */
        JPanel ANSWER_BUTTONS = new JPanel();
        ANSWER_BUTTONS.setBounds(356, 408 + 170 + 10 - 20, 218, 170);
        ANSWER_BUTTONS.setLayout(new GridLayout(2, 1, 10, 10));
        ANSWER_BUTTONS.setBackground(Color.white);
        ANSWER_BUTTONS.setVisible(true);
        
        
        /*------------------------------------------------------------------------BUTTONS */
        AnswerButtonList = new ArrayList<>();

        AnswerButtonList.add(new ButtonSetup(new JButton("ANS"), "&ANSWER"));
        AnswerButtonList.add(new ButtonSetup(new JButton("="), "&EQUALS"));

        for (ButtonSetup button: AnswerButtonList){
            ButtonFunction.ConfigureAnswerButtons(button.button, button.code);
            button.button.setFont(new Font("Calibri", Font.BOLD, 21));
            ANSWER_BUTTONS.add(button.button);
        }
        
        /*--------------------------------------------------------------------------------ADDING COMPONENTS */
        MAIN_PANEL.add(INDICATOR);
        MAIN_PANEL.add(SCREEN);
        MAIN_PANEL.add(SCIENTIFIC_BUTTONS);
        MAIN_PANEL.add(NUMBER_BUTTONS);
        MAIN_PANEL.add(ARITHMETIC_BUTTONS);
        MAIN_PANEL.add(ANSWER_BUTTONS);
        MAIN_PANEL.add(SCREEN_ARITHMETIC);
        
        /*--------------------------------------------------------------------------------*/
        MAIN_FRAME.setVisible(true);
    }


}
