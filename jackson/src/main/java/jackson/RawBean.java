package jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RawBean {
	public RawBean(String string, String string2) {
		name = string;
		json = string2;
	}

	private final String name;

	@JsonRawValue
	public String json;
}