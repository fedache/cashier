package team.opay;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import lombok.val;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import team.opay.data.cashier.*;

import static com.google.common.truth.Truth.assertThat;

public class ApiClientTest {
    private Gson gson = new Gson();
    private static MockWebServer mockWebServer = new MockWebServer();
    private Api api;

    @BeforeClass
    public static void beforeClass() throws Exception {
        mockWebServer.start();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        mockWebServer.close();
    }

    @Before
    public void setUp() throws Exception {
        api = Api.newInstance(mockWebServer.url("/").toString(),"djdj", "jdj");
    }

    @SneakyThrows
    @Test
    public void initialize__Success() {
        String body = "{\n" +
                "\n" +
                "  \"code\": \"00000\",\n" +
                "  \"message\": \"SUCCESSFUL\",\n" +
                "  \"data\": {\n" +
                "    \"reference\": \"test_20191123132233\",\n" +
                "    \"orderNo\": \"20019212912901281821982\",\n" +
                "    \"cashierUrl\": \"https://cashier.operapay.com/api/cashierHome?data=xxxxxxxxxxxxxxxxx\",\n" +
                "    \"amount\": \"100\",\n" +
                "    \"currency\": \"NGN\",\n" +
                "    \"status\": \"INITIAL\"\n" +
                "  }\n" +
                "}\n";
        mockWebServer.enqueue(new MockResponse().setBody(body));
        val result = api.initialize(new InitRequest());
        val resultServer = gson.fromJson(body, new TypeToken<Result<InitResult>>() {}.getType());
        assertThat(result).isEqualTo(resultServer);
    }


    @SneakyThrows
    @Test
    public void status__Success() {
        String body = "{\n" +
                "    \"code\": \"00000\",\n" +
                "    \"message\": \"SUCCESSFUL\",\n" +
                "    \"data\": {\n" +
                "        \"orderNo\": \"200403148435239913\",\n" +
                "        \"reference\": \"test_2019112313233111011\",\n" +
                "        \"status\": \"INITIAL\",\n" +
                "        \"amount\": \"100\",\n" +
                "        \"currency\": \"NGN\"\n" +
                "    }\n" +
                "}\n";
        mockWebServer.enqueue(new MockResponse().setBody(body));
        val result = api.status(new StatusRequest());
        val resultServer = gson.fromJson(body, new TypeToken<Result<StatusResult>>() {}.getType());
        assertThat(result).isEqualTo(resultServer);
    }

    @SneakyThrows
    @Test
    public void close__Success() {
        String body = "{\n" +
                "    \"code\": \"00000\",\n" +
                "    \"message\": \"SUCCESSFUL\",\n" +
                "    \"data\": {\n" +
                "        \"orderNo\": \"200403148435239913\",\n" +
                "        \"reference\": \"test_2019112313233111011\",\n" +
                "        \"status\": \"INITIAL\",\n" +
                "        \"amount\": \"100\",\n" +
                "        \"currency\": \"NGN\"\n" +
                "    }\n" +
                "}\n";
        mockWebServer.enqueue(new MockResponse().setBody(body));
        val result = api.close(new StatusRequest());
        val resultServer = gson.fromJson(body, new TypeToken<Result<CloseResult>>() {}.getType());
        assertThat(result).isEqualTo(resultServer);
    }
}