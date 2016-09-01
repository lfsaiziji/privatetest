package org.icesure.privatetest.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionEntity {
	public SessionEntity() {
		// TODO Auto-generated constructor stub
	}
	
	private int id;
	private String petName;
}
