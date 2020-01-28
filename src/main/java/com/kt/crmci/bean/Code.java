package com.kt.crmci.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Code {
	
	@Id
    private String _id;
	private String codeGroupId;
	private String codeCd;
	private String codeName;
}
