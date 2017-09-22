package jackson;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "properties" })
public class ExtendableBean {
	private String name;
	private final Map<String, String> properties;

	public ExtendableBean() {
		properties = new HashMap<String, String>();
	}

	// @JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	@JsonGetter("kiroName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addProperty(String name, String value) {
		properties.put(name, value);
	}
}
