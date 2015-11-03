package camel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

@Startup
@Singleton
public class Camel {

	private CamelContext context;
	
	@PostConstruct
	public void init() {
		context = new DefaultCamelContext();
		try {
			context.addRoutes(new SampleRoute());
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void stop() {
		if (context != null) {
			try {
				context.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public CamelContext getContext() {
		return context;
	}
}
