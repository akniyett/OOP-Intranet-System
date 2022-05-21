package finalProject;



public class CourseSchedule implements Serializable{

    private WeekDays day;

    private String hour;

    private int room;

	public WeekDays getDay() {
		return day;
	}

	public void setDay(WeekDays day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	

	public CourseSchedule(WeekDays day2, int hour2, int minute, int room2) {
		// TODO Auto-generated constructor stub
		this.day = day2;
		this.hour = hour2 + ":" + minute;
		this.room = room2;
	}

	@Override
	public String toString() {
		return "CourseSchedule [day=" + day + ", hour=" + hour + ", room=" + room + "]";
	}

    
}

