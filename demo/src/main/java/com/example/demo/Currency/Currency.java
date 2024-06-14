package com.example.demo.Currency;

import jakarta.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String displayName;
    private int numericCode;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(int numericCode) {
        this.numericCode = numericCode;
    }

    public int getDefaultFractionDigits() {
        return defaultFractionDigits;
    }

    public void setDefaultFractionDigits(int defaultFractionDigits) {
        this.defaultFractionDigits = defaultFractionDigits;
    }

    private int defaultFractionDigits;

    public Currency(String code, String displayName, int numericCode, int defaultFractionDigits) {
        this.code = code;
        this.displayName = displayName;
        this.numericCode = numericCode;
        this.defaultFractionDigits = defaultFractionDigits;
    }

    public Currency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = String.valueOf(java.util.Currency.getInstance(code));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
