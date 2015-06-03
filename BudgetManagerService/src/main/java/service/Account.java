package service;

public class Account {
	private String title;
	private double balance;
	private int id;
	
	public Account(String type, double balance){
		this.title = type;
		this.balance = balance;
	}
	
	public Account() {
		
	}

	public String getTitle(){
		return this.title;
	}
	
	public double getBalance(){
		return this.balance;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
}
