import java.io.*;
class Parent 
{
	int i = 10;
	
	Parent()
	{
		System.out.println("Parent class Constructor");
	}
}

class Child extends Parent implements Serializable
{
	int j = 20;
	Child()
	{
		System.out.println("Child Class Constructor");
	}
}

class InheritanceSerialization2
{
	public static void main(String[] args) throws Exception
	{
		Child child1 = new Child();
		
		FileOutputStream fos = new FileOutputStream("prabhu.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(child1);
		
		System.out.println("DeSerialization started.");
		FileInputStream fis = new FileInputStream("prabhu.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child child2 = (Child) ois.readObject();
		
		System.out.println(child2.i+"..."+child2.j);
	}
}