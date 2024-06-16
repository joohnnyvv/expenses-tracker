package com.example.demo.Expense;

import com.example.demo.Expense.ExpenseRequestModels.ExpenseByDayRequest;
import com.example.demo.Expense.ExpenseRequestModels.ExpenseByMonthRequest;
import com.example.demo.Expense.ExpenseRequestModels.ExpenseByYearRequest;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(path = "{userId}")
    public List<Expense> getExpense(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.getUserExpenses(userId);
        if (expenses.isEmpty()) {
            return Collections.emptyList();
        } else {
            return expenses;
        }
    }

    @PostMapping(path = "addExpense")
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setDate(LocalDateTime.now());
        expenseService.addExpense(expense);
        return expense;
    }

    @PostMapping(path = "getExpensesByDay")
    public List<Expense> getExpensesByDay(@RequestBody ExpenseByDayRequest expenseByDayRequest) {
        LocalDate date = expenseByDayRequest.getDate();
        Long userId = expenseByDayRequest.getUserId();
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, date.atStartOfDay(), date.atTime(LocalTime.MAX));
        if (expenses.isEmpty()) {
            return Collections.emptyList();
        } else {
            return expenses;
        }
    }

    @PostMapping(path = "getExpensesByMonth")
    public List<Expense> getExpensesByMonth(@RequestBody ExpenseByMonthRequest expenseByMonthRequest) {
        YearMonth yearMonth = expenseByMonthRequest.getDate();
        LocalDateTime startDate = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime endDate = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);
        Long userId = expenseByMonthRequest.getUserId();
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        if (expenses.isEmpty()) {
            return Collections.emptyList();
        } else {
            return expenses;
        }
    }

    @PostMapping(path = "getExpensesByYear")
    public List<Expense> getExpensesByYear(@RequestBody ExpenseByYearRequest expenseByYearRequest) {
        Year year = expenseByYearRequest.getDate();
        LocalDateTime startDate = year.atDay(1).atStartOfDay();
        LocalDateTime endDate = year.atMonth(12).atDay(Month.NOVEMBER.maxLength()).atTime(LocalTime.MAX);
        Long userId = expenseByYearRequest.getUserId();
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        if (expenses.isEmpty()) {
            return Collections.emptyList();
        } else {
            return expenses;
        }
    }
}
