//Order of serialization is importanat in De-Serializing the objects.

import java.io.*;

class Dog implements Serializable
{
	int i = 10;
}

class Cat implements Serializable
{
	int i = 20;
}

class Rat implements Serializable
{
	int i = 30;
}

class SerializeDemo2
{
	public static void main(String[] args) throws Exception
	{
		Dog dog1 = new Dog();
		Cat cat1 = new Cat();
		Rat rat1 = new Rat();
		
		FileOutputStream fos = new FileOutputStream("prabhu.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dog1);
		oos.writeObject(cat1);
		oos.writeObject(rat1);
		
		FileInputStream fis = new FileInputStream("prabhu.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog dog2 = (Dog) ois.readObject();
		Cat cat2 = (Cat) ois.readObject();
		Rat rat2 = (Rat) ois.readObject();
		
		System.out.println(dog2.i);
		System.out.println(cat2.i);
		System.out.println(rat2.i);
	}
}