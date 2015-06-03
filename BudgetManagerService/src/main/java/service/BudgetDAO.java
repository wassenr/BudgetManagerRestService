package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class BudgetDAO implements IBudgetDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	@Override
	public void insert(Budget budget) {
		String sql = "INSERT into budget (title, amount, event) VALUES (?,?,?)";

		jdbcTemplate.update(
				sql,
				new Object[] { budget.getTitle(), budget.getAmount(),
						budget.getEvent() });

	}

	@Override
	public void update(Budget budget) {
		String sql = "UPDATE budget SET title=?,amount=?, event=? WHERE id=?";
		jdbcTemplate.update(
				sql,
				new Object[] { budget.getTitle(), budget.getAmount(),
						budget.getEvent(), budget.getId() });

	}

	@Override
	public void delete(Budget budget) {

		String sql = "DELETE FROM account where id=?";
		jdbcTemplate.update(sql, new Object[] { budget.getId() });

	}

	@Override
	public void deleteById(int id) {

		String sql = "DELETE FROM account where id=?";
		jdbcTemplate.update(sql, new Object[] { id });

	}

	@Override
	public List<Budget> findAll() {
		String sql = "SELECT * FROM budget";

		List<Budget> budgets = new ArrayList<Budget>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (@SuppressWarnings("rawtypes")
		Map row : rows) {
			Budget budget = new Budget();
			budget.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			budget.setTitle((String) (row.get("TITLE")));
			budget.setAmount(Double.parseDouble(String.valueOf(row
					.get("AMOUNT"))));
			budget.setEvent(Integer.parseInt(String.valueOf(row.get("EVENT"))));

			budgets.add(budget);
		}

		return budgets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Budget findById(int id) {
		String sql = "SELECT * FROM budget WHERE id=?";

		Budget budget = (Budget) jdbcTemplate.queryForObject(sql,
				new Object[] { id }, new BudgetRowMapper());

		return budget;
	}

	@Override
	public List<Budget> findByEvent(int eventId) {
		String sql = "SELECT * FROM budget WHERE event=?";

		List<Budget> budgets = new ArrayList<Budget>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,
				new Object[] { eventId });
		for (@SuppressWarnings("rawtypes")
		Map row : rows) {
			Budget budget = new Budget();
			budget.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			budget.setTitle((String) (row.get("TITLE")));
			budget.setAmount(Double.parseDouble(String.valueOf(row
					.get("AMOUNT"))));
			budget.setEvent(Integer.parseInt(String.valueOf(row.get("EVENT"))));

			budgets.add(budget);
		}

		return budgets;
	}

}
