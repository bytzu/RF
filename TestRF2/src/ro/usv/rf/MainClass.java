package ro.usv.rf;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		try {
			double[][] learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int patternsNo = learningSet.length;
			int featuresNo = learningSet[0].length;

			System.out.printf("Avem %d forme cu %d features", patternsNo, featuresNo);
			System.out.println();

			List<Double> classes = new ArrayList<Double>();
			Double[][] matrixW;

			Distances.displayMatrix(learningSet);
			classes = Distances.returnClassesordered(learningSet, patternsNo, featuresNo);
			System.out.println("\nAvem " + classes.size() + " clase");

			for (int i = 0; i < classes.size(); i++) {
				System.out.println(classes.get(i));
			}

			Distances.displayMatrixW();

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n Finished learning set operations");
		}
	}

}
