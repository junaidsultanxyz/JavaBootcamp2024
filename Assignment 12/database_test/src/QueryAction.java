import java.sql.*;

public class QueryAction {
    String url;
    String username;
    String password;


    public String addQuery (String productName, String productCatagory, float price){
        return "INSERT INTO product(name, catagory, price) VALUE (" + productName  + "," +  productCatagory+ "," + price + ")";
    }

    public String readQueryAll (){ return "SELECT * FROM product"; }
    public String readQueryByID (int id) { return "SELECT * FROM product WHERE id = " + id; }
    public String readQueryByCatag (String catag) { return "SELECT * FROM product WHERE catagory = '" + catag + "'" ;}
    public String readQueryByName (String name) { return "SELECT * FROM product WHERE name = '" + name + "'" ;}

    public void insertData(String name, String category, float price){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            String query = "INSERT INTO product(name, catagory, price) VALUES (?, ?, ?);";
            PreparedStatement  statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, category);
            statement.setFloat(3, price);

            int result = statement.executeUpdate();

            if (result > 0) { System.out.println("data inserted"); }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReadData (String query){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            Statement  statement = connection.createStatement();

            ResultSet result = statement.executeQuery(query);


            while (result.next()) {
                System.out.println("ID : " + result.getInt("id"));
                System.out.println("Name : " + result.getString("name"));
                System.out.println("Catagory : " + result.getString("catagory"));
                System.out.println("Price : " + result.getFloat("price"));

                System.out.println("-----------------");
            }

            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void UpdateData (int id, String new_name, String new_catag, float new_price){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "UPDATE product SET name = ?, catagory = ?, price = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, new_name);
            statement.setString(2, new_catag);
            statement.setFloat(3, new_price);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product updated successfully!");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DeleteItem (int id){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "DELETE FROM product WHERE id = ?";


            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("No product found with the given product_id.");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public QueryAction(){
        this.url = "jdbc:mysql://localhost:3306/assignment12";
        this.username = "junaid";
        this.password = "j_sultan115";
    }
}
