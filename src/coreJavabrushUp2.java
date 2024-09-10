
public class coreJavabrushUp2 {
	public static void main(String[] args) {

		int[] arr = {1,2,4,6,8,11,13,17,21,122};
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				System.out.println(arr[i]);
			}
			else {
				System.out.println(arr[i] + " Not divisible by 2");
			} 
		}
		
		int[] numbers = {2,4,6,8,11};
	    System.out.println(numbers[0]);
	    System.out.println(numbers[4]);
	    
	      int n = numbers.length;
	     for(int i=0;i<n/2;i++){
	         int temp = numbers[i];
	         numbers[i] = numbers[n - i - 1];
	         numbers[n - i - 1] = temp;
	     }
	     System.out.print("Reversed array: ");
	        for (int num : numbers) {
	            System.out.print(num + " ");
	        }
	}
	
	
	
 }
