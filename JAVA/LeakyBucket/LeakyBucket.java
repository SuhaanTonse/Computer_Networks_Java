import java.util.Scanner;
public class LeakyBucket{
	public static void main(String [] args){
		int rem=0;
		int i,sent,rcvd;
		int[] a = new int[25];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bucket Capacity");
		int capacity = sc.nextInt();
		System.out.println("Enter the rate");
		int rate = sc.nextInt();
		System.out.println("Enter the no of packets");
		int np = sc.nextInt();
		System.out.println("Enter The packets");
		for( i=1; i<=np;i++){
			a[i] = sc.nextInt();
		}
		System.out.println("Clock \t\t Packet \t\t Received \t\t Sent\t\t Remaining\n");
		for(i =1 ; i<=np;i++){
			if (a[i]!=0){
				if(rem+a[i]>capacity){
					rcvd=-1;
				}
				else{
					rcvd=a[i];
					rem+=a[i];
				}
			}
			else 
				rcvd=0;
			if(rem!=0){
				if(rem < rate){
					sent=rem;
					rem=0;
				}
				else{
					sent=rate;
					rem=rem-rate;
				}
			}
			else
				sent =0;
			if(rcvd==-1)
				System.out.println(i+"\t\t\t"+a[i]+"\t\t\t"+"dropped"+"\t\t\t"+sent+"\t\t\t"+rem+"\n");
			else
				System.out.println(i+"\t\t\t"+a[i]+"\t\t\t"+rcvd+"\t\t\t"+sent+"\t\t\t"+rem+"\n");
		}
	}
	
}