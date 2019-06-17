package ro.usv.rf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	protected static void displayMatrix(double[][] _learningSet) {
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

	protected static double[][] Wmatrix(int numberOfPatterns, int numberOfFeatures, double[][] learningSet,
			List<Double> classes) {

		double[][] wMatrix = new double[classes.size()][numberOfFeatures];

		List<double[]> tempMatrix = new ArrayList<double[]>();
		int wMatrixindex = 0;

		for (double clasa : classes) { // parcurgem matricea learningset pentru fiecare clasa existenta
			double[] wMatrixRow = new double[numberOfFeatures];
			for (int i = 0; i < numberOfPatterns; i++) {
				if (learningSet[i][numberOfFeatures - 1] == clasa) {
					tempMatrix.add(learningSet[i]);// selectam din learning set doar valorile pentru clasa curenta
				}
			}

			double[][] tempWlineMatrix = new double[tempMatrix.size()][];
			for (int i = 0; i < tempMatrix.size(); i++) {
				double[] row = tempMatrix.get(i);
				tempWlineMatrix[i] = row;
			}

			// toate valorile de pe un rand Wmatrix mai putin ultima
			for (int j = 0; j < tempWlineMatrix[0].length - 1; j++) {
				double media = 0;
				for (int i = 0; i < tempWlineMatrix.length; i++) {
					media += tempWlineMatrix[i][j];
				}
				wMatrixRow[j] = media / tempWlineMatrix.length;
			}

			// calculam ultima valoare pentru wRow
			double lastValueWrow = 0;
			for (int i = 0; i < wMatrixRow.length - 1; i++) {
				lastValueWrow += Math.pow(wMatrixRow[i], 2);
			}
			// wMatrixRow[wMatrixRow.length - 1] = -0.5 * lastValueWrow;
			wMatrixRow[wMatrixRow.length - 1] = Math.floor((-0.5 * lastValueWrow) * 100) / 100;

			// adaugare linie in Wrow cu valorile calculate
			wMatrix[wMatrixindex] = wMatrixRow;
			wMatrixindex++;

			// displayMatrix(wMatrix);
			// System.out.println();
			tempMatrix.clear();
			wMatrixRow = null;
		}
		return wMatrix;
	}

	protected static void determinClass(double[] testSet, double[][] matrixW, List<Double> classes) {
		int noOfClasesInMatrix = matrixW.length;
		int nrElemWrow = matrixW[0].length;
		int nrElemTestSet = testSet.length;
		int classIndex = 0;
		double sum, maxValue = 0;

		for (int i = 0; i < noOfClasesInMatrix; i++) {
			sum = 0;
			for (int j = 0; j < nrElemWrow; j++) {
				if (j < nrElemTestSet)
					sum += matrixW[i][j] * testSet[j];
				else
					sum += matrixW[i][j] * 1;
			}
			if (i == 0) {
				maxValue = sum;
				classIndex = 0;
			} else {
				if (sum > maxValue) {
					maxValue = sum;
					classIndex = i;
				}
			}

		}
		System.out.println("Clasa pentru setul " + Arrays.toString(testSet) + " este " + classes.get(classIndex));
	}

}
