package Basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Stream API Demo - 
 * Intermediate methods - map(), filter(), sorted().
 * Terminal Methods - collect(), reduce(), forEach().
 * 
 * Every intermediate method returns the stream of the modified values (actual object values
 * remains same). Terminal Methods
 * 
 * Parallel Streams are faster as they use all the cores of CPU (Multi threaded)
 */

public class StreamAPIDemo 
{
	public static void main(String[] args) {
		long start,end;
		
		start = System.currentTimeMillis();
		end = System.currentTimeMillis();
		
		List<Integer> list2 = Arrays.asList(1,4,5,2,3);
		start = System.currentTimeMillis();
		List<Integer> even = list2.stream().filter(x -> x%2==0).collect(Collectors.toList());
		end = System.currentTimeMillis();
		System.out.println(" Time by normal stream -" + (end-start));
		
		List<Integer> list = Arrays.asList(1,4,5,2,3);
		start = System.currentTimeMillis();
		List<Integer> square = list.parallelStream().map(x -> x*x).collect(Collectors.toList());
		end = System.currentTimeMillis();
		System.out.println(" Time by parallel stream -" + (end-start));
		
		System.out.println("Square");
		System.out.println(square);
		System.out.println("Even");
		even.stream().forEach(x -> System.out.print(x + ","));
		
		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		System.out.println();
		System.out.println("sorted - ");
		System.out.println(sorted);
		
		int sum = sorted.stream().reduce(0,(x,i) -> x+i);
		System.out.println("Sum - ");
		System.out.println(sum);
		
		// Same thing can be achieved by using :: operator instead of lambda 
		int sum2 = sorted.stream().reduce(0, Integer::sum);
		System.out.println("Sum again - ");
		System.out.println(sum2);
		
		System.out.println("original List - ");
		System.out.println(list);
	}
}
