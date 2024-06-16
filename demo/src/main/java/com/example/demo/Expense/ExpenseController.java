package com.example.demo.Expense;

import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping(path = "getExpensesByDay/{userId}")
    public List<Expense> getExpensesByDay(@PathVariable Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = date.atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        return expenses.isEmpty() ? Collections.emptyList() : expenses;
    }


    @GetMapping(path = "getExpensesByMonth/{userId}")
    public List<Expense> getExpensesByMonth(@PathVariable Long userId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth) {
        LocalDateTime startDate = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime endDate = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        return expenses.isEmpty() ? Collections.emptyList() : expenses;
    }


    @GetMapping(path = "getExpensesByYear/{userId}")
    public List<Expense> getExpensesByYear(@PathVariable Long userId, @RequestParam @DateTimeFormat(pattern = "yyyy") Year year) {
        LocalDateTime startDate = year.atDay(1).atStartOfDay();
        LocalDateTime endDate = year.atMonth(12).atDay(Month.DECEMBER.maxLength()).atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        return expenses.isEmpty() ? Collections.emptyList() : expenses;
    }

}
