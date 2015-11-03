package ws;

import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.ProducerTemplate;

import api.TradeProcessingService;
import camel.Camel;
import model.trade.Trade;

@Stateless
@Path("trades")
public class Trades implements TradeProcessingService {
	
	@EJB Camel camel;
	
	@POST
	@Override
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Trade create(Trade trade) {
		ProducerTemplate template = camel.getContext().createProducerTemplate();
		template.sendBody("direct:hello", trade);
		
		Trade result = new Trade(Long.valueOf(UUID.randomUUID().hashCode()), trade.getInstrument());
		return result;
	}
	
	@GET
	@Path("example")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.WILDCARD)
	public Trade example() {
		return new Trade(1L, "foo");
	}

}
