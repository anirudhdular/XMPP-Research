import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class connectionManager {

	private static XMPPConnection conn;
	private static ConnectionConfiguration conconfig;
	static XMPPConnection getConnection(String username,String password,String server)
	{
		
		
		try {
			conconfig = new ConnectionConfiguration(server, 5222);
			conn = new XMPPConnection(conconfig);
			conn.connect();
			conn.login(username, password);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection problems.");
		}
		
		return conn;
		
	}
	
	
	static void disconnect(XMPPConnection conn)
	{
		conn.disconnect();
		System.out.println("Disconnected.");
	}
	
	
	
}
