package org.sample.web.account;

import org.sample.domain.account.Account;
import org.springframework.stereotype.Controller;

@Controller
public interface AccountController {
	
	Account getAccount(Long accountID);
	Account createAccount(Account account);
	Account updateAccount(Account account);
	void deleteAccount(Account account);
	
}
