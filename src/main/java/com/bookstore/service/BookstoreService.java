package com.bookstore.service;

import com.bookstore.mysql.repository.TodoRepository;
import com.bookstore.repository.TopicRepository;
import com.bookstore.entity.Author;
import com.bookstore.entity.Customer;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//import com.bookstore.repository.RatecardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

//    public BookstoreService(AuthorRepository authorRepository) {
//        this.authorRepository = authorRepository;
//    }

//    @Autowired
//    private //final
//            AuthorRepository authorRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TopicRepository topicRepository;


//    private List<Author> batchOf1k = new ArrayList<>();
    private List<Customer> batchOf1k = new ArrayList<>();
    int counter = 0;




    public void populateDatabase(int numRows) {
        LocalTime sooner = LocalTime.now();
        List<Author> authors = new ArrayList<>();

        for (long i = 0; i < numRows; i++) {
            Author author = new Author();
            author.setName("Author_" + i);
            author.setGenre("Genre_" + i);
            author.setAge((int) (Math.random() * 100));

            authors.add(author);
        }

//        authorRepository.saveAll(authors);
//        todoRepository.saveAll(authors);
        LocalTime later = LocalTime.now();
        Duration duration = Duration.between ( sooner, later );
        System.out.println("******* " + "Total time ofr INSERT: " + duration.getSeconds() + " seconds" );
    }


//    @Transactional(readOnly = true)
    @Transactional(transactionManager="todosTransactionManager", readOnly = true)
    public void streamDatabase() {

        long startTime = System.nanoTime();
//        List<Author> batchOf1k = new ArrayList<>();
        LocalTime sooner = LocalTime.now();


        //try-with-resources
        //hfv 3: I commented on 26mrch2023 for POC
//        try ( Stream<RatecardEO> authorStream = ratecardRepository.streamAllRatecards()) {
//        try ( Stream<Author> authorStream = authorRepository.streamAll()) {
        try ( Stream<Author> authorStream = todoRepository.streamAll()) {
            System.out.println("******* " + "counter = " + counter++);

            authorStream.forEach(
                    a -> {
                            addAndIndex_2(a);
//                    ratecard -> {
//                        counter++;
////                        System.out.println(counter);
//                        if (counter % 50_000 == 0) {
//                            System.out.println("rownum = " + counter++);
////                            System.out.println(ratecard);
//                        }
                    }
            );
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());//, e);
            throw new RuntimeException("Exception occurred while exporting results", e);
        }

        LocalTime later = LocalTime.now();
        //A Duration represents a span of time it terms of a count of seconds plus nanoseconds.
        Duration duration = Duration.between ( sooner, later );
        System.out.println("******* " + "Total time: " + duration.getSeconds() + " seconds" );
        System.out.println(" last batch.size: " + batchOf1k.size());
    }




    @Transactional(transactionManager="topicsTransactionManager")
    public void addAndIndex_2(Author a//, int counter) {
                                      ) {
//        System.out.println("addToBatchListAndSaveAll() "+counter++);// + counter);
        //map to destiny entity
        Customer customer1 = new Customer();
        customer1.setName(a.getName());
        customer1.setSurname(a.getGenre());
        customer1.setEmail("hector.felix@oracle.com");
        customer1.setDepartment("SPA and Cloud Dash Senior Developer and DevOps");
        customer1.setSalary(Long.valueOf(a.getAge()));
        batchOf1k.add(customer1);

        if ((batchOf1k.size() % 10_000) == 0) {
//            System.out.println("inserts in bulk" + " batch: " + batchOf1k.size());
            System.out.println("inserting a customer BATCH to postgres!");
            topicRepository.saveAll(batchOf1k);
            //re-set batch
            batchOf1k.clear();
        }
    }


    @Transactional(transactionManager="topicsTransactionManager")
    public void insert2Postgres() {
        /////////////////////////
        System.out.println("inserting a customer1 to postgres!");
        Customer customer1 = new Customer();
        customer1.setName("Ambar");
        customer1.setSurname("Felix");
        customer1.setEmail("hector.felix@oracle.com");
        customer1.setDepartment("SPA and Cloud Dash Senior Developer and DevOps");
        customer1.setSalary(7_777L);
        topicRepository.save(customer1);
    }
}
