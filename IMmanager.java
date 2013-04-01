import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;


public class IMmanager {

	private static Message msg = new Message();
	private static Chat chat = null;
	
	
	static void  sendIM(String message,String receipientID,XMPPConnection conn)
	{
		msg.setBody(message);
		chat = conn.getChatManager().createChat(receipientID, null);
		try {
			chat.sendMessage(msg);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void receiveIM(XMPPConnection conn)
	{
		PacketFilter filter = new AndFilter(new PacketTypeFilter(Message.class));
        PacketCollector collector = conn.createPacketCollector(filter);
        while (true) {
            Packet packet = collector.nextResult();
            if (packet instanceof Message) {
                Message message = (Message) packet;
                if (message != null && message.getBody() != null)
                    System.out.println("Received message from "
                            + packet.getFrom() + " : "
                            + (message != null ? message.getBody() : "NULL"));
            }
        }
    }
		
	}
	
	

