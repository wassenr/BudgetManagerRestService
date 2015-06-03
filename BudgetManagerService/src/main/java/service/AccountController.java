package service;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	// this mapping will provide a json list of all accounts
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public List<Account> accounts() {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");

		List<Account> accounts = accountDAO.findAll();

		context.close();
		return accounts;
	}

	// this mapping will provide access to account with id accountid
	@RequestMapping(value = "/account/{accountid}", method = RequestMethod.GET)
	public Account account(@PathVariable("accountid") int id) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");

		Account account = accountDAO.findById(id);

		context.close();
		return account;
	}

	// this mapping will allow you to post a new account, and return an updated
	// list of accounts
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	@ResponseBody
	public List<Account> newAccount(@ModelAttribute Account account) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");

		accountDAO.insert(account);

		List<Account> accounts = accountDAO.findAll();

		context.close();
		return accounts;
	}

	// this mapping will all you to update an account and return an updated
	// list of accounts
	@RequestMapping(value = "/account", method = RequestMethod.PUT)
	@ResponseBody
	public List<Account> updateAccount(@ModelAttribute Account account) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");

		System.out.println((String) account.getTitle());
		accountDAO.update(account);

		List<Account> accounts = accountDAO.findAll();

		context.close();
		return accounts;
	}

	// this mapping will allow you to delete an account, and return an updated
	// list of accounts
	@RequestMapping(value = "/account/{accountid}", method = RequestMethod.DELETE)
	@ResponseBody
	public List<Account> deleteAccount(@PathVariable("accountid") int id) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");

		accountDAO.deleteById(id);

		List<Account> accounts = accountDAO.findAll();

		context.close();
		return accounts;
	}

}
