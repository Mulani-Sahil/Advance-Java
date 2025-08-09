/*a) Read a text file, specified by the first command line argument, into a list. The program 
should then display a menu which performs the following operations on the list: 
1. Insert line 2. Delete line 3. Append line 4. Modify line 5. Exit When 
the user selects Exit, save the contents of the list to the file and end the program.*/
package assignment1;
import java.io.*;
import java.util.*;
public class sCa {
public static void main(String[] args) {
	try {
		int ch,lno;
		String line;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\HeymCoder\\eclipse-workspace\\typracticals\\demo.txt"));
		ArrayList<String> list=new ArrayList<String>();
		String data="";
		while((data=br.readLine())!=null)
		{
			list.add(data);
		}
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\n---------MENU--------\n");
			System.out.println("1. Insert line \n2. Delete line \n3. Append line \n4. Modify line \n5. Save File \n6. Exit File");
			System.out.println("Enter Your Choice: ");
			ch=sc.nextInt();
			sc.nextLine();
			switch(ch)
			{
			case 1: System.out.println("Enter Line to add: ");
			line=sc.nextLine();
			list.add(0,line);
			System.out.println("Line added Succecssfully..............");
				break;
			case 2:System.out.println("Enter line number to delete that line: ");
			       lno=sc.nextInt();
			       sc.nextLine();
			       if(lno<=list.size()) {
			    	   System.out.println("Line number "+lno+" deleted successfully"+list.get(lno-1));
				       list.remove(lno-1);   
			       }
			       else {
				       System.out.println("Line does not exists.......");
			       }
			       break;
			case 3:System.out.println("Enter Line to append: ");
			line=sc.nextLine();
			list.add(line);
			System.out.println("Line appended successfully..");
				break;
			case 4:System.out.println("Enter line number to modify: ");
		       lno=sc.nextInt();
		       sc.nextLine();
		       if(lno<=list.size()) {
		    	   System.out.println("Enter text to be modified: ");
			       line=sc.nextLine();
			       list.set(lno-1, line);
			       System.out.println("Line modification done..........");
		       }
		       else {
			       System.out.println("Line does not exists.......");
		       }
				break;
			case 5:BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\\\Users\\\\HeymCoder\\\\eclipse-workspace\\\\typracticals\\\\demo.txt"));
					for(String g:list)
					{
						writer.write(g);
						writer.newLine();
					}
					writer.close();
				break;
				
			}
		}while(ch!=6);
		
	}catch(Exception e)
	{
		System.out.println(e);
	}
}
}
