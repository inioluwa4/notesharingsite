package com.notesharing.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comments")

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments")
	@SequenceGenerator(name = "comments", sequenceName = "comments_seq", allocationSize = 1)
	@Column(name = "comment_id")
	private Integer commentsId;
	@Column(name = "reciever")
	private int reciever; 
	@Column(name = "sender")
	private int sender;
	@Column(name = "timestamp")
	private Date timestamp;
	@Column(name = "cmmnt")
	private String cmmnt;
	
	public Comment() {
		super();
	}

	public Comment(Integer commentsId) {
		super();
		this.commentsId = commentsId;
	}

	public Comment(Integer commentsId, int reciever, int sender, Date timestamp, String cmmnt) {
		super();
		this.commentsId = commentsId;
		this.reciever = reciever;
		this.sender = sender;
		this.timestamp = timestamp;
		this.cmmnt = cmmnt;
	}

	public Integer getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(Integer commentsId) {
		this.commentsId = commentsId;
	}

	public int getReciever() {
		return reciever;
	}

	public void setReciever(int reciever) {
		this.reciever = reciever;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCmmnt() {
		return cmmnt;
	}

	public void setCmmnt(String cmmnt) {
		this.cmmnt = cmmnt;
	}

	@Override
	public String toString() {
		return "Comment [commentsId=" + commentsId + ", reciever=" + reciever + ", sender=" + sender + ", timestamp="
				+ timestamp + ", cmmnt=" + cmmnt + "]";
	}
	
	
	
	
}
