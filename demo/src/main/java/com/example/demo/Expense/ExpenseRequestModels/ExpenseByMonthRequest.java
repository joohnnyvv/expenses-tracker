package com.example.demo.Expense.ExpenseRequestModels;

import java.time.YearMonth;

public class ExpenseByMonthRequest {

    private String date;
    private Long userId;

    public YearMonth getDate() {
        return YearMonth.parse(date);
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
