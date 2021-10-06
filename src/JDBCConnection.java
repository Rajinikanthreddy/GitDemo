import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCConnection {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/raj", "root", "root");
		Statement s=con.createStatement();
		String query="select * from dbTest";
		ResultSet rs=s.executeQuery(query);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver wb=new ChromeDriver();
		wb.get("https://login.salesforce.com/?locale=in");
		while(rs.next()) {
		wb.findElement(By.id("username")).sendKeys(rs.getString(1));
		wb.findElement(By.id("password")).sendKeys(rs.getString(2));
		wb.findElement(By.xpath("//input[@id='Login']")).click();
		System.out.println(rs.getInt(4));

	}
	}
}
