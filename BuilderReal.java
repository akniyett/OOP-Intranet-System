package finalProject;

public class BuilderReal implements MarksBuilder, Serializable{

	Marks mark = new Marks();
	@Override
	public MarksBuilder setFirstAttestation(double first) {
		mark.first_attestation = first;
		return this;
	}

	@Override
	public MarksBuilder setSecondAttestation(double second) {
		mark.second_attestation = second;
		return this;
	}

	@Override
	public MarksBuilder setFinalPoint(double finalPoint) {
		mark.final_point = finalPoint;
		return this;
	}

	@Override
	public Marks build() {
		
		return mark;
	}

}
