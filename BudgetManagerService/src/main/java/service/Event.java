package service;

public class Event {
	private int id;
	private String title;

	public Event() {

	}

	public Event(String title, int id) {
		this.title = title;
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
