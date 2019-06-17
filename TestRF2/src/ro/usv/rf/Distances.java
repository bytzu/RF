package ro.usv.rf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Distances {
	protected static void displayMatrix(double[][] matrix) {
		int patternsNo = matrix.length;
		int formsNo = matrix[0].length;
		for (int i = 0; i < patternsNo; i++) {
			for (int j = 0; j < formsNo; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static List<Double> returnClassesordered(double[][] learningSet, int patternsNo, int formsNo) {
		List<Double> classes = new ArrayList<Double>();
		for (int i = 0; i < patternsNo; i++) {
			if (!classes.contains(learningSet[i][formsNo - 1])) {
				classes.add(learningSet[i][formsNo - 1]);
			}
		}
		Collections.sort(classes);
		return classes;
	}

	public static void displayMatrixW(Double[][] matrix, List<Double> classes, int paterns, int features) {

	}

}
