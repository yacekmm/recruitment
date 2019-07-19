import java.util.*;

public class Dcp1{

     public static void main(String []args){
        System.out.println(hasFactors(new int[]{10, 15, 3 ,7}, 17));
        System.out.println(hasFactors(new int[]{20, 15, 3}, 17));
        System.out.println(hasFactors(new int[]{-2, 15, 19}, 17));
     }
	 
	 // iterate all items
	 // check if item is in set of wanted values
	 // if yes, return true
	 // if not, store items to find (k-arr[i]) in Set
     
	  
	static boolean hasFactors(int[] arr, int k) {
		
		Set<Integer> wantedItems = new HashSet();
		
		for (int i=0; i<arr.length; i++) {
		
			if(wantedItems.contains(arr[i])) {
				return true;
			} else {
				wantedItems.add(k - arr[i]);
			}
		}
		
		return false;
	}
}
/*
k=17
i=2
arr[i] = 19
wanted = 2
set={ 19, 2,  }

in	set	|	i	
-2				
15			
19			

*/