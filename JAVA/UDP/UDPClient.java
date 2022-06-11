import java.io.*;
import java.net.*;
import java.util.Scanner;
public class UDPClient{
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket();
		byte [] rcvData = new byte[1024];
		byte [] sndData = new byte[1024];
		System.out.println("Enter the message to be sent: ");
		Scanner sc = new Scanner(System.in);
		String dataSend = sc.nextLine();
		sndData = dataSend.getBytes();
		InetAddress myIp = InetAddress.getByName("localhost");
		DatagramPacket sndPacket= new DatagramPacket(sndData,sndData.length,myIp,8000);
		ds.send(sndPacket);
		System.out.println("Message sent to server :"+dataSend);
		DatagramPacket rcvPacket = new DatagramPacket(rcvData,rcvData.length);
		ds.receive(rcvPacket);
		String toDisplay = new String(rcvPacket.getData());
		System.out.println("Received message from server"+ toDisplay);
		
	}
}
