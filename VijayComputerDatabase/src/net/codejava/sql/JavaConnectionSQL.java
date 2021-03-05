package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JavaConnectionSQL {

		static String url = "jdbc:sqlserver://cot-cis3365-03;databaseName=VIJAYCOMPUTER;user=sa;password=Cougarnet2020!\"";
		static String user = "sa";
		static String password = "Cougarnet2020!";
		Connection connection;

		public JavaConnectionSQL()
		{
			
		}
		
		public JavaConnectionSQL(String user, String password)
		{
			this.user = user;
			this.password = password;
		}
		
		
		public static void connect()
		{
			try {
				//Connection connection = DriverManager.getConnection(url,user,password);
				Connection connection = DriverManager.getConnection("jdbc:sqlserver://COT-CIS3365-03\\VIJAYCOMPUTER","sa","Cougarnet2020!");
				System.out.println("IT DID Connect");
			} catch (SQLException e) {
				System.out.println("Didn't Connect");
				e.printStackTrace();
			}
		}
		
		public static void connect(String name, String pass)
		{
			try {
				Connection connection = DriverManager.getConnection(url,name,pass);
				System.out.println("IT DID Connect");
			} catch (SQLException e) {
				System.out.println("Didn't Connect");
				e.printStackTrace();
			}
		}

		public void addItem(String s) {
			// TODO Auto-generated method stub
			
		}
		
		public static void main(String[]args) 
		{
			JavaConnectionSQL sql2 = new JavaConnectionSQL();
			sql2.connect();
			
		}		
		

}


