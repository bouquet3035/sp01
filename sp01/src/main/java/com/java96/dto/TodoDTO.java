package com.java96.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@XmlRootElement
public class TodoDTO {

	private Long tno;
	private String title;
	private String writer;
	private Date regdate;
	private int replycnt;
}
