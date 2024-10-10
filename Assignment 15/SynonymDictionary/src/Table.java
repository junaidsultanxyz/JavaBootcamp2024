import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Table {
    private JScrollPane scroll;
    private JTable table;


    public void addRow(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.insertRow(0, new Object[]{});
    }

    public Object[] getRowData(){
        Object[] data = new Object[table.getColumnCount()];

        for (int i = 0; i < data.length; i++){
            data[i] = table.getValueAt(table.getSelectedRow(), i);
        }

        return data;
    }

    public void removeRow(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
    }

    public void setGridSize(int size){
        table.setRowHeight(size);
    }

    public void setBounds(int x, int y, int width, int height){
        scroll.setBounds(x, y, width, height);
    }

    public void setColumnWidth(int column, int width){
        table.getColumnModel().getColumn(column).setPreferredWidth(width);
    }

    public void setSelectedRowColor(Color background, Color foreground){
        table.setSelectionBackground(background);
        table.setSelectionForeground(foreground);
    }

    public JTable getTable(){
        return table;
    }

    public Component getComponent(){
        return scroll;
    }

    public Table(String[] columns){
        DefaultTableModel model = new DefaultTableModel(null, columns);
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        scroll = new JScrollPane(table);
    }
}
