package com.example.Student_Library_Management_System.Repository;


import com.example.Student_Library_Management_System.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {


    @Query(value = "select * from transactions t where t.book_id=:bookId and t.card_id=:cardId and is_issue_operation=true", nativeQuery = true)
    List <Transactions> getTransactionForBookAndCard(int bookId, int cardId);

}
