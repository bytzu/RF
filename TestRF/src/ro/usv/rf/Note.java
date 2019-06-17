package ro.usv.rf;

public class Note {
	private Double nota;
	private String calificativ;
	private Double distance;

	public Note(Double testSet, String _calificativ, Double _distance) {
		this.setNota(testSet);
		this.setCalificativ(_calificativ);
		this.setDistance(_distance);
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(double testSet) {
		this.nota = testSet;
	}

	public String getCalificativ() {
		return calificativ;
	}

	public void setCalificativ(String calificativ) {
		this.calificativ = calificativ;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}
