import java.io.*;

class SerialVersionUIDDemo implements Serializable
{
	private static final long serialversionUID = 1l;
	int i = 10;
	int j = 20;
}

/* Sender.java, A program to be executed by sender */

//import java.io.*
class Sender
{
	public static void main(String[] args) throws Exception
	{
		SerialVersionUIDDemo obj1 = new SerialVersionUIDDemo();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prabhu.ser"));
		oos.writeObject(obj1);
	}
}

/* Reciever.java, A program to be executed by reciever */

//import java.io.*
class Reciever
{
	public static void main(String[] args) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prabhu.ser"));
		SerialVersionUIDDemo obj2 = (SerialVersionUIDDemo) ois.readObject();
		System.out.println(obj2.i+"..."+obj2.j);
	}
}