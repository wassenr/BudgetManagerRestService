package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class AccountRowMapper implements RowMapper<Object>{
	
	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		Account account = new Account();
		account.setId(arg0.getInt("ID"));
		account.setTitle(arg0.getString("TITLE"));
		account.setBalance(arg0.getDouble("BALANCE"));
		return account;
	}
}
