package assignment1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
public class sBc {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\HeymCoder\\Desktop\\SEM 5\\Adv Java\\demo.txt"));
			Hashtable ht=new Hashtable();
			String data="";
			while((data=br.readLine())!=null) 
			{
				String[] a=data.split("\t");
				
				ht.put(a[0], a[1]);
						}
			System.out.println(ht);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
