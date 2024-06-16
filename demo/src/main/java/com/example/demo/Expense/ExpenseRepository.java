package com.example.demo.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);
    List<Expense> findExpensesByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}
