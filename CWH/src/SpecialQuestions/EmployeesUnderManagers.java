package SpecialQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EmployeesUnderManagers 
{
	/*Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below. 

	{ "A", "C" },
	{ "B", "C" },
	{ "C", "F" },
	{ "D", "E" },
	{ "E", "F" },
	{ "F", "F" } 

	In this example C is manager of A, 
	C is also manager of B, F is manager 
	of C and so on.
	
	Answer should be
	A - 0  
	B - 0
	C - 2
	D - 0
	E - 1
	F - 5 */
	
	static HashMap<String,Integer> result = new HashMap<String,Integer>();
	
	public static void calculateEmployees(HashMap<String,String> dataset)
	{
		// we will first create a list for Manager and their employees.
		HashMap<String,ArrayList<String>> MgrEmpMap = new HashMap<String,ArrayList<String>>();
		
		for(Entry<String,String> entry: dataset.entrySet())
		{
			String manager = entry.getValue();
			String emp = entry.getKey();
			
			if(manager!=emp)
			{
				ArrayList<String> listofDirEmp = MgrEmpMap.get(manager);
				
				if(listofDirEmp == null)
				{
					listofDirEmp = new ArrayList<String>();
					MgrEmpMap.put(manager, listofDirEmp);
				}
				listofDirEmp.add(emp);
			}
		}
		
		// Now recursively calculate the direct employees and Indirect ones too.
		
		for(String manager: MgrEmpMap.keySet())
		{
			UtilFun(manager,MgrEmpMap);
		}
	}
	
	public static int UtilFun(String manager, HashMap<String,ArrayList<String>> MgrEmpMap)
	{
		int count=0;
		// if not a manager
		if(!MgrEmpMap.containsKey(manager))
		{
			result.put(manager, 0);
			return 0;
		}
		
		// if we already calculated in previous iterations
		if(result.containsKey(manager))
		{
			return result.get(manager);
		}
		
		ArrayList<String> directEmp = MgrEmpMap.get(manager);
		count = directEmp.size();
		for(String empWhoAreManagers: directEmp)
			count = count + UtilFun(empWhoAreManagers, MgrEmpMap);
		
		result.put(manager, count);
		return count;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> dataSet = new HashMap<String, String>();
        /*dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");*/
        
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        dataSet.put("Z", "A");
 
        calculateEmployees(dataSet);
        System.out.println("result = " + result);
	}
}
