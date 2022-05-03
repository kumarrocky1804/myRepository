package Basic;

import java.util.Optional;

class Car
{
	String name;
	
	//public void Car() // allowed but not recommended. It wont be treated as constructor
	public Car()
	{
		System.out.println(name);
	}
	
	public String getName()
	{
		return this.name;
	}
}

public class OptionalDemo 
{
	public static void main(String[] args) 
	{
		Car car = new Car();
		
		Optional<Car> optionalCar = Optional.ofNullable(car);
		Optional<String> name = Optional.of(optionalCar.map(x -> x.getName()).orElse("ValueNotHere"));
		
		/*if(name.isPresent())
		{
			System.out.println(name);
		}
		else
		{
			System.out.println("value not present");
		}*/
		System.out.println(name.get());
	}
}
