import java.io.*;

public class ExternalizeDemo implements Externalizable
{
	String s;
	int i;
	int j;
	
	public ExternalizeDemo()
	{
		System.out.println("No-Arg Constructor.");
	}
	
	public ExternalizeDemo(String s, int i,int j)
	{
		this.s = s;
		this.i = i;
		this.j = j;
	}
	
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeObject(s);
		out.writeInt(i);
	}
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		s = (String) in.readObject();
		i = in.readInt();
	}
	
	public static void main(String[] args) throws Exception
	{
		ExternalizeDemo ed1 = new ExternalizeDemo("prabhudeep", 10, 20);
		
		FileOutputStream fos = new FileOutputStream("prabhu.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ed1);
		
		FileInputStream fis = new FileInputStream("prabhu.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ExternalizeDemo ed2 = (ExternalizeDemo) ois.readObject();
		System.out.println(ed2.s+"..."+ed2.i+"..."+ed2.j);
	}
} 