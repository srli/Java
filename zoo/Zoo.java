package zoo;
import zoo.animal.Animal;

public class Zoo{
	public static void println(Object arg){ System.out.println(arg); }

	public static void main(String[] args){
		Animal puppy = new Animal("zak");
		println("Hello");
		println(puppy.name);
	}
}