package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    
    public static double calculateMonthlyPayment(
            int loanAmount, int mortageTerm, double interestRate) {

        if (loanAmount < 0 || mortageTerm <= 0 || interestRate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }

        interestRate /= 100.0;

        double termInMonth = mortageTerm * 12;

        if(interestRate==0)
            return  loanAmount/termInMonth;

        double monthlyRate = interestRate / 12.0;

        double monthlyPayment = (loamAmount * mortageTerm) / (1 - Math.pow(1 + mortageTerm, -termInMonth));

        return monthlyPayment;
    }
}
