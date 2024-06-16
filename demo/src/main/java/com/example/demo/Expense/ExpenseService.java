package com.example.demo.Expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getUserExpenses(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> getUserExpensesByDay(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return expenseRepository.findExpensesByUserIdAndDateBetween(userId, startDate, endDate);
    }
}
