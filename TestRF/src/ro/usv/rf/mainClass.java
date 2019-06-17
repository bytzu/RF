package ro.usv.rf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class mainClass {

	public static void main(String[] args) {
		String[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("gradesClasses.txt");
			int noOfPatterns = learningSet.length;
			int noOfForms = learningSet[0].length;
			System.out.println(noOfPatterns + " - " + noOfForms + "\n");
			// Distances.dispalayMatrix(learningSet, noOfPatterns, noOfForms);

			// 3,80, 5.75,6.25, 7.25, 8.5
			double[] testSet = new double[] { 5.75 };
			ArrayList<Note> set1 = new ArrayList<Note>();

			for (int i = 0; i < noOfPatterns; i++) {
				set1.add(new Note(Double.valueOf(learningSet[i][0]), learningSet[i][1],
						Distances.calculateDistance(testSet, learningSet[i])));
			}
			set1.sort(Comparator.comparing(Note::getDistance));

			// 1,3,5,7,9,13,17
			int[] kValues = new int[] { 1, 3, 5, 7, 9, 13, 17 };
			int i = 1;
			String maximum = "";
			HashMap<String, Integer> resultClass = new HashMap<String, Integer>();

			for (Note nota1 : set1) {
				int count = resultClass.containsKey(nota1.getCalificativ()) ? resultClass.get(nota1.getCalificativ())
						: 0;
				resultClass.put(nota1.getCalificativ(), count + 1);

				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 13 || i == 17) {
					maximum = Distances.returnMax(resultClass, i);
				} else {
					maximum = "";
				}
				System.out.println(
						nota1.getNota() + " - " + nota1.getCalificativ() + " - " + nota1.getDistance() + " " + maximum);
				i++;
			}

		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n Finished learning set");
		}

	}

}
