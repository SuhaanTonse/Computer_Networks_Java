import java.io.*;
import java.net.*;
public class TCPServer{
	public static void main(String [] args) throws IOException{
		ServerSocket servSock = new ServerSocket(8000);
		System.out.println("Server is ready to accept connections");
		Socket sock = servSock.accept();
		System.out.println("Connection Established");
		InputStream istream = sock.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
		String fileName= reader.readLine();
		System.out.println("received file name from client"+fileName);
		BufferedReader contReader = new BufferedReader( new FileReader(fileName));
		OutputStream ostream =sock.getOutputStream();
		PrintWriter pwriter = new PrintWriter(ostream,true);
		String str;
		while(( str = contReader.readLine())!=null){
			pwriter.println(str);
		}
		
		
	}
	
}
