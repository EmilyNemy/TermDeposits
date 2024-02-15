package org.termdeposit;

public enum InterestPeriod {
    AT_MATURITY(1), MONTHLY(12), QUARTERLY(4), ANNUALLY(1), INVALID(0);
    private final int compoundPeriod;

    InterestPeriod(int compoundPeriod) {
        this.compoundPeriod = compoundPeriod;
    }

    public double getCompoundPeriod() {
        return this.compoundPeriod;
    }
}
