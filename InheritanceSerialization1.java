import java.io.*;
class Parent implements Serializable
{
	int i = 10;
}

class Child extends Parent
{
	int j = 20;
}

class InheritanceSerialization1
{
	public static void main(String[] args) throws Exception
	{
		Child child1 = new Child();
		System.out.println(child1.i+"..."+child1.j);
		
		FileOutputStream fos = new FileOutputStream("prabhu.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(child1);
		
		FileInputStream fis = new FileInputStream("prabhu.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child child2 = (Child) ois.readObject();
		
		System.out.println(child2.i+"..."+child2.j);
	}
}