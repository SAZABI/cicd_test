package com.kt.crmci.biz;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kt.crmci.bean.ChannelLog;

@RestController
@RequestMapping(value = "/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ChannelController {
	
    private static final String FIND_CHANNEL_HIST        = "/findChannelHistory";
    private static final String FIND_CHANNEL_HIST_DETAIL = "/findChannelHistoryDetail";
    private static final String SAVE_CHANNEL_LOG         = "/saveChannelLog";

	private static final String FIND_CUSTOMER        = "/findCustomer";
    private static final String FIND_CODE            = "/findCode";
    private static final String UPDATE_SEND_RESULT   = "/updateSendResult";
    
    private ChannelService channelService;
    
    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }
    
    // findCustomer
    // findCode
    
    @GetMapping(value = FIND_CHANNEL_HIST)
    public Page<ChannelLog> findChannelHistory(@RequestParam String custId, 
    		                                   @RequestParam String start,
                                               @RequestParam String end,
                                               @RequestParam String category,
    		                                   Pageable pageable) {
    	System.out.println(custId);
    	System.out.println(start);
    	System.out.println(end);
    	System.out.println(category);
    	
        return channelService.findChannelHistory(start, end, custId, category, pageable);
    }
    
    @GetMapping(value = FIND_CHANNEL_HIST_DETAIL)
    public ChannelLog findChannelHistoryDetail(@RequestParam String _id) {
        return channelService.findChannelHistoryDetail(_id);
    }
    
    @PostMapping(value = SAVE_CHANNEL_LOG)
    public void saveChannelLog(@RequestBody ChannelLog body) {
        channelService.saveChannelLog(body);
    }
    
    // updateSendResult
    // sendChannelMessage (CI to Kafka)

}
