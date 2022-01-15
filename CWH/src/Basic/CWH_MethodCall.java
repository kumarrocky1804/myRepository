package Basic;

public class CWH_MethodCall {
	
	private void add1(int a)
	{
		a++;
	}
	
	private void add1(int[] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			arr[i]++;
		}
	}

	public static void main(String[] args) {
		int a=100;
		int[] arr = {1,2,3,4,5};
		
		CWH_MethodCall obj = new CWH_MethodCall();
		// CALL by value
		obj.add1(a);
		System.out.println(a);
		
		// CALL by reference (actually it is call by value but the value is the refernce)
		obj.add1(arr);
		for(int ele:arr)
		{
			System.out.println(ele);
		}
	}
}
