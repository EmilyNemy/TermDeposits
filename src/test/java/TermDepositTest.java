import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.termdeposit.InterestPeriod;
import org.termdeposit.TermDeposit;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TermDepositTest {
    @Test
    public void testInterestAtMaturity(){
        TermDeposit termdeposit = new TermDeposit(10000,1.10, 3);
        Assertions.assertEquals(330.00, Math.round(termdeposit.calculateInterest(InterestPeriod.AT_MATURITY)));
    }

    @Test
    public void testInterestAnnually(){
        TermDeposit termdeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(334.00, Math.round(termdeposit.calculateInterest( InterestPeriod.ANNUALLY)));
    }

    @Test
    public void testInterestQuarterly(){
        TermDeposit termdeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(335.00, Math.round(termdeposit.calculateInterest( InterestPeriod.QUARTERLY)));
    }

    @Test
    public void testInterestMonthly(){
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(335, Math.round(termDeposit.calculateInterest( InterestPeriod.MONTHLY)));
    }

    @Test
    public void testInvalidInterestPeriod(){
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 3);
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> termDeposit.calculateInterest( InterestPeriod.INVALID));
        Assertions.assertEquals("Invalid interest Period: INVALID", exception.getMessage());
    }

    @Test
    public void testCompoundInterest(){
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(10330.00, termDeposit.getCompoundInterest(InterestPeriod.AT_MATURITY));
    }

}