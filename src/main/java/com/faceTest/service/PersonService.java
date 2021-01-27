package com.faceTest.service;

import com.faceTest.domain.PageBean;
import com.faceTest.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    public List<Person> findAll();
    List<Person> findByNameAndIdCard(Map<String, String[]> parameterMap);
    public PageBean findByPage (Map<String, String[]> condition,String currentPage,String row);



    void addPerson(Map<String, String[]> parameterMap);
    public PageBean conditionQueryCount(Map<String, String[]> condition,String currentPage,String row);

    public void removePerson(String id);
    public void delSelect(String[] ids);
}
