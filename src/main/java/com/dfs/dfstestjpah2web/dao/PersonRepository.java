package com.dfs.dfstestjpah2web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dfs.dfstestjpah2web.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
