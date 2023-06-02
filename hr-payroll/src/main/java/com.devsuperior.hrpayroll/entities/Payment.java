package com.devsuperior.hrpayroll.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TbPayment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
    private Integer days;

    public Payment() {
    }

    public Payment(Long id, String name, Double dailyIncome, Integer days) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    public double getTotal() {
        return dailyIncome * days;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
