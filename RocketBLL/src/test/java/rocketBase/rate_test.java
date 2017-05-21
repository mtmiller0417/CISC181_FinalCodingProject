package rocketBase;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test 
{
	
	RateDomainModel r1 =  new RateDomainModel(); 
	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	
	@Test
	public void PaymentTest() throws RateException
	{
		double r = .04;
		int n = 30*12;
		double p = 300000;
		double f = 0;
		boolean t = false;
		double answer = RateBLL.getPayment(r, n, p, f, t);
		System.out.println("google1 " + RateBLL.getRate(720) );
		System.out.println("google " + answer + "\n" + RateBLL.getRate(600));
		assertEquals(answer, 1432.25, .01);		
	}

	@Test(expected = RateException.class)
	public void TestRateException() throws RateException
	{
		int creditScore = 400;
		RateBLL.getRate(creditScore);
		double rate = 0;
		boolean check = true;
		try
		{
			rate = RateBLL.getRate(500);
		}
		catch(RateException e)
		{
			check = false;
			System.out.println("CREDITSCORE SHOULD BE TOO LOW HERE");
			System.out.println("This credit score is too low to apply for a loan here. Sorry!");
		}
		if(check)
		{
			assertTrue(rate > 7 );
		}
		else if(!check)
		{
			assertTrue(rate < 7);
		}
		
	}
	
}
