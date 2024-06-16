package com.example.demo.Expense.ExpenseRequestModels;

import java.time.LocalDate;

public class ExpenseByDayRequest {
    private String date;
    private Long userId;

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public void setDate(LocalDate date) {
        this.date = date.toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
