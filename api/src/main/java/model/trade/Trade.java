package model.trade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "instrument" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Trade {

	@XmlElement(name = "id")
	private Long id;
	
	@XmlElement(name = "instrument", required = true)
	private String instrument;
	
	@SuppressWarnings("unused")
	private Trade() {
		
	}
	
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
