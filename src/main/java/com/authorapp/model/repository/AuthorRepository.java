package com.authorapp.model.repository;

import com.authorapp.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Olesiiuk Yaroslav aka Jay.
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {








}
