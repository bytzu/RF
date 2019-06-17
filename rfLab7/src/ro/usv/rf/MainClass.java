package ro.usv.rf;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] learningSet;

		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			List<Double> classes = new ArrayList<Double>();
			double[][] matrixW;

			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));

			Distances.displayMatrix(learningSet);
			classes = Distances.classesArrayOrdered(numberOfPatterns, numberOfFeatures, learningSet);
			System.out.println(String.format("\nAvem %s clase\n", classes.size()));

			for (int i = 0; i < classes.size(); i++) {
				System.out.println(classes.get(i));
			}
			System.out.println();

			matrixW = Distances.Wmatrix(numberOfPatterns, numberOfFeatures, learningSet, classes);
			System.out.println("Matricea W:");
			Distances.displayMatrix(matrixW);

			double[] testSet1 = new double[] { 4, 5 };
			// double[] testSet1 = new double[] { 1, 3 };
			// double[] testSet2 = new double[] { 4, 5 };
			// double[] testSet3 = new double[] { 0, 0 };

			Distances.determinClass(testSet1, matrixW, classes);
			// Distances.determinClass(testSet2, matrixW, classes);
			// Distances.determinClass(testSet3, matrixW, classes);

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n Finished learning set operations");
		}
	}

}
