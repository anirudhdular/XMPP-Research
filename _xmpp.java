import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class _xmpp{

	/**
	 * @param args
	 * @throws XMPPException 
	 * @throws InterruptedException 
	 */
	static XMPPConnection connection = null;
	public static void main(String[] args) throws XMPPException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		XMPPConnection conn = connectionManager.getConnection("admin", "123456", "localhost");
		IMmanager.sendIM("Hello", "anirudh@localhost", conn);
		
		//IMmanager.receiveIM(conn); //Uncomment only if u want to receieve IMs
		fileTransferManager fmngr = new fileTransferManager();
		fmngr.setConnection(conn);
		fmngr.receiveFile();
		
	}
}
	