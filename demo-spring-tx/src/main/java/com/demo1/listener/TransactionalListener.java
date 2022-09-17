package com.demo1.listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author Yuan
 * @description TransactionalListener
 * @date 2022/9/17
 */
@Component
public class TransactionalListener {

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handler(String transactionEvent) {
		System.out.println("handler: " + transactionEvent);
	}
}
