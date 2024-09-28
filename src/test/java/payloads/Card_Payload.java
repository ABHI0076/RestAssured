package payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card_Payload {

	private String idList;
	private String name;
	private String desc;
	private String id;
	
	public Card_Payload() {
		//Default Constructor.
	}
	
	// Constructor for POST Request.
	public Card_Payload(String idList,String name, String desc) {
		setIdList(idList);
		setName(name);
		setDesc(desc);
	}
	
	// Constructor for PUT Request.
	public Card_Payload(String name, String desc) {
		setName(name);
		setDesc(desc);
	}

	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

}
