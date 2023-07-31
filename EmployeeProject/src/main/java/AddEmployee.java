import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddEmployee {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Employee Id");
		int id=sc1.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc1.next();
		System.out.println("Enter Employee Salary");
		double salary=sc1.nextDouble();
		System.out.println("Enter Employee Designation");
		String deg=sc1.next();
		
		Connection con=null;
		Statement stmt=null;
		
		String query="insert into employee values("+id+",'"+name+"',"+salary+",'"+deg+"')";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sandeep@9359");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println(count+" Employee Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
