import java.util.Scanner;
public class CRC{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Data word");
		String data = sc.nextLine();
		System.out.println("Enter generator polynomial");
		String gen =sc.nextLine();
		String code = data;
		while(code.length()< data.length()+(gen.length()-1)){
			code +="0";
			
		}
		code = data+div(code,gen);
		System.out.println("code"+code);
		String rem = div(code, gen);
		if(Integer.parseInt(rem)==0)
			System.out.println("No error");
		else
			System.out.println("error");
		System.out.println("Enter the position to alter the data");
		int pos = sc.nextInt();
		if(code.charAt(pos)=='0')
			code=code.substring(0,pos)+"1"+code.substring(pos+1);
		else
			code=code.substring(0,pos)+"0"+code.substring(pos+1);
		System.out.println("Alterd data "+code);
		if(Integer.parseInt(div(code,gen))==0)
			System.out.println("No error");
		else
			System.out.println("Error");
	}
		public static String div(String num1, String num2){
			int point = num2.length();
			String result =num1.substring(0,point);
			String rem="";
			for(int i=0; i<point;i++){
				if(result.charAt(i)==num2.charAt(i))
					rem+="0";
				else 
					rem +="1";
			}
			while(point<num1.length()){
				if(rem.charAt(0)=='0'){
					rem = rem.substring(1,rem.length());
					rem=rem+String.valueOf(num1.charAt(point));
					point++;
				}
				result=rem;
				rem="";
				if(result.charAt(0)!='0'){
					for(int i=0 ;i<num2.length();i++){
						if(result.charAt(i)==num2.charAt(i))
							rem +="0";
						else 
							rem+="1";
					}
				}
				
			else
				rem =result;
			
				
			
			
			
		}
		return rem.substring(1,rem.length());
			
			
	}
}