package com.example.demo.Expense;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(path = "{userId}")
    public ExpensesByDateResponse getExpense(@PathVariable Long userId) {
        List<Expense> expenses = expenseService.getUserExpenses(userId);
        BigDecimal totalExpenses = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ExpensesByDateResponse expensesByDateResponse = new ExpensesByDateResponse();
        expensesByDateResponse.setTotalExpenses(totalExpenses);
        expensesByDateResponse.setExpenses(expenses);
        return expensesByDateResponse;
    }

    @PostMapping(path = "addExpense")
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setDate(LocalDateTime.now());
        expenseService.addExpense(expense);
        return expense;
    }

    @GetMapping(path = "getExpensesByDay/{userId}")
    public ExpensesByDateResponse getExpensesByDay(@PathVariable Long userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        LocalDateTime startDate = date.atStartOfDay();
        LocalDateTime endDate = date.atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        BigDecimal totalExpenses = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ExpensesByDateResponse expensesByDateResponse = new ExpensesByDateResponse();
        expensesByDateResponse.setTotalExpenses(totalExpenses);
        expensesByDateResponse.setExpenses(expenses);
        return expensesByDateResponse;
    }


    @GetMapping(path = "getExpensesByMonth/{userId}")
    public ExpensesByDateResponse getExpensesByMonth(@PathVariable Long userId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth) {
        LocalDateTime startDate = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime endDate = yearMonth.atEndOfMonth().atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        BigDecimal totalExpenses = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ExpensesByDateResponse expensesByDateResponse = new ExpensesByDateResponse();
        expensesByDateResponse.setTotalExpenses(totalExpenses);
        expensesByDateResponse.setExpenses(expenses);
        return expensesByDateResponse;
    }


    @GetMapping(path = "getExpensesByYear/{userId}")
    public ExpensesByDateResponse getExpensesByYear(@PathVariable Long userId, @RequestParam @DateTimeFormat(pattern = "yyyy") Year year) {
        LocalDateTime startDate = year.atDay(1).atStartOfDay();
        LocalDateTime endDate = year.atMonth(12).atDay(Month.DECEMBER.maxLength()).atTime(LocalTime.MAX);
        List<Expense> expenses = expenseService.getUserExpensesByDay(userId, startDate, endDate);
        BigDecimal totalExpenses = expenses.stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        ExpensesByDateResponse expensesByDateResponse = new ExpensesByDateResponse();
        expensesByDateResponse.setTotalExpenses(totalExpenses);
        expensesByDateResponse.setExpenses(expenses);
        return expensesByDateResponse;
    }

}
