package com.kt.crmci.biz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kt.crmci.bean.ChnLog;
import com.kt.crmci.bean.ChannelLogRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ChannelService {
	
	@Autowired
    private ChannelLogRepository channelLogRepository;

    // findCustomer
    // findCode
	
	public Page<ChnLog> findChannelHistory(String start, String end, String custId, String category, Pageable pageable) {
		return channelLogRepository.findByCreatedBetweenAndCustIdAndCategoryLctgNm(start, end, custId, category, pageable);		
	}
	
    public ChnLog findChannelHistoryDetail(String _id) {
        Optional<ChnLog> c = channelLogRepository.findById(_id);
        return c.get();
    }

    public void saveChannelLog(ChnLog body) {
        channelLogRepository.save(body);
        
        // sendChannelMessage (CI to Kafka)
        
    }
    
    // public void updateSendResult()
    // public void sendChannelMessage() -- CI to Kafka

}
