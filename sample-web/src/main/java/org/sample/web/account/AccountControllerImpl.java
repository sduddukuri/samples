package org.sample.web.account;

import org.sample.domain.account.Account;
import org.sample.domain.account.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountControllerImpl implements AccountController {

	@Autowired
	AccountDao accountDao;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody  Account getAccount(@RequestParam(value="accountNo", required=true) Long accountNo) {
		 Authentication a = SecurityContextHolder.getContext().getAuthentication();
		    UserDetails currentUserDetails = (UserDetails) a.getPrincipal();
		    if(currentUserDetails!=null) {
		    	System.out.println("username: "+ currentUserDetails.getUsername()+ " password:" +  currentUserDetails.getPassword());
		    }
		return accountDao.findOne(accountNo);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Account createAccount(Account account) {
		Model model = new ExtendedModelMap();
		accountDao.save(account);
		model.addAttribute(account);
		return account;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Account updateAccount(Account account) {
		return accountDao.save(account);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deleteAccount(Account account) {
		 accountDao.delete(account);
	}
}
