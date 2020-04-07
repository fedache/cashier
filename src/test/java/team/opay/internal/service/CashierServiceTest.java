package team.opay.internal.service;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import retrofit2.Retrofit;
import team.opay.data.cashier.*;
import team.opay.internal.DefaultApi;
import team.opay.internal.config.AppProperties;
import team.opay.internal.config.RetrofitInstance;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import static com.google.common.truth.Truth.assertThat;

@Ignore
public class CashierServiceTest {
    private CashierService service;
    private Gson gson = new Gson();

    @Before
    public void setUp() {
        Properties properties = AppProperties.getInstance();
        String baseUrl = properties.getProperty("base.url");
        String merchantId = properties.getProperty("merchant.id");
        String authorization = properties.getProperty("authorization");

        Retrofit retrofit = RetrofitInstance.getInstance(baseUrl, DefaultApi.getCommonHeaders(merchantId, authorization));
        service = retrofit.create(CashierService.class);
    }

    /**
     * Change reference here to avoid duplicate reference error
     */
    @SneakyThrows
    @Test
    public void initialize__Success() {
        String reference = String.format("ref-%d-%d", new Date().getTime(), new Random().nextInt());
        InitRequest request = gson.fromJson("{\n" +
                "  \"reference\": \"" + reference + "\",\n" +
                "  \"mchShortName\": \"Jerry's shop\", \n" +
                "  \"productName\": \"Apple AirPods Pro\",\n" +
                "  \"productDesc\": \"The best wireless earphone in history\",\n" +
                "  \"userPhone\": \"+2349876543210\",\n" +
                "  \"userRequestIp\": \"123.123.123.123\",\n" +
                "  \"amount\": \"100\",\n" +
                "  \"currency\": \"NGN\",\n" +
                "  \"payTypes\":[\n" +
                "    \"BalancePayment\",\n" +
                "    \"BonusPayment\"\n" +
                "  ],\n" +
                "  \"payMethods\":[\n" +
                "    \"account\",\n" +
                "    \"qrcode\"\n" +
                "  ],\n" +
                "  \"callbackUrl\": \"https://you.domain.com/callbackUrl\",\n" +
                "  \"returnUrl\": \"https://you.domain.com/returnUrl\",\n" +
                "  \"expireAt\": \"10\"\n" +
                "}", InitRequest.class);
        val resultResponse = service.initialize(request).execute();
        Result<InitResult> cashierResult = resultResponse.body();
        assertThat(cashierResult.getCode()).isEqualTo("00000");
        assertThat(cashierResult.getMessage()).isEqualTo("SUCCESSFUL");
        assertThat(cashierResult.getData().getStatus()).isEqualTo(Status.SUCCESS);
    }

    @SneakyThrows
    @Test
    public void initialize__DuplicateReference() {
        InitRequest cashierRequest = gson.fromJson("{\n" +
                "  \"reference\": \"test_20191123132233\",\n" +
                "  \"mchShortName\": \"Jerry's shop\", \n" +
                "  \"productName\": \"Apple AirPods Pro\",\n" +
                "  \"productDesc\": \"The best wireless earphone in history\",\n" +
                "  \"userPhone\": \"+2349876543210\",\n" +
                "  \"userRequestIp\": \"123.123.123.123\",\n" +
                "  \"amount\": \"100\",\n" +
                "  \"currency\": \"NGN\",\n" +
                "  \"payTypes\":[\n" +
                "    \"BalancePayment\",\n" +
                "    \"BonusPayment\"\n" +
                "  ],\n" +
                "  \"payMethods\":[\n" +
                "    \"account\",\n" +
                "    \"qrcode\"\n" +
                "  ],\n" +
                "  \"callbackUrl\": \"https://you.domain.com/callbackUrl\",\n" +
                "  \"returnUrl\": \"https://you.domain.com/returnUrl\",\n" +
                "  \"expireAt\": \"10\"\n" +
                "}", InitRequest.class);
        val cashierResultResponse = service.initialize(cashierRequest).execute();
        Result<InitResult> cashierResult = cashierResultResponse.body();
        assertThat(cashierResult.getCode()).isEqualTo("05007");
        assertThat(cashierResult.getMessage()).isEqualTo("Reference already exist!");
    }

    @SneakyThrows
    @Test
    public void status__Success() {
        StatusRequest request = gson.fromJson("{\n" +
                "  \"reference\": \"ref-1586282294999-1809944780\",\n" +
                "  \"orderNo\": \"200407141498738621\"\n" +
                "}", StatusRequest.class);
        val response = service.status(request).execute();
        Result<StatusResult> result = response.body();
        assertThat(result.getCode()).isEqualTo("00000");
        assertThat(result.getMessage()).isEqualTo("SUCCESSFUL");
        assertThat(result.getData().getStatus()).isEqualTo(Status.SUCCESS);
    }

    @SneakyThrows
    @Test
    public void close__Success() {
        StatusRequest request = gson.fromJson("{\n" +
                "  \"reference\": \"ref-1586282294999-1809944780\",\n" +
                "  \"orderNo\": \"200407141498738621\"\n" +
                "}", StatusRequest.class);
        val response = service.close(request).execute();
        Result<CloseResult> result = response.body();
        assertThat(result.getCode()).isEqualTo("00000");
        assertThat(result.getMessage()).isEqualTo("SUCCESSFUL");
        assertThat(result.getData().getStatus()).isEqualTo(Status.SUCCESS);
    }

}