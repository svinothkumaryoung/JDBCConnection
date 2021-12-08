import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.sql.*;
import java.util.List;

public class JDBCOperation {
     String name;
     String Address;
     String Gender;
     String Fathername;
     String Mothername;
    Connection connection;
     int age;
     EmployeeDetails ed=new EmployeeDetails();
     InputStreamReader inputStreamReader=new InputStreamReader(System.in);
     BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
     void getData()
     {
         try{
             System.out.println("Enter the Name");
             ed.setName(bufferedReader.readLine());
             System.out.println("Enter the Address");
             ed.setAddress(bufferedReader.readLine());
             System.out.println("Enter the Gender");
             ed.setGender(bufferedReader.readLine());
             System.out.println("Enter the Father name");
             ed.setFathername(bufferedReader.readLine());
             System.out.println("Enter the Mother name");
             ed.setMothername(bufferedReader.readLine());
             System.out.println("Enter the Age");
             ed.setAge(Integer.parseInt(bufferedReader.readLine()));
         }
         catch (IOException ioException)
         {
             System.out.println("IOException Occur");
         }
     }

     void insertValueIntoDatabase()
     {
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData","root","12345678");
             PreparedStatement ps=connection.prepareStatement("insert into employeeRegisteration" +
                     "(name,age,fathername,mothername,Address,Gender) " +
                     "values(?,?,?,?,?,?)");
             ps.setString(1,ed.getName());
             ps.setInt(2,ed.getAge());
             ps.setString(3,ed.getFathername());
             ps.setString(4,ed.getMothername());
             ps.setString(5,ed.getAddress());
             ps.setString(6,ed.getGender());
             int QueryResult=ps.executeUpdate();
             if(QueryResult>0)
             {
                 System.out.println("Insertion Operation Done");

             }
             else
             {
                 System.out.println("Error In Insert the Value");
             }

         }
         catch(ClassNotFoundException ce)
         {
             System.out.println("Class Not Found");
         }
         catch(SQLException sqlException)
         {
             System.out.println("Error in SQL");
         }
         }


         List<String> getDetails()
         {
             try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData","root","12345678");
                 PreparedStatement preparedStatement=connection.prepareStatement("select * from employeeRegisteration");
                 ResultSet resultSet=preparedStatement.executeQuery();
                 List<>
                 while (resultSet.next())
                 {
                     System.out.println("************** Starting Reterival **************");
                     System.out.println("RegisterNo "+resultSet.getString(1));
                     System.out.println("Name "+resultSet.getString(2));
                     System.out.println("Age  "+resultSet.getInt(3));
                     System.out.println("Father Name "+resultSet.getString(4));
                     System.out.println("Mother Name "+resultSet.getString(5));
                     System.out.println("Gender "+resultSet.getString(6));
                     System.out.println("Address "+resultSet.getString(7));
                     System.out.println("****Reterival Operation Finished one Record*******");
                 }
             }
             catch(ClassNotFoundException cnfe) {
                 System.out.println("Class Not Found");
             }
             catch(SQLException sqlException)
             {
                 System.out.println("SQL Exception");
         }
             finally {
                 try
                 {
                     connection.close();
                 }
                 catch(SQLException s)
                 {
                     System.out.println("Error in Closing Connection");
                 }

             }

         }
         void deleteData() throws IOException,ClassNotFoundException,SQLException
         {
             int registerNo;
             System.out.println("Enter the Register Number U Wan to Delete ");
             registerNo= Integer.parseInt(bufferedReader.readLine());


             Class.forName("com.mysql.cj.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData","root","12345678");
             PreparedStatement preparedStatement=connection.prepareStatement("delete from employeeRegisteration where registerNo=?");
             preparedStatement.setInt(1,registerNo);
             int resultOfDeletion=preparedStatement.executeUpdate();
             if(resultOfDeletion>0)
             {
                 System.out.println("Successfully Deleted");
             }
             else
             {
                 System.out.println("Error In Deleted");
             }

         }
         void UserChoice() throws IOException,ClassNotFoundException,SQLException
         {
             System.out.println("***** Welcome to JDBC Operation *****");
             System.out.println("Enter your Choice to Perform the Operation");
             System.out.println(" 1.Insert \n 2.Deletion \n 3.Update \n 4.Reterival");
             int choice=Integer.parseInt(bufferedReader.readLine());
             switch (choice)
             {
                 case 1:
                     this.getData();
                     this.insertValueIntoDatabase();
                     this.UserChoice();
                     break;
                 case 2:
                     this.deleteData();
                     this.UserChoice();
                     break;
                 case 3:
                     System.out.println(" *** Coming Soon ***");
                     break;
                 case 4:
                     this.getDetails();
                     this.UserChoice();
                     break;
                 default:
                     System.out.println(" Give Correct Choice ß");
             }

         }


     public static void main(String[] args) throws IOException,ClassNotFoundException,SQLException{
          JDBCOperation jdbc1=new JDBCOperation();
          jdbc1.UserChoice();

     }



}
