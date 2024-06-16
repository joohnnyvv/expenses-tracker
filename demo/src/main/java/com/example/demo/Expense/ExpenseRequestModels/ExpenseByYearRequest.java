package com.example.demo.Expense.ExpenseRequestModels;

import java.time.Year;

public class ExpenseByYearRequest {
    private String date;
    private Long userId;

    public Year getDate() {
        return Year.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
