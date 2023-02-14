package services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double interest(Double amount, Integer months) {
		double valueInterest = amount * 0.01 * months;
		return valueInterest;
	}

	@Override
	public Double paymentFee(Double amount) {
		double valueFee = amount * 0.02;
		return valueFee;
	}

}
