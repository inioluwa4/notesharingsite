package com.notesharing.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "chatter")

public class Chatter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatter")
	@SequenceGenerator(name = "chatter", sequenceName = "chatter_seq", allocationSize = 1)
	@Column(name = "chat_id")
	private int id;
	private int reciever; 
	private int sender;
	@Column(name = "chat_timestamp")
	private Timestamp timestamp;
	private String message;
	@Column(name = "read_reciept")
	private String read;
	
	
	
	public Chatter() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Chatter(int id, int reciever, int sender, Timestamp timestamp, String message, String read) {
		super();
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.timestamp = timestamp;
		this.message = message;
		this.read = read;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public Timestamp getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getRead() {
		return read;
	}



	public void setRead(String read) {
		this.read = read;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + reciever;
		result = prime * result + sender;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chatter other = (Chatter) obj;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (reciever != other.reciever)
			return false;
		if (sender != other.sender)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Chatter [id=" + id + ", reciever=" + reciever + ", sender=" + sender + ", timestamp=" + timestamp
				+ ", message=" + message + ", read=" + read + "]";
	}
	
	

	
	
	
	

	
	
}
