package finalProject;

import java.sql.Date;
import java.time.LocalDateTime;


public class News implements Serializable{

    private String news;
    private int id;
    private LocalDateTime date = LocalDateTime.now();

    @Override
	public String toString() {
		return "News [news=" + news + ", id=" + id + ", date=" + date + "]";
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public News(String news, int id) {
		this.news = news;
		this.id = id;
	}
}

