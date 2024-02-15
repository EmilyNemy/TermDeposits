package org.termdeposit;

public class TermDeposit {

    private final double principal;
    private final double interest;
    private final int term;


    public TermDeposit(double principal, double interest, int term){
        this.principal = principal;
        this.interest = interest;
        this.term = term;
    }
    public double calculateInterest(InterestPeriod interestPeriod) {
        double interestValue = interest / 100;
        double value = 1 + interestValue/interestPeriod.getCompoundPeriod();

        return switch (interestPeriod) {
            case AT_MATURITY -> principal * interestValue * term;
            case MONTHLY, QUARTERLY, ANNUALLY ->
                    principal * (Math.pow(value, (interestPeriod.getCompoundPeriod() * term)) - 1);
            default -> throw new UnsupportedOperationException("Invalid interest Period: " + interestPeriod);
        };

    }

    public double getCompoundInterest(InterestPeriod interestPeriod) {
        return Math.round(calculateInterest(interestPeriod) + principal);
    }
}

