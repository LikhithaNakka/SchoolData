package com.SchoolData.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SchoolData.Entity.SchoolDataEntity;

@Repository
public interface SchollDataRepo extends JpaRepository<SchoolDataEntity, String>{
	
	@Query(nativeQuery = true ,
			value ="select school_id,school_name,school_type,school_org,no_of_stu,dist_name,cateret_name,payment_integration,sis_intration,\r\n"
					+ "				nutrition_analysis,city,state,country from school")
	List<Map<String,Object>> getSchoolData();

}
