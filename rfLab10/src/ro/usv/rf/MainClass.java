package ro.usv.rf;

public class MainClass {

	public static void main(String[] args) {

		try {
			String[][] workingSet = FileUtils.readLearningSetFromFile("gradesClasses.txt");
			int nrOfForms = workingSet.length;
			int nrOfFeatures = workingSet[0].length;
			double eucDistance = 0.0;

			Distances.displayMatrix(workingSet);
			System.out.println();

			double[] testSet = new double[] { 2, 3 };

			for (int i = 0; i < nrOfForms; i++) {
				double[] nextSet = new double[nrOfFeatures];
				for (int j = 0; j < nrOfFeatures; j++) {
					// System.out.print(workingSet[i][j] + ' ');
				}
				eucDistance = Distances.euclidianDistance(testSet, workingSet[i]);
				System.out.println(eucDistance + '\n');
			}

		} catch (USVInputFileCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
