package com.burakexample.jpa.repositories;

import com.burakexample.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    //update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id ")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthorsAges(int age);


    //SELECT * FROM AUTHOR WHERE FIRST_NAME = ''
    List<Author> findAllByFirstName(String firstName);

    //SELECT * FROM AUTHOR WHERE FIRST_NAME = 'al'

    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    //SELECT * FROM AUTHOR WHERE FIRST_NAME like '%al%'

    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    //SELECT * FROM AUTHOR WHERE FIRST_NAME like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    //SELECT * FROM AUTHOR WHERE FIRST_NAME like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    //SELECT * FROM AUTHOR WHERE FIRST_NAME in('ali','burak','cevizli')

    List<Author>findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
