package httpclient;

import java.io.IOException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	private static final String URL = "https://cscapj.accounts.ondemand.com/service/scim/Users/";

	public static void main(String[] args) {
		System.setProperty("javax.net.debug", "all");
		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		// credentialsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
		// new UsernamePasswordCredentials("P000366", "Abcd1234"));
		credentialsProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
				new UsernamePasswordCredentials("T000071", "Abcd1234"));
		HttpClientContext context = new HttpClientContext();
		CloseableHttpClient client = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();
		HttpGet get = new HttpGet(URL);
		try (CloseableHttpResponse response = client.execute(get, context)) {

			System.out.println(response.getStatusLine());
			System.out.println(EntityUtils.toString(response.getEntity()));
			AuthState proxyAuthState = context.getProxyAuthState();
			System.out.println("Proxy auth state: " + proxyAuthState.getState());
			System.out.println("Proxy auth scheme: " + proxyAuthState.getAuthScheme());
			System.out.println("Proxy auth credentials: " + proxyAuthState.getCredentials());
			AuthState targetAuthState = context.getTargetAuthState();
			System.out.println("Target auth state: " + targetAuthState.getState());
			System.out.println("Target auth scheme: " + targetAuthState.getAuthScheme());
			System.out.println("Target auth credentials: " + targetAuthState.getCredentials());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
