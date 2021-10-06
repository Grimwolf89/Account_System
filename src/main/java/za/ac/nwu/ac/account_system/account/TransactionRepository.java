package za.ac.nwu.ac.account_system.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<AccountTransaction, Long> {

    List<AccountTransaction> findByMemberId(@Param("memberId") Long memberId);

    @Query("" +
            "SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE else FALSE END " +
            "FROM AccountTransaction s " +
            "WHERE s.memberId = ?1"
    )
    Boolean selectExistingMember(Long memberId);

   /* @Override
    public Optional<AccountTransaction> findById(Long memberId);
*/
    /*Boolean memberExists(@Param("memberId") Long memberId);*/

}
