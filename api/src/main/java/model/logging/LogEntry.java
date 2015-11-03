package model.logging;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "level", "message" })
@XmlAccessorType(XmlAccessType.FIELD)
public class LogEntry {

	@XmlElement(name = "id")
	private Long id;
	
	@XmlElement(name = "level", required = true)
	private LogLevel level;
	
	@XmlElement(name = "message", required = true)
	private String message;
	
	@SuppressWarnings("unused")
	private LogEntry() {
		
	}
	
	public LogEntry(Long id, LogLevel level, String message) {
		this.id = id;
		this.level = level;
		this.message = message;
	}
	
	public LogEntry(LogLevel level, String message) {
		this(null, level, message);
	}
	
	public Long getId() {
		return id;
	}
	
	public LogLevel getLevel() {
		return level;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLevel(LogLevel level) {
		this.level = level;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LogEntry [id=" + id + ", level=" + level + ", message=" + message + "]";
	}
	
}
