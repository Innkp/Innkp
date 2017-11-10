package com.innkp.Innkp.dao;

import org.springframework.data.repository.CrudRepository;
import com.innkp.Innkp.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, Long> {

}
