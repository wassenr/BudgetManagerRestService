package service;

import java.util.List;

public interface IBudgetDAO {
	public void insert(Budget budget);

	public void update(Budget budget);

	public void delete(Budget budget);
	
	public void deleteById(int id);

	public List<Budget> findAll();

	public Budget findById(int id);

	public List<Budget> findByEvent(int eventId);
}
