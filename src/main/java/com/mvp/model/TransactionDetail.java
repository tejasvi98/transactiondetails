package com.mvp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="transaction")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TransactionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String userName;
	
	private String vendorName;
	
	private long transactionAmount;
	
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate transactionDate;
}
