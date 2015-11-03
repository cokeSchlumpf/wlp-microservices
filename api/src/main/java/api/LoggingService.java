package api;

import java.util.List;

import model.logging.LogEntry;

public interface LoggingService {

	/**
	 * Creates a new log entry in the log.
	 * 
	 * @param entry The entry to be created (without id).
	 * @return The created entry (with id).
	 */
	public LogEntry create(LogEntry entry);
	
	/**
	 * Get the list of stored log entries.
	 * @return The list of entries.
	 */
	public List<LogEntry> list();
	
}
