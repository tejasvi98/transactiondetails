package com.mvp.model;

import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TransactionDetailDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String userName;
	
	private String vendorName;
	
	private long transactionAmount;
	
//	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDate transactionDate;
}
