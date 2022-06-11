package UDP;
import java.net.*;
import java.util.Scanner;
public class UDPServer{
	public static void main (String [] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(8000);
		byte [] rcvData= new byte[1024];
		byte [] sndData = new byte[1024];
		while(true){
			DatagramPacket rcvPacket = new DatagramPacket(rcvData,rcvData.length);
			ds.receive(rcvPacket);
			String toDisplay = new String( rcvPacket.getData());
			System.out.println("received message from client: "+toDisplay);
			InetAddress clientIp= rcvPacket.getAddress();
			int port = rcvPacket.getPort();
			System.out.println("Enter The message to be sent to client: ");
			Scanner sc = new Scanner(System.in);
			String dataSend= sc.nextLine();
			sndData= dataSend.getBytes();
			DatagramPacket sndPacket = new DatagramPacket(sndData,sndData.length,clientIp,port);
			ds.send(sndPacket);
			
		}
	}
	
}
