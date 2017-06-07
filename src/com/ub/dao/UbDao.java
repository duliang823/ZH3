package com.ub.dao;
import java.util.List;

import com.ub.beans.Sensor;
import com.ub.beans.Ub;
import com.ub.beans.Ub1;
import com.ub.beans.Ub2;
import com.ub.beans.Ub3;
public interface UbDao {

/*
		//查询单笔调查
	    public Ub query(Ub ub);
		//查询多笔数据
	    public List queryList();
		//删除数据
	    public void delete(Ub ub) ;
		//修改调查
	    public void update(Ub ub) ;
		//新增ub格式数据
	
 */
	    public boolean insertUb(Ub ub);
	   //新增ub1格式数据
	  
	    public boolean insertUb1(Ub1 ub1);
	    
		//新增ub2格式数据 
	    public boolean insertUb2(Ub2 ub2);
	    
	    public boolean insertUb3(Ub3 ub3);
	    
	    public boolean insertSensor(Sensor s);
	    
	}

	
