import java.io.File;

import javax.swing.JFrame;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferListener;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferRequest;
import org.jivesoftware.smackx.filetransfer.IncomingFileTransfer;


public class xmpp_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	static IncomingFileTransfer transfer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		xmpp_GUI xmpp = new xmpp_GUI();
		xmpp.setSize(500, 500);
		xmpp.setTitle("XMPP");
		xmpp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		XMPPConnection conn = connectionManager.getConnection("admin", "123456", "localhost");
		FileTransferManager filetransfermngr;
		filetransfermngr = new FileTransferManager(conn);
		new ServiceDiscoveryManager(conn);
		filetransfermngr.addFileTransferListener(new FileTransferListener() {
			
			@Override
			public void fileTransferRequest(FileTransferRequest ftr) {
				// TODO Auto-generated method stub
				System.out.println(ftr.getRequestor());
                
				
                try {
             	   
                     transfer = ftr.accept();
                     transfer.recieveFile(new File("C:\\Users\\Anirudh\\Downloads\\Ani\\" + ftr.getFileName()));
                     System.out.println(transfer.getStreamID());
                     
                 } catch (XMPPException ex) {
                     
                     ex.printStackTrace();
                 } 	
                
                System.out.println("file recieved");
                 }
			
		});
		
		xmpp.setVisible(true);
	}

}
