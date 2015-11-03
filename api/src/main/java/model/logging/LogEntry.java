package model.logging;

public class LogEntry {

	private Long id;
	
	private LogLevel level;
	
	private String message;
	
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
