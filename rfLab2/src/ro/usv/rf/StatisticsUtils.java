package ro.usv.rf;

import java.util.HashMap;
import java.util.Map;

public class StatisticsUtils {

	protected static double calculateFeatureAverage(Double[] feature) {
		Map<Double, Integer> counterMap = getFeatureDistincElementsCounterMap(feature);
		double featureAverage = 0;

		double sum1 = 0;
		double sum2 = 0;

		sum1 = counterMap.keySet().stream().mapToDouble(x -> calculateSum1(x, counterMap.get(x))).sum();
		sum2 = counterMap.values().stream().mapToInt(x -> x).sum();
		featureAverage = sum1 / sum2;
		// System.out.println("The feature average is: " + featureAverage);
		return featureAverage;
	}

	protected static Map<Double, Integer> getFeatureDistincElementsCounterMap(Double feature[]) {
		Map<Double, Integer> counterMap = new HashMap<Double, Integer>();
		for (int j = 0; j < feature.length; j++) {
			if (counterMap.containsKey(feature[j])) {
				int count = counterMap.get(feature[j]);
				counterMap.put((feature[j]), ++count);
			} else {
				counterMap.put((feature[j]), 1);
			}
		}
		return counterMap;
	}

	protected static Map<Double, Double> getFeatureDistincElementsWeightsMap(Double feature[], Double weights[]) {
		Map<Double, Double> weightsMap = new HashMap<Double, Double>();
		for (int j = 0; j < feature.length; j++) {
			if (weightsMap.containsKey(feature[j])) {
				double currentWeight = weightsMap.get(feature[j]);
				weightsMap.put((feature[j]), currentWeight + weights[j]);
			} else {
				weightsMap.put((feature[j]), weights[j]);
			}
		}
		return weightsMap;
	}

	private static Double calculateSum1(double value, int count) {
		return count * value;
	}

	private static Double calculateSum1(double value, double weight) {
		return weight * value;
	}

	protected static double calculateFeatureWeightedAverage(Double[] feature, Double[] weights) {
		double featureWeightedAverage = 0.0;
		// your code here
		double sum1 = 0;
		double sum2 = 0;
		Map<Double, Double> weightsMap = getFeatureDistincElementsWeightsMap(feature, weights);
		sum1 = weightsMap.keySet().stream().mapToDouble(x -> calculateSum1(x, weightsMap.get(x))).sum();
		sum2 = weightsMap.values().stream().mapToDouble(x -> x).sum();
		featureWeightedAverage = sum1 / sum2;
		return featureWeightedAverage;
	}

	protected static double calculateFrequencyOfOccurence(Map<Double, Integer> counterMap, double featureElement) {
		double frequencyOfOccurence = 0.0;

		double sum1 = 0;
		double sum2 = 0;

		// Map<Double, Double> frequencyMap =

		return frequencyOfOccurence;
	}

	protected static double calculateFeatureDispersion(Double[] feature, double featureWeightedAverage) {
		double featureDispersion = 0.0;
		// your code here
		return featureDispersion;
	}

	protected static double calculateCovariance(Double[] feature1, Double[] feature2, double feature1WeightedAverage,
			double feature2WeightedAverage) {
		double covariance = 0.0;
		// your code here
		return covariance;
	}

	protected static double calculateCorrelationCoefficient(double covariance, double feature1Dispersion,
			double feature2Dispersion) {
		double correlationCoefficient = 0.0;
		// your code here
		return correlationCoefficient;
	}

	protected static double calculateAverageSquareDeviation(double featureDispersion) {
		double averageSquareDeviation = 0.0;
		// your code here
		return averageSquareDeviation;
	}
}
