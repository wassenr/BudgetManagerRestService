package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class BudgetRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		Budget budget = new Budget();
		budget.setId(arg0.getInt("ID"));
		budget.setTitle(arg0.getString("TITLE"));
		budget.setAmount(arg0.getDouble("BALANCE"));
		budget.setEvent(arg0.getInt("EVENT"));
		return budget;
	}
}
