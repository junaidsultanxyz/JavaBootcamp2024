import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Solution {
    public static JButton[][] Tiles;

    public static boolean CurrentTurn; // true -> player 1 | false -> player 2

    public static Color Player1Color = new Color(0, 0, 0);
    public static Color Player2Color = new Color(100, 100, 100);

    public static String Player1Symbol = "X";
    public static String Player2Symbol = "O";
    public static String Winner  = "-";

    public static boolean GameEnd = false;
    public static short TurnCount = 0;

    public static JPanel _MAIN_PANEL;
    public static void main(String[] args) throws Exception {
        final int _FWITDTH = 600;
        final int _FHEIGHT = 600;

        Tiles = new JButton[3][3];

        JFrame _FRAME = new JFrame("TicTacToe");
        _FRAME.setSize(_FWITDTH, _FHEIGHT);
        
        _FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _FRAME.setBackground(Color.black);

        _MAIN_PANEL = new JPanel(new GridLayout(3,3, 5, 5));
        _MAIN_PANEL.setBackground(Color.BLACK);



        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j++){
                Tiles[i][j] = new JButton("");
                SetupTile(Tiles[i][j]);
                _MAIN_PANEL.add(Tiles[i][j]);
            }
        }
        


        _FRAME.add(_MAIN_PANEL);
        _FRAME.setVisible(true);
    }

    public static void SetupTile(JButton button){
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Calibri", Font.BOLD, 50));

        button.addActionListener(e -> {
            if (!GameEnd){
                if ("".equals(button.getText())){
                    if (CurrentTurn){ // PLAYER 1
                        button.setForeground(Player1Color);
                        button.setText(Player1Symbol);
                        TurnCount++;
                    }
                    else{
                        button.setForeground(Player2Color);
                        button.setText(Player2Symbol);
                        TurnCount++;
                    }
                    
                    CurrentTurn = !CurrentTurn;

                }
                
                if (TurnCount == 9){
                    GameEnd = true;
                }
                Winner();
                
                if (GameEnd){
                    PlayAgain();
                }
                
            }
            
        });
    }



    public static void ResetBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Tiles[i][j].setText("");
                Tiles[i][j].setBackground(Color.white);
            }
        }
        TurnCount = 0;
        GameEnd = false;
        _MAIN_PANEL.repaint();
        

    }



    public static void PlayAgain(){
            int restart = JOptionPane.showConfirmDialog(null, "Play Again?");

            if (restart == 0){
                ResetBoard();
            }
            if (restart == 1){
                System.exit(restart);
        }
    }


    public static void Winner(){
    
        // horizontal
        for (int i = 0; i < 3; i++){
            if ("".equals(Tiles[i][0].getText())) continue;

            if (Tiles[i][0].getText().equals(Tiles[i][1].getText()) && Tiles[i][1].getText().equals(Tiles[i][2].getText())){
                for (int j = 0 ; j < 3; j++){
                    SetWinner(Tiles[i][j]);
                }
                GameEnd = true;
                return;
            }
    
        }

        // vertical
        for (int i = 0; i < 3; i++){
            if ("".equals(Tiles[0][i].getText())) continue;

            if (Tiles[0][i].getText().equals(Tiles[1][i].getText()) && Tiles[1][i].getText().equals(Tiles[2][i].getText()) ){
                for (int j = 0 ; j < 3; j++){
                    SetWinner(Tiles[j][i]);
                }
                GameEnd = true;
                return;
            }
        }

        if (Tiles[0][0].getText().equals(Tiles[1][1].getText()) && Tiles[1][1].getText().equals(Tiles[2][2].getText()) && !Tiles[0][0].getText().equals("") ){
            for (int i = 0 ; i< 3; i++){
                SetWinner(Tiles[i][i]);
            }
            GameEnd = true;
            return;
        }

        if (Tiles[0][2].getText().equals(Tiles[1][1].getText()) && Tiles[1][1].getText().equals(Tiles[2][0].getText()) && !Tiles[0][2].getText().equals("") ){
            for (int i = 0 ; i< 3; i++){
                SetWinner(Tiles[0][2]);
                SetWinner(Tiles[1][1]);
                SetWinner(Tiles[2][0]);
            }
            GameEnd = true;
        }

    }

    public static void SetWinner(JButton button){
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.GREEN);
    }
    
}
