package ro.usv.rf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class MainClass {

	public static void main(String[] args) {
		String[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("gradesClasses.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns,
					numberOfFeatures));

			Distances.displayMatrix(learningSet);

			// 3,80, 5.75,6.25, 7.25, 8.5
			double[] testSet = new double[] { 7.25 };
			ArrayList<Note> set1 = new ArrayList<Note>();
			for (int i = 0; i < numberOfPatterns; i++) {

				set1.add(new Note(Double.valueOf(learningSet[i][0]), learningSet[i][1],
						Distances.calculatEuclidianDistances(testSet, learningSet[i])));
			}

			set1.sort(Comparator.comparing(Note::getEuclidianDistance));

			// 1,3,5,7,9,13,17
			int[] kValues = new int[] { 1, 3, 5, 7, 9, 13, 17 };
			int i = 1;
			HashMap<String, Integer> resultClass = new HashMap<String, Integer>();

			for (Note notaa : set1) {
				System.out.println(
						notaa.getGradeValue() + " - " + notaa.getGradeClass() + " - " + notaa.getEuclidianDistance());
			}

			for (Note nota : set1) {

				int count = resultClass.containsKey(nota.getGradeClass()) ? resultClass.get(nota.getGradeClass()) : 0;
				resultClass.put(nota.getGradeClass(), count + 1);

				String clasa = Distances.reurneazaClasaApartinatoare(resultClass);
				System.out.printf("\nPentru k=%s nota " + testSet[0] + " apartine clasei %s", i, clasa);

				i++;
			}

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n\nFinished learning set operations");
		}
	}

}
