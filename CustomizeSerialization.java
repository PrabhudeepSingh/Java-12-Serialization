import java.io.*;

class Account implements Serializable
{
	String userName = "prabhu";
	transient String pwd = "deep";
	
	private void writeObject(ObjectOutputStream os) throws Exception
	{
		os.defaultWriteObject();
		String epwd = "123"+pwd;
		os.writeObject(epwd);
	}
	
	private void readObject(ObjectInputStream is) throws Exception
	{
		is.defaultReadObject();
		String epwd = (String) is.readObject();
		pwd = epwd.substring(3);
	}
}

class CustomizeSerialization
{
	public static void main(String[] args) throws Exception
	{
		Account acc1 = new Account();
		System.out.println(acc1.userName+"..."+acc1.pwd);
		FileOutputStream fos = new FileOutputStream("prabhudeep.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(acc1);
		
		FileInputStream fis = new FileInputStream("prabhudeep.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Account acc2 = (Account) ois.readObject();
		System.out.println(acc2.userName+"..."+acc2.pwd);
	}
}