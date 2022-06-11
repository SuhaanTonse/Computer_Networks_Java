import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Random;
import java.math.BigInteger;
public class RSA{
	private BigInteger p,q,n,phi,e,d;
	private int bitlength=1024;
	private Random r;
	
	public RSA(){
		r = new Random();
		p=BigInteger.probablePrime(bitlength,r);
		q=BigInteger.probablePrime(bitlength,r);
		n=p.multiply(q);
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bitlength/2,r);
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0&&e.compareTo(phi)<0){
			e.add(BigInteger.ONE);
		}
		d=e.modInverse(phi);
	}
	public RSA(BigInteger e , BigInteger d, BigInteger n){
		this.e=e;
		this.d=d;
		this.n=n;
	}
	public static void main(String [] args) throws IOException{
		RSA r1 = new RSA();
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter the plain text: ");
		String testString="";
		testString=in.readLine();
		System.out.println("encrypting text: "+testString);
		System.out.println("encrypting byte: "+byteToString(testString.getBytes()));
		byte[] encrypted = r1.encrypt(testString.getBytes());
		byte[] decrypted = r1.decrypt(encrypted);
		System.out.println("decrying byte: "+byteToString(decrypted));
		System.out.println("decrypted text: "+ new String(decrypted));
	}
	private static String byteToString(byte[] message){
		String text="";
		for(byte b:message){
			text+=Byte.toString(b);
		}
		return text;
	}
	public byte[] encrypt(byte[] message){
		return (new BigInteger(message)).modPow(e,n).toByteArray();
	}
	public byte [] decrypt(byte[] message){
		return(new BigInteger(message)).modPow(d,n).toByteArray();
	}
		
		
}

