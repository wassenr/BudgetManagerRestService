package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAO implements IAccountDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	@Override
	public void insert(Account account) {
		String sql = "INSERT into account (title, balance) values (?,?)";
		jdbcTemplate.update(sql,
				new Object[] { account.getTitle(), account.getBalance() });

	}

	@Override
	public void update(Account account) {
		String sql = "UPDATE account SET title=?,balance=? WHERE id=?";
		jdbcTemplate.update(sql,
				new Object[] { account.getTitle(), account.getBalance(),
						account.getId() });
	}

	@Override
	public void delete(Account account) {
		String sql = "DELETE FROM account where id=?";
		jdbcTemplate.update(sql, new Object[] { account.getId() });
	}

	@Override
	public List<Account> findAll() {

		String sql = "SELECT * FROM account";

		List<Account> accounts = new ArrayList<Account>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (@SuppressWarnings("rawtypes")
		Map row : rows) {
			Account account = new Account();
			account.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			account.setTitle((String) (row.get("TITLE")));
			account.setBalance(Double.parseDouble(String.valueOf(row
					.get("BALANCE"))));

			accounts.add(account);
		}

		return accounts;
	}

	@Override
	public Account findByTitle(String title) {
		String sql = "SELECT * FROM account WHERE title=?";
		Account account = (Account) jdbcTemplate.queryForObject(sql,
				new Object[] { title }, new AccountRowMapper());
		return account;
	}

	@Override
	public Account findById(int id) {
		String sql = "SELECT * FROM account WHERE id=?";
		Account account = (Account) jdbcTemplate.queryForObject(sql,
				new Object[] { id }, new AccountRowMapper());
		return account;
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM account where id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

}
