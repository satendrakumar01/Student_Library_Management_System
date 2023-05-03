package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repository.BookRepository;
import com.example.Student_Library_Management_System.Repository.CardRepository;
import com.example.Student_Library_Management_System.Repository.TransactionRepository;
import jakarta.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {


    @Autowired
    TransactionRepository transactionRepository;


    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;
    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{


        int bookId= issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();



        
//        Get the book and the card entity ?? why do we really need this ans: because need  to set its  transaction attributes


        Book book=bookRepository.findById(bookId).get();


        Card card=cardRepository.findById(cardId).get();


//        final goal is to make the transactional entity sets its attribute and save it

        Transactions transaction=new Transactions();


//        Setting the attributes

        transaction.setBook(book);
        transaction.setCard(card);

        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);

        transaction.setTransactionStatus(TransactionStatus.PENDING);


        if(book==null || book.isIssued()==true){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");



        }
        if(card==null || (card.getCardStatus()!=CardStatus.ACTIVATED)){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw   new Exception("Card is not valid");


        }
//      we have reached the success case
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

//        set the attributes of book
                book.setIssued(true);
//        btw the book and transaction is bidirectional
                List<Transactions>listOfTrasactionForBook=book.getListOfTransactions();
        listOfTrasactionForBook.add(transaction);
        book.setListOfTransactions(listOfTrasactionForBook);



//        I need to made changes in the card
//        Book and the card
        List<Book>issuedBooksForCard=card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);


//      card and transaction: bidirectional(parent class)
        List<Transactions> transactionsListForCard=card.getTransactionsList();
        transactionsListForCard.add(transaction);

        card.setTransactionsList(transactionsListForCard);

//        save the parent
        cardRepository.save(card);
//        automattically by cascasding book and transction will be save if we are saving the parent

        return "Book Issued Successfully";





//        attribute left  is success/failure
//        Check for the validations




//        Do some validantions and set the forgin keys biderctional settings

//        save the parent





    }

    public String getTransactions(int bookId, int cardId){

        List<Transactions>transactionsList=transactionRepository.getTransactionForBookAndCard(bookId,cardId);

        String transactionId=transactionsList.get(0).getTransactionId();

        return transactionId;
    }
}
