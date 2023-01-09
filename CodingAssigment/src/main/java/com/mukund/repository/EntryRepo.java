package com.mukund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mukund.bean.Entry;

@Repository
public interface EntryRepo extends JpaRepository<Entry, Integer>{

}
