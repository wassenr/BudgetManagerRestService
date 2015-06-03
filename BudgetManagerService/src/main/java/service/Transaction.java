package service;

import java.sql.Date;

public class Transaction {
	private int id;
	private double amount;
	private String type;
	private Account account;
	private Event ev;
	private String note;
	private Date date;
	
	public Transaction(){
		
	}
	
	public Transaction(double amount, String type, Account account, Event ev, Date date){
		this.amount = amount;
		this.type = type;
		this.account = account;
		this.ev = ev;
		this.note = "";
		this.date = date;
	}
	
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public Account getAccount(){
		return this.account;
	}
	
	public void setAccount(Account account){
		this.account = account;
	}
	
	public Event getEvent(){
		return this.ev;
	}
	
	public void setEvent(Event ev){
		this.ev = ev;
	}
	
	public String getNote(){
		return this.note;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
}
