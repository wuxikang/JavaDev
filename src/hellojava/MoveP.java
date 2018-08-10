package hellojava;

public class MoveP {

	public int[] movePelements(int[] arr, int num) {
		int[] temparr = new int[num];
		int i = 0;
		while (i < num) {
			temparr[i] = arr[i];
			i++;
		}
		for (int j = 0; j < arr.length - num; j++) {
			arr[j] = arr[j + num];
		}
		for (int k = 0; k < num; k++) {
			arr[arr.length - num + k] = temparr[k];
		}
		return arr;

	}

}
