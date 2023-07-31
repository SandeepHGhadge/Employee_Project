import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayEmployee {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select * from employee";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Sandeep@9359");
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("ID\t\tEMPLOYEE NAME\t\tEMPLOYEE SALARY\t\tEMPLOYEE DESIGNATION");
			System.out.println("============================================================================================");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double salary=rs.getDouble(3);
				String deg=rs.getString(4);
				
				System.out.println(id+"\t\t\t"+name+"\t\t\t"+salary+"\t\t\t"+deg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
