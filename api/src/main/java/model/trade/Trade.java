package model.trade;

public class Trade {

	private Long id;
	
	private String instrument;
	
	public Trade(Long id, String instrument) {
		this.id = id;
		this.instrument = instrument;
	}
	
	public Trade(String instrument) {
		this(null, instrument);
	}
	
	public Long getId() {
		return id;
	}
	
	public String getInstrument() {
		return instrument;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public String toString() {
		return "Trade [id=" + id + ", instrument=" + instrument + "]";
	}
	
}
