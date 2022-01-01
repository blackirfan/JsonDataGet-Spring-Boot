package com.example.jsonsavedemo.Repository;

import com.example.jsonsavedemo.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParentRepo extends JpaRepository<Parent, Integer> {

    @Query(value="SELECT * FROM parents", nativeQuery = true)
    public List<Parent> getAll();

    @Query(value="SELECT * FROM parents where bio ->> 'text' = :text", nativeQuery = true)
    public List<Parent> getAllBioByText(@Param("text") String text);

    @Query(value="select * from parents where 'children' @> '[{\"age\": :age}]'", nativeQuery = true)
    public List<Parent> getAllChildrenByAge(@Param("age") String age);

    @Query(value="select * from parents where 'children' @> '[{\"name\": :name}]'", nativeQuery = true)
    public List<Parent> getAllChildrenByName(@Param("name") String name);



}