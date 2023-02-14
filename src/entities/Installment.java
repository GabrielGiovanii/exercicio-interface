package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Installment {
	private LocalDate dueDate;
	private Double amount;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	public Double getAmount() {
		return amount;
	}
	
	public String toString() {
		return dueDate.format(dtf) + " - " + String.format("%.2f", amount);
	}
}
