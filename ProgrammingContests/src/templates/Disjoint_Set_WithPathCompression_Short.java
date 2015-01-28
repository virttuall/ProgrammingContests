package templates;

import java.util.Arrays;

public class Disjoint_Set_WithPathCompression_Short {

public static void main(String[] args) {
	int arr[] ={2,1,0};
	arr[1] = arr[0]+arr[1]-(arr[0] = arr[1]);
	System.out.println(Arrays.toString(arr));
}
}
