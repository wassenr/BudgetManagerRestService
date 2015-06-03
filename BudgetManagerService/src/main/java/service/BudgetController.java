package service;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudgetController {

	// this mapping will provide a json list of all budgets
	@RequestMapping(value = "/budget", method = RequestMethod.GET)
	public List<Budget> budgets() {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		List<Budget> budgets = budgetDAO.findAll();

		context.close();
		return budgets;
	}

	// this mapping will provide a json list of all budget based on event
	@RequestMapping(value = "/budget/event/{eventid}", method = RequestMethod.GET)
	public List<Budget> budgetsByEvent(@PathVariable("eventid") int id) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		List<Budget> budgets = budgetDAO.findByEvent(id);

		context.close();
		return budgets;
	}

	// this mapping will provide access to budget with id budgetid
	@RequestMapping(value = "/budget/{budgetid}", method = RequestMethod.GET)
	public Budget budget(@PathVariable("budgetid") int id) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		Budget budget = budgetDAO.findById(id);

		context.close();
		return budget;
	}

	// this mapping will allow you to insert a new budget
	@RequestMapping(value = "/budget", method = RequestMethod.POST)
	public List<Budget> newBudget(@ModelAttribute Budget budget) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		budgetDAO.insert(budget);

		List<Budget> budgets = budgetDAO.findAll();

		context.close();
		return budgets;
	}

	// this mapping will update a budget
	@RequestMapping(value = "/budget", method = RequestMethod.PUT)
	public List<Budget> updateBudget(@ModelAttribute Budget budget) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		budgetDAO.update(budget);

		List<Budget> budgets = budgetDAO.findAll();

		context.close();
		return budgets;
	}
	
	//this mapping will allow you to delete a budget
	@RequestMapping(value = "/budget/{budgetid}", method = RequestMethod.DELETE)
	public List<Budget> deleteBudget(@PathVariable("budgetid") int id) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		BudgetDAO budgetDAO = (BudgetDAO) context.getBean("budgetDAO");

		budgetDAO.deleteById(id);

		List<Budget> budgets = budgetDAO.findAll();

		context.close();
		return budgets;
	}
}
