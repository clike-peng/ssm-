package com.faceTest.dao.impl;

import com.faceTest.dao.PersonDao;
import com.faceTest.domain.Person;
import com.faceTest.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PersonDaoImpl implements PersonDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Person> findAll() {
        String sql="select * from  t_person";
        return template.query(sql, new BeanPropertyRowMapper<Person>(Person.class));
    }

    @Override
    public List<Person> findByNameAndIdCard(Map<String, String[]> condition) {
        StringBuffer sb = new StringBuffer();
        List list = new ArrayList<>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet){
            String[] value = condition.get(key);
            sb.append(" and "+key+" like ? ");
            list.add("%"+value[0]+"%");
        }
        String sql ="select * from t_person where 1 = 1 "+ sb.toString();
        System.out.println(sql);
        System.out.println(list);
        List<Person> query = template.query(sql, new BeanPropertyRowMapper<Person>(Person.class), list.toArray());
        return query;
    }
    @Override
    public int findPageCount() {
        //select count(*) from t_person ;
        String sql ="select count(*) from t_person ";
        Integer recordCount = template.queryForObject(sql, Integer.class);
        return recordCount;
    }





    @Override
    public void addPerson(Map<String, String[]> condition) {
        Set<String> keySet = condition.keySet();
        List list =new ArrayList();
        for (String key : keySet) {
            String[] value = condition.get(key);
            list.add(value[0]);
        }
        String sql=" insert into t_person values (null,?,?,?,?) " ;
        System.out.println(sql);
        System.out.println(list);
        template.update(sql,list.toArray());
    }

    @Override
    public int conditionQueryCount(Map<String, String[]> condition) {
        //select count(*)  from t_person where 1=1 and name = '% %'  and  idCard = '% %' ;
        StringBuffer sb = new StringBuffer();
        List list = new ArrayList<>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet){
            if (!"currentPage".equals(key) && !"row".equals(key)) {
                String[] value = condition.get(key);
                sb.append(" and " + key + " like  ?");
                list.add("%" + value[0] + "%");
            }
        }
        String sql ="select count(*) from t_person where 1 = 1 "+ sb.toString();
        System.out.println(sql);
        System.out.println(list);
        Integer recordCount = template.queryForObject(sql, Integer.class,list.toArray());
        System.out.println(recordCount);
        return recordCount;
    }

    @Override
    public List<Person> findByOnePage(Map<String, String[]> condition,int currentPage,int row) {
        int start = (currentPage - 1) * row;
        // select * from t_person where 1 = 1  and name like '%李%'  limit 0 5 ;
        StringBuffer sb = new StringBuffer();
        List list = new ArrayList<>();
        Set<String> keySet = condition.keySet();
        for (String key : keySet){
            if (!"currentPage".equals(key) && !"row".equals(key)){
                String[] value = condition.get(key);
                sb.append(" and "+key+" like ? ");
                list.add("%"+value[0]+"%");
            }
        }
        String sql ="select * from t_person where 1 = 1 "+ sb.toString()+" limit "+start + ","+row;
        System.out.println(start+"========"+row);
        System.out.println(sql);
        System.out.println(list);
        List<Person> query = template.query(sql, new BeanPropertyRowMapper<Person>(Person.class), list.toArray());
        return query;
    }

    @Override
    public void removePerson(int id){
        //delete from t_person where personId = ? ;
        String sql = " delete from t_person where personId = ? ";
        template.update(sql,id);
    }


}
