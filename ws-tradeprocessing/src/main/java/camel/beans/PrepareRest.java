package camel.beans;

import org.apache.camel.Exchange;

public class PrepareRest {

	public void setHeaders(Exchange exchange) {
		exchange.getIn().setHeader(Exchange.HTTP_METHOD, "POST");
		exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
	}

}
