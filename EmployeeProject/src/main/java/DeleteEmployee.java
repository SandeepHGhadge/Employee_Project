import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployee {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Product Id");
		int id=sc1.nextInt();		
		
		Connection con=null;
		Statement stmt=null;
		
		String query="delete from employee where id="+id+"";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sandeep@9359");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			if (count!=0) {
				System.out.println(count+" Employee Deleted");
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
