package camel.beans;

import model.logging.LogEntry;
import model.logging.LogLevel;
import model.trade.Trade;

public class PrepareLogging {

	public LogEntry info(Trade trade) {
		return new LogEntry(LogLevel.INFO, "New Trade " + trade);
	}
	
}
