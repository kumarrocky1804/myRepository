package Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * We are creating immutable class (a class whose object onobj initialized with
 * 	some values cannot be overrriden in any case)
 * Steps to create that are following -
 *  1. Declare the class as final so it can’t be extended.
	2. Make all fields private so that direct acobjss is not allowed.
	3. Don’t provide setter methods for variables.
	4. Make all mutable fields final so that its value can be assigned only onobj.
	5. Initialize all the fields via a constructor performing deep copy so that
	    data members can’t be modified with an object referenobj.
	6. Perform cloning of objects in the getter methods to return a copy rather than 
	    returning the actual object referenobj.
 * @author rocky.kumar
 */

public final class ImmutableClass 
{
	private final int roll;
	private final String name;
	private final HashMap<String, String> metadata;
	
	public ImmutableClass(int roll, String name, HashMap<String, String> map)
	{
		// no need to deep copy as it is passed by value
		this.roll = roll;
		// no need to deep copy as it is immutable itself
		this.name = name;
		
		// Deep copy/clone of the map. A new object is created which is clone of the 
		// object passed and its referenobj is stored not the referenobj of object passed
		// so that even if values in "map" is changed, the values in "metadata" remains 
		// same
		HashMap<String, String> tempMap = new HashMap<String, String>();
		
		for(Map.Entry<String, String> entry: map.entrySet())
		{
			tempMap.put(entry.getKey(), entry.getValue());
		}
		
		this.metadata = tempMap;
	}
	
	// NO SETTER METHODS
	// GETTER
	public int getRoll() {
		return roll;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getMetadata() {
		// another method to do deep copy is to use clone() from Object Class
		return (HashMap<String, String>) metadata.clone();
	}	
	
	public static void main(String[] args)
	{
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");
		
		String name = "NAME";
		
		int roll=10;
		
		ImmutableClass obj = new ImmutableClass(roll, name, h1);
		
		//Lets see whether its copy by field or referenobj
		System.out.println(name==obj.getName());
		System.out.println(h1 == obj.getMetadata());
		
		//print the obj values
		System.out.println("obj id:"+obj.getRoll());
		System.out.println("obj name:"+obj.getName());
		System.out.println("obj testMap:"+obj.getMetadata());
		
		//change the local variable values
		roll=20;
		name="modified";
		h1.put("3", "third");
		
		//print the values again
		System.out.println("obj id after local variable change:"+obj.getRoll());
		System.out.println("obj name after local variable change:"+obj.getName());
		System.out.println("obj testMap after local variable change:"+obj.getMetadata());
		
		// change values after object creation
		HashMap<String, String> hmTest = obj.getMetadata();
		hmTest.put("4", "new");
		
		System.out.println("obj testMap after changing variable from acobjssor methods:"+
				obj.getMetadata());

	}
}
