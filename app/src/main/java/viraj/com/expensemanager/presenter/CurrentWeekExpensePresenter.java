package viraj.com.expensemanager.presenter;

import viraj.com.expensemanager.database.ExpenseDatabaseHelper;
import viraj.com.expensemanager.utils.ExpenseCollection;
import viraj.com.expensemanager.view.CurrentWeekExpenseView;

public class CurrentWeekExpensePresenter {

  private CurrentWeekExpenseView view;
  private ExpenseDatabaseHelper database;
  private ExpenseCollection expenseCollection;

  public CurrentWeekExpensePresenter(ExpenseDatabaseHelper database, CurrentWeekExpenseView view) {
    this.database = database;
    this.view = view;
    expenseCollection = new ExpenseCollection(this.database.getCurrentWeeksExpenses());
  }

  public void renderTotalExpenses() {
    view.displayTotalExpenses(expenseCollection.getTotalExpense());
  }

  public void renderCurrentWeeksExpenses() {
    view.displayCurrentWeeksExpenses(expenseCollection.groupByDate());
  }
}
