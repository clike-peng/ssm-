package com.faceTest.service.impl;

import com.faceTest.dao.PersonDao;
import com.faceTest.dao.impl.PersonDaoImpl;
import com.faceTest.domain.PageBean;
import com.faceTest.domain.Person;
import com.faceTest.service.PersonService;

import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }
    @Override
    public List<Person> findByNameAndIdCard(Map<String, String[]> condition) {
        return personDao.findByNameAndIdCard(condition);
    }
    @Override
    public PageBean findByPage(Map<String, String[]> condition,String _currentPage,String _row) {
        //总记录条数 recordCount
        int recordCount = personDao.findPageCount();

        //页面总数 pageCount  recordCount/row
        int currentPage = Integer.parseInt(_currentPage);
        int row = Integer.parseInt(_row);
        int pageCount = recordCount % row ==0  ? recordCount / row : recordCount / row +1;
        if (currentPage < 1) {
            currentPage=1;
        }
        if (currentPage > pageCount){
            currentPage = pageCount;
        }

        //page每页的记录
        List<Person> byOnePage = personDao.findByOnePage(condition, currentPage, row);
        System.out.println(byOnePage);

        PageBean pageBean = new PageBean();
        pageBean.setRecordCount(recordCount);
        pageBean.setPageCount(pageCount);
        pageBean.setPage(byOnePage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(row);

        return pageBean;
    }





    @Override
    public void addPerson(Map<String, String[]> parameterMap) {
        personDao.addPerson(parameterMap);
    }
    @Override
    public PageBean conditionQueryCount(Map<String, String[]> condition,String _currentPage,String _row) {
        //总记录条数 recordCount
        int recordCount = personDao.conditionQueryCount(condition);

        //页面总数 pageCount  recordCount/row
        int currentPage = Integer.parseInt(_currentPage);
        int row = Integer.parseInt(_row);

        int pageCount = recordCount % row ==0  ? recordCount / row : recordCount / row +1;

        if (currentPage < 1) {
            currentPage=1;
        }
        if (currentPage > pageCount){
            currentPage = pageCount;
        }
        //page每页的记录
        List<Person> byOnePage = personDao.findByOnePage(condition, currentPage, row);
        System.out.println(byOnePage);

        PageBean pageBean = new PageBean();
        pageBean.setRecordCount(recordCount);
        pageBean.setPageCount(pageCount);
        pageBean.setPage(byOnePage);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(row);

        return pageBean;
    }

    @Override
    public void removePerson(String  personId) {
        int id = Integer.parseInt(personId);
        personDao.removePerson(id);
    }

    @Override
    public void delSelect(String[] ids) {
        for (String id : ids) {
                personDao.removePerson(Integer.parseInt(id));
        }
    }


}
