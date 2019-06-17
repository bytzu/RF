package ro.usv.rf;

public class Distances {
	protected static double calculatEuclidianDistances(double[] firstForm, double[] nextForm) {
		double euclidianDistance = 0.0;

		for (int i = 0; i < 2; i++) {
			euclidianDistance += Math.pow(firstForm[i] - nextForm[i], 2);
		}
		return Math.sqrt(euclidianDistance);
	}

	protected static double calculateGeneralizedEuclidianDistance(double[][] matrix, int _i, int _j) {
		double euclidianDistance = 0.0;
		int numberOfFeatures = matrix[0].length - 1;
		for (int i = 0; i < numberOfFeatures; i++) {
			euclidianDistance += Math.pow(matrix[_i][i] - matrix[_j][i], 2);
		}
		return Math.floor(Math.sqrt(euclidianDistance) * 100) / 100;

	}

	protected static double calculateMahalasDistances(double[] firstForm, double[] nextForm, int n) {
		double distance = 0.0;

		for (int i = 0; i < firstForm.length; i++) {
			distance += Math.pow(firstForm[i] - nextForm[i], n);
		}
		return Math.pow(distance, 1.0 / n);
	}

	protected static double calculateCebisievDistances(double[] firstForm, double[] nextForm) {
		double distance = 0.0;
		double max = Math.abs(firstForm[0] - nextForm[0]);

		for (int i = 0; i < firstForm.length; i++) {
			distance = Math.abs(firstForm[i] - nextForm[i]);
			if (distance > max)
				max = distance;
		}
		return max;
	}

	protected static double calculatecityBlockDistances(double[] firstForm, double[] nextForm) {
		double distance = 0.0;

		for (int i = 0; i < firstForm.length; i++) {
			distance += Math.abs(firstForm[i] - nextForm[i]);

		}
		return distance;
	}
}
