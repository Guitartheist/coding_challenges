
public class Driver {
	public static void main(String args[]) {
		CircularArray<Integer> numArr = new CircularArray<>(5);
		CircularArray<String> sArr = new CircularArray<>(5);
		
		for (int i=0; i<numArr.length(); i++) {
			numArr.set(i, i);
		}
		
		for (int i=0; i<sArr.length(); i++) {
			sArr.set(i, Integer.toString(i));
		}
		
		for (int i=0; i<numArr.length(); i++) {
			System.out.println("Rotating array by +1");
			numArr.rotate(1);
			for (Integer j:numArr) {
				System.out.println(j);
			}
		}
		
		for (int i=0; i<sArr.length(); i++) {
			System.out.println("Rotating array by -1");
			sArr.rotate(-1);
			for (String s:sArr) {
				System.out.println(s);
			}
		}
	}
}
