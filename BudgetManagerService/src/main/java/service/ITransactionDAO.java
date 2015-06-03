package service;

import java.util.List;

public interface ITransactionDAO {
	public void insert(Transaction transaction);
	public void update(Transaction transaction);
	public void delete(Transaction transaction);
	public void deleteById(int id);
	public Transaction findById(int id);
	public List<Transaction> findByEvent(int ev);
	public List<Transaction> findByAccount(int account);
	public List<Transaction> findAll();
}
