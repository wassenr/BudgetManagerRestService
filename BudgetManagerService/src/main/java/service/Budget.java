package service;

public class Budget {
	
	private int id;
	private String title;
	private double amount;
	private int ev;
	
	public Budget(){
		
	}
	
	public Budget(String title, double amount, int ev){
		this.title = title;
		this.amount = amount;
		this.ev = ev;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public int getEvent(){
		return this.ev;
	}
	
	public void setEvent(int ev){
		this.ev = ev;
	}
}
