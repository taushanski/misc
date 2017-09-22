package jackson;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendableBeanTest {

	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
		ExtendableBean bean = new ExtendableBean();
		bean.setName("Dummy");
		bean.addProperty("Prop1", "Prop1Value");
		bean.addProperty("Prop2", "Prop2Value");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
		assertTrue(result.contains("Prop1"));
		assertTrue(result.contains("Prop2"));

	}

	@Test
	public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {

		RawBean bean = new RawBean("My bean", "{\"attr\":false}");

		String result = new ObjectMapper().writeValueAsString(bean);
		System.out.println(result);
		// assertThat(result, containsString("My bean"));
		// assertThat(result, containsString("{"attr":false}"));
	}

}
