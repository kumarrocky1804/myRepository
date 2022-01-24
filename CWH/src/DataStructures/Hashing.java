package DataStructures;

public class Hashing 
{
	/* Here hash table is implemented with separate chaining as collision handling mechanism.
	 *  We are just going to insert keys in the table for the simplicity, but in real world,
	 * key-value pairs are inserted.
	*/
	 private LinkedList[] list;
	 private int bucket;
	 
	 public Hashing()
	 {
		 // for simplicity we are taking bucket size as 5
		 bucket=5;
		 list = new LinkedList[bucket];
		 for(int i=0; i<5; i++)
			 list[i] = new LinkedList();
	 }
	 
	 public int hash(int input)
	 {
		 // simple hash function, start over with 0 when reach to 5
		 return input%5;
	 }
	 
	 public void insert(int key)
	 {
		 int index = hash(key);
		 
		 list[index].addEnd(new Node(key));
	 }
	 
	 public Node search(int key)
	 {
		 int index = hash(key);
		 
		 // search in linked list
		 Node currNode = list[index].getHead();
		 while(currNode!=null&&currNode.getData()!= key)
			 currNode = currNode.getNext();
		 if(currNode==null)
		 {
			 System.out.println("Data not found");
			 return null;
		 }
		 return currNode;
	 }
	 
	 public void delete(int key)
	 {
		 int index = hash(key);
		 
		 Node currNode = list[index].getHead();
		 if(currNode==null)
		 {
			 System.out.println("Nothing to delete");
		 }
		 else if(currNode.getData()==key)
		 {
			 list[index].setHead(list[index].getHead().getNext());
		 }
		 else
		 {
			 while(currNode.getNext().getData()!=key)
				 currNode=currNode.getNext();
			 
			 currNode.setNext(currNode.getNext().getNext());
		 }
	 }
	 
	 public void display()
	 {
		 for(int i=0; i<bucket; i++)
		 {
			 System.out.println();
			 if(list[i].getHead()!=null)
			 {
				 list[i].display();
			 }
		 }
	 }
	 
	 public static void main(String[] args) {
		Hashing hash = new Hashing();
		
		for(int i=0; i<10; i++)
			hash.insert(i);
		
		hash.display();
		System.out.println();
		System.out.println(hash.search(7).getData());
		System.out.println();
		hash.delete(7);
		hash.delete(3);
		
		hash.display();
	}
}
