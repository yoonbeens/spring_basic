package com.spring.mywebspring.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
create table snsboard (
	bno int primary key auto_increment,
    writer varchar(50) not null,
    upload_path varchar(100) not null,
    file_loca varchar(100) not null,
    file_name varchar(50) not null,
    file_real_name varchar(50) not null,
    content varchar(2000),
    reg_date datetime default current_timestamp
);
 */


@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class SnsBoardVO {

	private int bno;
	private String writer;
	private String uploadPath;
	private String fileLoca;
	private String fileName;
	private String fileRealName;
	private String content;
	private LocalDateTime regDate;
	
}
