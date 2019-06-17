package ro.usv.rf;

public class Distances {
	public static void displayMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static double euclidianDistance(double[] firstForm, String[] nextForm) {
		double eucDistance = 0;
		for (int i = 0; i < firstForm.length - 1; i++) {
			String dist = nextForm[i];
			eucDistance += Math.pow(firstForm[i] - Double.valueOf(dist), 2);
			// System.out.println(Double.valueOf(firstForm[i]) + " - " +
			// Double.valueOf(nextForm[i]) + " = " + eucDistance);
			// System.out.println("---");
		}
		return Math.sqrt(eucDistance);
		// return Math.floor(Math.sqrt(eucDistance) * 100) / 100;

	}

}
