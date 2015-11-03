package camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import camel.beans.PrepareLogging;
import camel.beans.PrepareRest;

public class SampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:hello") //
				.bean(PrepareLogging.class, "info") //
				.bean(PrepareRest.class) // 
				.marshal().json(JsonLibrary.Jackson) //
				.to("log:SampleRoute?showAll=true")
				.to("http://localhost:9080/ws-logging/api/logs");
	}

}
