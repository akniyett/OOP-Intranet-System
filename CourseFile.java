package finalProject;


public class CourseFile implements Serializable{
	
	
	private String fileName;

    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "CourseFile [fileName=" + fileName  + "]";
	}

	public CourseFile(String fileName) {
		this.fileName = fileName;
	}
}

