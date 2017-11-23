package com.innkp.Innkp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.innkp.Innkp.dao.DepartmentDao;
import com.innkp.Innkp.dao.RoleDao;
import com.innkp.Innkp.dao.UserDao;
import com.innkp.Innkp.dao.VideoDao;
import com.innkp.Innkp.entity.Department;
import com.innkp.Innkp.entity.Role;
import com.innkp.Innkp.entity.User;
import com.innkp.Innkp.entity.VideoDo;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private VideoDao videoDao;

	public void initData() {
		videoDao.deleteAll();
		VideoDo v = new VideoDo();
		v.setCover("111");
		v.setName("222");
		v.setUrl("333");
		videoDao.save(v);
		System.out.println("loghere");
		// userDao.deleteAll();
		// departmentDao.deleteAll();
		// roleDao.deleteAll();

		// Department department = new Department();
		// department.setName("财务部");
		// department.setCreatedate(new Date());
		//
		// departmentDao.save(department);
		// Assert.notNull(department.getId(), "部门ID不能为空！");

		// Role role = new Role();
		// role.setName("管理员");
		// role.setCreatedate(new Date());
		//
		// roleDao.save(role);
		// Assert.notNull(role.getId(), "角色ID不能为空");
		//
		// User user = new User();
		// user.setName("管理员");
		// user.setLoginName("admin");
		//// user.setDepartment(department);
		// Iterable<Role> roles = roleDao.findAll();
		// List<Role> roleList = new ArrayList<Role>();
		// roles.forEach(single -> {
		// roleList.add(single);
		// });
		// Assert.notNull(roleList, "角色列表不能为空！");
		// user.setRoleList(roleList);
		// user.setPassword("admin123");
		//
		// userDao.save(user);
		// Assert.notNull(user.getId(), "用户ID不能为空！");
	}
}
