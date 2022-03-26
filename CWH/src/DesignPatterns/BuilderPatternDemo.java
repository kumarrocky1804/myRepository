package DesignPatterns;
/* used to reduce the number of parameters and improve code design and readablity while creating
 * complex objects. It can also be used where the order of creating components is important
 * 
 * Link - https://www.geeksforgeeks.org/builder-design-pattern/
 * 
 * Creational design patterns
 */
// Final product
class House
{
	private String basement;
	private String structure;
	private String roof;
	private String interior;
	
	public String getBasement() {
		return basement;
	}
	public void setBasement(String basement) {
		this.basement = basement;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getRoof() {
		return roof;
	}
	public void setRoof(String roof) {
		this.roof = roof;
	}
	public String getInterior() {
		return interior;
	}
	public void setInterior(String interior) {
		this.interior = interior;
	}
}

// abstract builder
interface HouseBuilder
{
	public void buildBasement();
	public void buildStructure();
	public void buildRoof();
	public void buildInterior();
	
	public House getHouse();
}

// concrete Builder
class Builder implements HouseBuilder
{
	private House house;
	
	public Builder()
	{
		this.house = new House();
	}

	@Override
	public void buildBasement() {
		// TODO Auto-generated method stub
		house.setBasement("Basement built");
	}

	@Override
	public void buildStructure() {
		// TODO Auto-generated method stub
		house.setStructure("Structure Built");
	}

	@Override
	public void buildRoof() {
		// TODO Auto-generated method stub
		house.setRoof("Roof done");
	}

	@Override
	public void buildInterior() {
		// TODO Auto-generated method stub
		house.setInterior("Interiors decorated");
	}

	@Override
	public House getHouse() {
		// TODO Auto-generated method stub
		return house;
	}
}

//Director
class Engineer
{
	private HouseBuilder houseBuilder;
	
	public Engineer(HouseBuilder houseBuilder)
	{
		this.houseBuilder = houseBuilder;
	}
	
	public House getHouse()
	{
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.buildRoof();
		this.houseBuilder.buildInterior();
		return this.houseBuilder.getHouse();
	}
}

public class BuilderPatternDemo 
{
	public static void main(String[] args) {
		House house  = new Engineer(new Builder()).getHouse();
		
		System.out.println(house.getBasement());
		System.out.println(house.getStructure());
		System.out.println(house.getRoof());
		System.out.println(house.getInterior());
	}
}
