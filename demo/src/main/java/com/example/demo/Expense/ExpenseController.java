package com.example.demo.Expense;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
}
