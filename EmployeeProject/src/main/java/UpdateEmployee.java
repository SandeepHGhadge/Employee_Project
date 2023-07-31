import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateEmployee {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();		
		System.out.println("Enter Employee Salary");
		double salary=sc1.nextDouble();
		
		Connection con=null;
		Statement stmt=null;
		
		String query="update employee set empSal="+salary+" where id="+id+"";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sandeep@9359");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			if (count!=0) {
				System.out.println(count+" Employee Updated");
			}else {
				System.out.println("Employee Not Found");
			}
			
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
