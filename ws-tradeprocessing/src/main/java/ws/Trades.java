package ws;

import java.util.UUID;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import api.TradeProcessingService;
import model.trade.Trade;

@Stateless
@Path("trades")
public class Trades implements TradeProcessingService {
	
	@POST
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Trade create(Trade trade) {
		Trade result = new Trade(Long.valueOf(UUID.randomUUID().hashCode()), trade.getInstrument());
		return result;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.WILDCARD)
	public Trade example() {
		return new Trade(1L, "foo");
	}

}
