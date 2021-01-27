package com.faceTest.dao;

import com.faceTest.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    /**
     * 查询所有
     * @return
     */
    public List<Person> findAll();
    /**
     * 条件查询
     */
    List<Person> findByNameAndIdCard(Map<String, String[]> condition);
    int findPageCount();






    /**
     * 新添person
     */
    public void addPerson(Map<String, String[]> parameterMap);
    /**
     * 条件查询的条数
     */
    public int conditionQueryCount(Map<String, String[]> condition);
    /**
     * 查询每一页
     */
    public List<Person> findByOnePage(Map<String, String[]> condition,int currentPage,int row);

    /**
     * 删除person
     * @param id
     */
    public void removePerson(int id);
}

