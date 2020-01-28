package com.kt.crmci.bean;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelLogRepository extends MongoRepository<ChannelLog, String> {
	
	Page<ChannelLog> findAll(Pageable pageable);
	
	Page<ChannelLog> findByCustId(String custId, Pageable pageable);
	
	Page<ChannelLog> findByCategoryLctgNm(String categoryLctgNm, Pageable pageable);
	
	Page<ChannelLog> findByCustIdAndCategoryLctgNm(String custId, String categoryLctgNm, Pageable pageable);
	
	Page<ChannelLog> findByCreatedBetween(String start, String end, Pageable pageable);
	
	Page<ChannelLog> findByCreatedBetweenAndCustId(String start, String end, String custId, Pageable pageable);
	
	Page<ChannelLog> findByCreatedBetweenAndCustIdAndCategoryLctgNm(String startTime, String endTime, String custId, String categoryLctgNm, Pageable pageable);
	
}
