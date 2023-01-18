package com.mvp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvp.model.TransactionDetail;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionDetail, String>{

	
	public List<TransactionDetail> findByUserName(String username);
}
