import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Application {
    public static final Color ONE = new Color(246, 197, 230);
    public static final Color TWO = new Color(205, 226, 237);
    public static final Color THREE = new Color(247, 245, 235);
    public static final Color FOUR = new Color(234, 199, 199);
    public static final Color FIVE = new Color(88, 106, 124);


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        JFrame frame = new JFrame("Dictionary");
        frame.setSize(650, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //------------------------------------------------------------------

        JPanel panel = new JPanel();
        panel.setBounds(0,0,1000,700);
        panel.setLayout(null);
        panel.setBackground(THREE);

        //------------------------------------------------------------------ table

        Table table = new Table(new String[]{"Word", "Synonyms"});
        table.setBounds(20, 70, 600, 500);
        table.setSelectedRowColor(THREE, Color.BLACK);
        table.setGridSize(28);
        table.setColumnWidth(0, 250);
        table.setColumnWidth(1, 330);
        panel.add(table.getComponent());

        //------------------------------------------------------------------

        JTextField search = new JTextField("search");
        search.setBackground(TWO);
        search.setForeground(FIVE);
        search.setBounds(20,20, 600, 40);
        search.setFont(new Font("Arial", Font.BOLD, 12));
        search.setHorizontalAlignment(JTextField.HORIZONTAL);

        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equalsIgnoreCase("search")){
                    search.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().isBlank()){
                    search.setText("search");
                }
            }
        });

        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    populateTable(table.getTable(), dictionary.searchWord(search.getText()));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        panel.add(search);


        //------------------------------------------------------------------ add button

        JButton addButton = new JButton("Add");
        addButton.setBounds(20, 580, 196, 60);
        addButton.setFocusable(false);
        addButton.setBackground(FOUR);
        addButton.addActionListener(e -> {
            table.addRow();
        });

        //------------------------------------------------------------------ update button

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(221, 580, 196, 60);
        updateButton.setFocusable(false);
        updateButton.setBackground(FOUR);

        updateButton.addActionListener(e -> {
            Object[] data = table.getRowData();
            dictionary.newWord("" + data[0], "" + data[1]);
        });


        //------------------------------------------------------------------ remove button

        JButton removeButton = new JButton("Delete");
        removeButton.setBounds(422, 580, 196, 60);
        removeButton.setFocusable(false);
        removeButton.setBackground(FOUR);

        removeButton.addActionListener(e -> {
            Object[] data = table.getRowData();
            boolean confirm = dictionary.deleteWord("" + data[0]);
            if (confirm){
                table.removeRow();
            }
        });

        //------------------------------------------------------------------ window open and close actions
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                dictionary.setDictionaryList(dictionary.LoadDataFromFile("data.txt"));
                populateTable(table.getTable(), dictionary.getDictionaryList());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                dictionary.SaveDataToFile(dictionary.getDictionaryList(), "data.txt");
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        frame.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                JOptionPane.showMessageDialog(null, "Loading...");
                populateTable(table.getTable(), dictionary.LoadDataFromFile("data.txt"));

            }

            @Override
            public void windowClosing(WindowEvent e){
                super.windowClosing(e);
                JOptionPane.showMessageDialog(null, "Saving...");
                dictionary.SaveDataToFile(dictionary.getDictionaryList(), "data.txt");
            }
        });


        //------------------------------------------------------------------
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(removeButton);


        frame.add(panel);
        frame.setVisible(true);
    }

    public static void populateTable(JTable table, HashMap<String, String> data){
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = table.getRowCount() - 1; i >= 0; i--){
            model.removeRow(i);
        }

        for (String s : data.keySet()){
            model.addRow(new Object[] {s, data.get(s)});
        }
    }

}
