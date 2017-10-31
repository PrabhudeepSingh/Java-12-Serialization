import java.io.*;

class Dog implements Serializable
{
	Cat cat = new Cat();
}

class Cat implements Serializable
{
	Rat rat = new Rat();
}

class Rat implements Serializable
{
	int i = 10;
}


class ObjectGraph
{
	public static void main(String[] args) throws Exception
	{
		Dog dog1 = new Dog();
		
		FileOutputStream fos = new FileOutputStream("prabhu.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(dog1); 
		
		FileInputStream fis = new FileInputStream("prabhu.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog dog2 = (Dog) ois.readObject();
		
		System.out.println(dog2.cat.rat.i);
	}
}