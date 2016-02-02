import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ScoutingServerAccessor {
	private String serverUsername;
	private String serverPassword;
	private String serverIP;
	private String databaseName;
	
	
	public ScoutingServerAccessor() {
		serverUsername = "root";
		serverPassword = "root";
		serverIP = "localhost";
		databaseName = "samplescoutingserverschema";
	}
	
	public ScoutingServerAccessor(String serverUsername, String serverPassword, String serverIP, String databaseName) {
		this.serverUsername = serverUsername;
		this.serverPassword = serverPassword;
		this.serverIP = serverIP;
		this.databaseName = databaseName;
	}
	
	public ResultSet executeQuery(String cmd) throws SQLException {
		MysqlDataSource dataSource = connect();
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch(CommunicationsException e) {
			System.err.println("CommunicationsException! The server is likely not running, or we cannot connect to it!\nMore information below!\n\n");
			e.printStackTrace();
			System.exit(0);
		}
		Statement stmt = conn.createStatement();
		stmt.executeQuery("USE " + databaseName);
		ResultSet rs2 = stmt.executeQuery(cmd);
		
		return rs2;
	}
	
	public boolean execute(String cmd) throws SQLException {
		MysqlDataSource dataSource = connect();
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch(CommunicationsException e) {
			System.err.println("CommunicationsException! The server is likely not running, or we cannot connect to it!\nMore information below!\n\n");
			e.printStackTrace();
			System.exit(0);
		}
		Statement stmt = conn.createStatement();
		stmt.executeQuery("USE " + databaseName);
		return stmt.execute(cmd);
	}
	
	private MysqlDataSource connect() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(serverUsername);
		dataSource.setPassword(serverPassword);
		dataSource.setServerName(serverIP);
		return dataSource;
	}
}
