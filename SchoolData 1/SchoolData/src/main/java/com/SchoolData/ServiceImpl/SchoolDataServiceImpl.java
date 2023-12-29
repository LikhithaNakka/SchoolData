package com.SchoolData.ServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SchoolData.Repository.SchollDataRepo;
import com.SchoolData.Service.SchoolDataService;

import jakarta.persistence.EntityManager;

//import com.SchoolData.Service.SchoolDataService;

@SuppressWarnings("deprecation")
@Service
public class SchoolDataServiceImpl implements SchoolDataService{

	
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	SchollDataRepo repository;
	
	public ResponseEntity<?> getSchoolData() {
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		
		
		List<Map<String, Object>> res = repository.getSchoolData();
		try {
			System.out.println("hii");
			
	//		List<Map<String, Object>> res = repo.getmisreportabstractupdated();
			System.out.println(res);
			System.err.println(res.size());
			if (res.size() > 0) {
				resp.put("scode","01");
				resp.put("message", res);
			} else {
				resp.put("scode","02");
				resp.put("message", "No Data Found");
			}

		} catch (Exception e) {
			resp.put("scode", "04");
			resp.put("message", "DATA NOT AVAILABLE. REASONS: SERVER ERROR!!!");
			e.printStackTrace();

		}
	
		return ResponseEntity.ok(resp);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity<?> getData(String school_ID) {
		Map<String,Object>resp=new LinkedHashMap<String, Object>();
		try {
		Session session= entityManager.unwrap(Session.class);
		
		String sql="";
		
		 sql="select stripe_ac_id,stripe_cus_id,appln_fee_on,appln_fee, contacts,admin_name,email,"
				+ "phone,sis_name where school_id='"+school_ID+"' ";
		
		System.out.println("sql:::"+sql);
		NativeQuery<?>nativeQuery=session.createNativeQuery(sql);
		nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String,Object>> result=(List<Map<String,Object>>)nativeQuery.list();
		
		if(result.size()==0) {
			resp.put("scode", "02");
			resp.put("message", result);
		}else {
			resp.put("scode", "01");
			resp.put("message", result);
		}
		}catch (Exception e) {
			resp.put("scode", "03");
			resp.put("message", "DATA NOT AVAILABLE. REASONS: SERVER ERROR!!!");
			e.printStackTrace();
		}
		
		
		return ResponseEntity.ok(resp);
	}

	    
}
