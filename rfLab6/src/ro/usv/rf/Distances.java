package ro.usv.rf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Distances {

	protected static double calculatEuclidianDistances(double[] firstForm, String[] nextForm) {
		double euclidianDistance = 0.0;

		for (int i = 0; i < 1; i++) {
			euclidianDistance += Math.pow(firstForm[i] - Double.valueOf(nextForm[i]), 2);
		}
		return Math.floor(Math.sqrt(euclidianDistance) * 100) / 100;
	}

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

	static String reurneazaClasaApartinatoare(HashMap<String, Integer> resultClass) {
		String clase = " ", detaliiClase = "( ";
		double noOfCorectPredictions = 0, noOfTotalPredictions = 0;
		int maxValueInMap = (Collections.max(resultClass.values())); // max value in the Hashmap
		for (Entry<String, Integer> entry : resultClass.entrySet()) { // Iterate through hashmap
			if (entry.getValue() == maxValueInMap) {
				clase = clase + entry.getKey() + " ";
				noOfCorectPredictions += entry.getValue();
			}
			noOfTotalPredictions += entry.getValue();
			detaliiClase = detaliiClase + entry.getKey() + " = " + entry.getValue() + " ";

		}
		clase = clase + detaliiClase + " ) Acuracy of "
				+ Math.floor(((noOfCorectPredictions / noOfTotalPredictions) * 100) * 100) / 100 + "% ";
		return clase;
	}

}
