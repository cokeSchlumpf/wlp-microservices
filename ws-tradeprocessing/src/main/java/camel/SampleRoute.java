package camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import camel.beans.PrepareLogging;
import camel.beans.PrepareRest;
import ws.InternalLogs;

public class SampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:hello") //
				.bean(PrepareLogging.class, "info") //
				.multicast().parallelProcessing().to("direct:callBean", "direct:callHttp");

		from("direct:callBean") //
				.bean(InternalLogs.class, "create") //
				.to("log:SampleRoute[callBean]") //
				.bean(InternalLogs.class, "list") //
				.to("log:SampleRoute[callBean]");

		from("direct:callHttp") //
				.bean(PrepareRest.class) //
				.marshal().json(JsonLibrary.Jackson) //
				.to("log:SampleRoute[callHttp]") //
				.to("http://localhost:9080/ws-logging/api/logs") //
				.to("log:SampleRoute[callHttp]");
	}

}
