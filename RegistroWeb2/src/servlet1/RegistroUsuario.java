package servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controllers.Conexion;

@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String DriverDB="org.postgresql.Driver";
	public String dbName = "Registro";
	public String URL = "jdbc:postgresql://localhost:5432/" +this.dbName;
	public String USER = "postgres";
	public String PASSWORD = "princho4";
	public static Connection con;
	public static Statement stm;
	public static PreparedStatement pstm;
	public static ResultSet rs;
	public String passwo;
    public RegistroUsuario() {
  
    	
    
        
        
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida=response.getWriter();
		 String pass = request.getParameter("clave");
		  String hashtext;
		try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(pass.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 hashtext = number.toString(16);

			 while (hashtext.length() < 32) {
			  hashtext = "0" + hashtext;
			 }
			 
			 }
			 catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e);
			 }
       passwo = hashtext;
		
		salida.println("<html><body style=background-color:#9555FF; ><div align ='center'>");
		salida.println("Nombre Introducido:");
		salida.println("<br><br>");
		salida.print(request.getParameter("nombre"));
		salida.println("<br><br>");
		salida.println("2do Nombre Introducido:" );
		salida.println("<br><br>");
		salida.print(request.getParameter("2nombre"));
		salida.println("<br><br>");
		salida.println("Apellido Introducido:" );
		salida.println("<br><br>");
		salida.print(request.getParameter("apellido"));
		salida.println("<br><br>");
		salida.println("2do Apellido Introducido:");
		salida.println("<br><br>");
		salida.print(request.getParameter("2apellido"));
		salida.println("<br><br>");
		salida.println("Edad:");
		salida.println("<br><br>");
		salida.print(request.getParameter("edad"));
		salida.println("<br><br>");
		salida.println("Clave  Encriptada:" );
		salida.println("<br><br>");
		salida.print(passwo);
		salida.println("<br><br>");
		
		salida.println("</div></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
