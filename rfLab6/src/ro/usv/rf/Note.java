package ro.usv.rf;

public class Note {
	private String gradeClass;
	private double gradeValue;
	private double euclidianDistance;

	public Note(double nota, String calificativ, double distanta) {
		this.gradeValue = nota;
		this.gradeClass = calificativ;
		this.setEuclidianDistance(distanta);
	}

	public String getGradeClass() {
		return gradeClass;
	}

	public void setGradeClass(String calificativ) {
		this.gradeClass = calificativ;
	}

	public double getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(double nota) {
		this.gradeValue = nota;
	}

	public double getEuclidianDistance() {
		return euclidianDistance;
	}

	public void setEuclidianDistance(double distanta) {
		this.euclidianDistance = distanta;
	}

}
