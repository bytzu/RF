package ro.usv.rf;

public class MainClass {

	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;

			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));

			for (int i = 1; i < numberOfPatterns; i++) {
				double euclidianDistance = Distances.calculatEuclidianDistances(learningSet[0], learningSet[i]);
				System.out.println(
						String.format("Euclidian distance between first pattern and %s is: %s", i, euclidianDistance));
				double mahalanovisDistance = Distances.calculateMahalasDistances(learningSet[0], learningSet[i],
						learningSet[0].length);
				System.out.println(String.format("Mahalanobis distance between first pattern and %s is: %s", i,
						mahalanovisDistance));
				double CebisievDist = Distances.calculateCebisievDistances(learningSet[0], learningSet[i]);
				System.out.println(
						String.format("Cebisiev distance between first pattern and %s is: %s", i, CebisievDist));
				double CityBDist = Distances.calculatecityBlockDistances(learningSet[0], learningSet[i]);
				System.out.println(String.format("cyty distance between first pattern and %s is: %s", i, CityBDist));

			}

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

}
