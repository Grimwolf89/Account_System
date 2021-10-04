package za.ac.nwu.ac.account_system.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {

   /* @Query("SELECT a FROM AccountTransaction a WHERE a.memberId = ?1")
    Optional<AccountTransaction> findMemberAccount(Long memberId);*/



}
