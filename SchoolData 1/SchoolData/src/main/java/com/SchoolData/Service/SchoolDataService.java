package com.SchoolData.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface SchoolDataService {

	ResponseEntity<?> getSchoolData();

	ResponseEntity<?> getData(String school_ID);

}
