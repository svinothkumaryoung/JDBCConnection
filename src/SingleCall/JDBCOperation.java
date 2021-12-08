package SingleCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCOperation {
    String name;
    String Emailid;
    int RegisterNo;
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    InputStreamReader inputStreamReader=new InputStreamReader(System.in);
    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
    void insertData() throws IOException, SQLException
    {
        System.out.println("Enter the Register number ");
        RegisterNo=Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter the Name");
        name=bufferedReader.readLine();
        System.out.println("Enter the Emaill id");
        Emailid=bufferedReader.readLine();
        connection=ConnectionClass.getConnection(ConfigrationFile.URLACCESS,ConfigrationFile.USERNAME,ConfigrationFile.PASSWORD);
        preparedStatement=connection.prepareStatement("insert into registerNo (registerNo,name,emailid) values (?,?,?)");
        preparedStatement.setInt(1,RegisterNo);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3, Emailid);
        int Execut=preparedStatement.executeUpdate();
        if(Execut>0)
        {
            System.out.println("Successfully Inserted ");
        }
        else
        {
            System.out.println("Error In Insertion");
        }

    }

    public static void main(String[] args) throws IOException, SQLException {
        JDBCOperation jo=new JDBCOperation();
        jo.insertData();
    }
}
