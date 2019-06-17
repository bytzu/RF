package ro.usv.rf;

public class MainClass {

	public static void main(String[] args) {
		double[][] learningSet;

		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			double[][] distanceMatrix = new double[numberOfPatterns][numberOfPatterns];

			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));

			for (int i = 1; i < numberOfPatterns; i++) {
				// double euclidianDistance =
				// Distances.calculatEuclidianDistances(learningSet[0], learningSet[i]);
				// System.out.println(String.format("Euclidian distance between first pattern
				// and %s is: %s", i, euclidianDistance));
				// double mahalanovisDistance =
				// Distances.calculateMahalasDistances(learningSet[0], learningSet[i],
				// learningSet[0].length);
				// System.out.println(String.format("Mahalanobis distance between first pattern
				// and %s is: %s", i,mahalanovisDistance));
				// double CebisievDist = Distances.calculateCebisievDistances(learningSet[0],
				// learningSet[i]);
				// System.out.println(String.format("Cebisiev distance between first pattern and
				// %s is: %s", i, CebisievDist));
				// double CityBDist = Distances.calculatecityBlockDistances(learningSet[0],
				// learningSet[i]);
				// System.out.println(String.format("cyty distance between first pattern and %s
				// is: %s", i, CityBDist));
				// double newGeneralizedMatrix =
				// Distances.calculateGeneralizedEuclidianDistance(learningSet);

			}

			System.out.println("\n+++++++++++++++++++++ LearningSet Matrix +++++++++++++++++++\n");
			for (int i = 0; i < numberOfPatterns; i++) {
				for (int j = 0; j < learningSet[i].length; j++) {
					System.out
							.print(j == 0 ? "linia--[" + i + "] " + learningSet[i][j] + " " : learningSet[i][j] + " ");
				}
				System.out.println();

			}
			System.out.println("\n+++++++++++++++++ End LearningSet Matrix +++++++++++++++++++\n");

			for (int i = 0; i < numberOfPatterns; i++) {
				for (int j = i + 1; j < numberOfPatterns; j++) {
					distanceMatrix[i][j] = Distances.calculateGeneralizedEuclidianDistance(learningSet, i, j);
					distanceMatrix[j][i] = distanceMatrix[i][j];
					// System.out.print(newMatrix[i][j] + " ");
				}
				// System.out.println();
			}

			System.out.println("\n+++++++++++++++++++++ Distances Matrix +++++++++++++++++++\n");
			for (int i = 0; i < distanceMatrix.length; i++) {
				for (int j = 0; j < distanceMatrix.length; j++) {
					System.out.print(distanceMatrix[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("\n+++++++++++++++++ End Distances Matrix +++++++++++++++++++\n");

			// k-nn
			int searchPattern = learningSet.length - 1;
			double[] distances = distanceMatrix[searchPattern];
			int closestPattern = 0;
			double minDistance = distances[closestPattern];
			for (int i = 1; i < distances.length; i++) {
				if (distances[i] < minDistance && searchPattern != i) {
					minDistance = distances[i];
					closestPattern = i;
				}
			}

			double[] classColumn = learningSet[closestPattern - 1];
			// int classColumn = learningSet[closestPattern - 1];
			System.out.println(String.format("The Searched class is %s", learningSet[searchPattern][closestPattern]));

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n Finished learning set operations");
		}
	}

}
