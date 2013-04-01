import java.io.File;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferListener;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferRequest;
import org.jivesoftware.smackx.filetransfer.IncomingFileTransfer;


public class fileTransferManager {

	private XMPPConnection conn = null;
	FileTransferManager fileTransferManager;
	IncomingFileTransfer transfer;
	
	void setConnection(XMPPConnection conn)
	{
		this.conn = conn;
	}
	
	synchronized public void receiveFile()
	{
		System.out.println("Ready to receive file");
		
					while(true){
	    	         new ServiceDiscoveryManager(conn);
	                                        fileTransferManager = new FileTransferManager(conn);
	                                        
	                                        //FileTransferNegotiator.setServiceEnabled(conn, true);
	                            
	                            	fileTransferManager.addFileTransferListener(new FileTransferListener() {
	    	                    		
                                        @Override
                                        public void fileTransferRequest(final FileTransferRequest ftr) {
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
								}           
	                    
					}
	}


