public class LabelledLoop {

	public static void main(String[] args) {
		label1: for (int i = 1; i <= 3; i++) 
		{
			label2: for (int j = 1; j <= 3; j++) {
				if (j == 1) {
					System.out.println("Kodnest");
					break label1;
				}
			}
			System.out.println("------------------");
		}

	}

}
