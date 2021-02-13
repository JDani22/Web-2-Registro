package controllers;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {

	public String dbName = "Registro";
	public String URL = "jdbc:postgresql://localhost:5432/Registro";
	public String USER = "postgres";
	public String PASSWORD = "princho4";


   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("org.postgresql.Driver");

           link = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
           JOptionPane.showMessageDialog(null,"Conectada");
       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, ex);

       }


       return link;

   }
                                               

}
