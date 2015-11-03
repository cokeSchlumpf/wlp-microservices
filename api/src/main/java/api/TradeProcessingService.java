package api;

import model.trade.Trade;

public interface TradeProcessingService {

	/**
	 * Starts a trade process.
	 * 
	 * @param trade The trade data from the outside world.
	 * @return
	 */
	public Trade create(Trade trade);
	
}
