package ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.logging.LogEntry;
import model.logging.LogLevel;

@Stateless
@Path("logs")
public class Logs implements api.LoggingService {

	private static final List<LogEntry> log = new ArrayList<>();
	
	@POST
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LogEntry create(LogEntry entry) {
		LogEntry result = new LogEntry(Long.valueOf(log.size() + 1), entry.getLevel(), entry.getMessage());
		log.add(result);
		return result;
	}
	
	@GET
	@Path("example")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.WILDCARD)
	public LogEntry example() {
		return new LogEntry(LogLevel.INFO, "Lorem ipsum dolor sit amet del arem.");
	}

	@GET
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.WILDCARD)
	public List<LogEntry> list() {
		return log;
	}

}
