package com.mvp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionDetailsApplicationTests {

	@Test
	void contextLoads() {
		String[] str = {"afda","adfas"};
		TransactionDetailsApplication.main(str);
	}

}
