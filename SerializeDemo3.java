//Order of serialization is importanat in De-Serializing the objects.
//If you do not know the order of serialization than you can use this trick.

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

class SerializeDemo3
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
		Dog dog2 = null;
		Cat cat2 = null;
		Rat rat2 = null;
		
		Object obj1 = ois.readObject();
		Object obj2 = ois.readObject();
		Object obj3 = ois.readObject();
		
		if(obj1 instanceof Dog)
			dog2 = (Dog) obj1;
			
		else
			if(obj1 instanceof Cat)
				cat2 = (Cat) obj1;
				
			else 
				if(obj1 instanceof Rat)
					rat2 = (Rat) obj1;
					
		if(obj2 instanceof Dog)
			dog2 = (Dog) obj2;
			
		else
			if(obj2 instanceof Cat)
				cat2 = (Cat) obj2;
				
			else 
				if(obj2 instanceof Rat)
					rat2 = (Rat) obj2;
		
		if(obj3 instanceof Dog)
			dog2 = (Dog) obj3;
			
		else
			if(obj3 instanceof Cat)
				cat2 = (Cat) obj3;
				
			else 
				if(obj3 instanceof Rat)
					rat2 = (Rat) obj3;
					
		System.out.println(dog2.i);
		System.out.println(cat2.i);
		System.out.println(rat2.i);
	}
}