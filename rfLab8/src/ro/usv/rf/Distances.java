package ro.usv.rf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distances {

	protected static double calculateGeneralizedEuclidianDistance(String[][] matrix, int _i, int _j) {
		double euclidianDistance = 0.0;
		int numberOfFeatures = matrix[0].length - 1;
		for (int i = 0; i < numberOfFeatures; i++) {
			euclidianDistance += Math.pow(Double.valueOf(matrix[_i][i]) - Double.valueOf(matrix[_j][i]), 2);
		}
		return Math.floor(Math.sqrt(euclidianDistance) * 100) / 100;

	}

	protected static void displayMatrix(String[][] _learningSet) {
		int _numberOfPatterns = _learningSet.length;
		int _numberOfFeatures = _learningSet[0].length;

		for (int i = 0; i < _numberOfPatterns; i++) {
			for (int j = 0; j < _numberOfFeatures; j++) {
				System.out.print(_learningSet[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	protected static List<Double> classesArrayOrdered(int _numberOfPatterns, int _numberOfFeatures,
			double[][] _learningSet) {
		List<Double> clase = new ArrayList<Double>();
		for (int i = 0; i < _numberOfPatterns; i++) {
			if (!clase.contains(_learningSet[i][_numberOfFeatures - 1]))
				clase.add(_learningSet[i][_numberOfFeatures - 1]);
		}
		Collections.sort(clase);
		return clase;
	}

}