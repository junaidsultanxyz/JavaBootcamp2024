import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // CREATE, READ, UPDATE, DELETE

        Scanner input = new Scanner(System.in);

        while (true){

            System.out.print(MainMenu());
            int choice = input.nextInt();

            System.out.println("--------------------------------------------");


            QueryAction query = new QueryAction();
            switch (choice) {

                case 1:     // CREATING
                {
                    input.nextLine();
                    System.out.println("Enter Product Details :");

                    System.out.print("Name : ");
                    String name = input.nextLine();
                    System.out.print("Category : ");
                    String category = input.nextLine();
                    System.out.print("Price : ");
                    float price = input.nextFloat();

                    query.insertData(name, category, price);

                    System.out.println("Product added successfully !");

                }
                break;

                case 2:     // READING
                {

                    System.out.print(ReadProductMenu());
                    int readChoice = input.nextInt();

                    switch (readChoice)
                    {
                        case 1: // all
                        {
                            query.ReadData(query.readQueryAll());

                        }break;

                        case 2: // id
                        {
                            System.out.print("Enter Product ID : ");
                            int id = input.nextInt();

                            query.ReadData(query.readQueryByID(id));

                        }break;

                        case 3: // catagory
                        {
                            input.nextLine();

                            System.out.print("Enter Product Category : ");
                            String category = input.nextLine();

                            query.ReadData(query.readQueryByCatag(category));

                        }break;

                        case 4: // name
                        {
                            input.nextLine();

                            System.out.print("Enter Product Name : ");
                            String name = input.nextLine();

                            query.ReadData(query.readQueryByName(name));
                        }break;

                        default:
                        {
                            System.out.println("invalid input");
                        }break;
                    }

                }
                break;

                case 3:     // UPDATING
                {
                    input.nextLine();

                    System.out.print("Enter Product ID : ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter new Name : ");
                    String name = input.nextLine();
                    System.out.print("Enter new Category : ");
                    String catag = input.nextLine();
                    System.out.print("Enter new Price : ");
                    float price = input.nextFloat();

                    query.UpdateData(id, name, catag, price);
                }
                break;

                case 4:     // DELETING
                {
                    System.out.print("Enter id : ");
                    int id = input.nextInt();

                    query.DeleteItem(id);
                }
                break;

                default:    // ERRORRRRRRRRRRRRRRRR
                {
                    System.out.println("invalid input");
                }
                break;
            }

            System.out.println("--------------------------------------------");

            System.out.print("1. Continue , 2. Exit : ");
            int reInput = input.nextInt();

            if (reInput == 1) {
                continue;
            }
            if (reInput == 2) {
                break;
            } else {
                System.out.println("Exiting program");
            }
        }
    }

    public static String MainMenu(){
        return "1. Create Product" + "\n" +
        "2. Read Product" + "\n" +
        "3. Update Product" + "\n" +
        "4. Delete Product" + "\n" +
        "Enter here : ";
    }

    public static String ReadProductMenu(){
        return "1. Read All Products" + "\n" +
                "2. Read Product By ID" + "\n" +
                "3. Read Products By Category" + "\n" +
                "4. Read Products By Name" + "\n" +
                "Enter here : ";
    }
}