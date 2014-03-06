package org.sample.domain.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account, Long> {

}
