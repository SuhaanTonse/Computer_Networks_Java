import java.io.*;
import java.net.*;

public class TCPClient{
	public static void main(String[] args)throws IOException{
		Socket sock = new Socket("localhost",8000);
		System.out.println("Enter the file name: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String fileName=reader.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwriter = new PrintWriter(ostream,true);
		pwriter.println(fileName);
		System.out.println("File name sent to server"+fileName);
		InputStream istream = sock.getInputStream();
		System.out.println("Contents of file");
		BufferedReader toRead = new BufferedReader(new InputStreamReader(istream));
		String str;
		
		while((str=toRead.readLine())!=null){
			System.out.println(str);
		
		}
		
	}
	
}

