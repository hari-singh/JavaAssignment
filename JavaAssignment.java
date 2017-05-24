import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
public class JavaAssignment extends Thread
{
	HashMap<Integer, String> map=new HashMap<>();
    public static void main(String args[])
    {
	JavaAssignment j = new JavaAssignment();
	Thread t = new Thread(j);
	t.start();	
    }
	public void run()
	{
		Scanner scan = new Scanner(System.in);
		while(true)
			{
			System.out.println("Enter 1 to Insert the Data");
			System.out.println("Enter 2 to see the Inserted Data");
			System.out.println("Enter 3 For Exit");
			int x=scan.nextInt();
		switch(x)
		{
		case 1:
				{
				System.out.println("Enter Key and Values");
				int n=scan.nextInt();
				scan.nextLine();
				String s=scan.nextLine();
				insertdata(n,s);
				break;
				}
		case 2:
				{
				System.out.println("Enter key to see the Inserted Data");
				int m=scan.nextInt();
				String s=getdata(m);
				System.out.println(s);
				break;
				}
		case 3:
			System.exit(0);
			}
		}
    }
	
	public synchronized void insertdata(int x,String y)
	{
		try{
		map.put(x,y);
		}
		catch(OutOfMemoryError e)
		{
			try{
			File f = new File("c://hari.txt");
			 FileOutputStream f1= new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(f1);
				oos.writeObject(map);
				oos.flush();
				oos.close();
				f1.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}

public synchronized String getdata(int x)
{
	String s=map.get(x);
	return s;
}

}

