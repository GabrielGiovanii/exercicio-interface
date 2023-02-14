package services;

import java.time.LocalDate;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double valueInstallment = contract.getTotalValue() / months;
			double valueInterest = onlinePaymentService.interest(valueInstallment, i);
			double valuePaymentFee = onlinePaymentService.paymentFee(valueInstallment + valueInterest);
			double totalInstallment = valueInstallment + valueInterest + valuePaymentFee;
			
			contract.getInstallments().add(new Installment(dueDate, totalInstallment));
		}
	}
}
