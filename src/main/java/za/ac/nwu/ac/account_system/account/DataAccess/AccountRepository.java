package za.ac.nwu.ac.account_system.account.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountType;

@Repository
public interface AccountRepository extends JpaRepository<AccountType, Long> {

   /* @Query("SELECT a FROM AccountTransaction a WHERE a.memberId = ?1")
    Optional<AccountTransaction> findMemberAccount(Long memberId);*/

}

