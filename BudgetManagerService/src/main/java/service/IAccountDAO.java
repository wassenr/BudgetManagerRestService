package service;

import java.util.List;

public interface IAccountDAO {
	public void insert(Account account);

	public void update(Account account);

	public void delete(Account account);

	public void deleteById(int id);

	public List<Account> findAll();

	public Account findByTitle(String title);

	public Account findById(int id);
}
