package ro.usv.rf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Distances {

	public static void dispalayMatrix(String[][] learningSet, int patterns, int forms) {
		for (int i = 0; i < patterns; i++) {
			for (int j = 0; j < forms; j++) {
				System.out.println(learningSet[i][j] + " ");
			}
		}
	}

	public static Double calculateDistance(double[] entryPattern, String[] comparePattern) {
		Double euclidianDistance = 0.0;
		for (int i = 0; i < comparePattern.length - 1; i++) {
			euclidianDistance += Math.pow(Double.valueOf(comparePattern[i]) - Double.valueOf(entryPattern[i]), 2);
		}
		euclidianDistance = Math.floor(Math.sqrt(euclidianDistance) * 100) / 100;
		return euclidianDistance;

	}

	public static String returnMax(HashMap<String, Integer> resultClass, int k) {
		int maxValueInMap = (Collections.max(resultClass.values()));
		String result = "";
		for (Entry<String, Integer> entry : resultClass.entrySet()) {
			if (entry.getValue() == maxValueInMap) {
				result = "Pentru k = " + k + " clasa apartinatoare este " + entry.getKey();
			}
		}
		return result;
	}
}
