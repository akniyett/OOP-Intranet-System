package finalProject;


public class Marks implements Serializable{

    double first_attestation;

    double second_attestation;

    double final_point;
    
    double cur;
    
	
	public Marks(){};

//	public Marks(double first_attestation, double second_attestation, double final_point) {
//		this.first_attestation = first_attestation;
//		this.second_attestation = second_attestation;
//		this.final_point = final_point;
//	}
    
    public double sum() {
    	return first_attestation + second_attestation + final_point;
    }

	@Override
	public String toString() {
		return "Marks [first_attestation=" + first_attestation + ", second_attestation=" + second_attestation
				+ ", final_point=" + final_point +  "]";
	}

//	public double getFirst_attestation() {
//		return first_attestation;
//	}
//
//	public void setFirst_attestation(double first_attestation) {
//		this.first_attestation = first_attestation;
//	}
//
//	public double getSecond_attestation() {
//		return second_attestation;
//	}
//
//	public void setSecond_attestation(double second_attestation) {
//		this.second_attestation = second_attestation;
//	}
//
//	public double getFinal_point() {
//		return final_point;
//	}
//
//	public void setFinal_point(double final_point) {
//		this.final_point = final_point;
//	}

}

