package finalProject;

public interface MarksBuilder{
	
	MarksBuilder setFirstAttestation(double first);
	MarksBuilder setSecondAttestation(double second);
	MarksBuilder setFinalPoint(double finalPoint);
	Marks build();
}
