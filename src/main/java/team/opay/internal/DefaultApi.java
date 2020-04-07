package team.opay.internal;

import lombok.val;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import team.opay.Api;
import team.opay.data.cashier.*;
import team.opay.internal.config.RetrofitInstance;
import team.opay.internal.service.CashierService;

import java.io.IOException;
import java.util.LinkedHashMap;

public class DefaultApi implements Api {

    private Retrofit retrofit;
    private CashierService cashierService;

    public DefaultApi(String baseUrl, String merchantId, String publicKey) {
        LinkedHashMap<String, String> map = getCommonHeaders(merchantId, publicKey);
        this.retrofit = RetrofitInstance.getInstance(baseUrl, map);
        this.cashierService = retrofit.create(CashierService.class);
    }

    @NotNull
    public static LinkedHashMap<String, String> getCommonHeaders(String merchantId, String publicKey) {
        String authorization = "Bearer " + publicKey;
        val map = new LinkedHashMap<String, String>();
        map.put("content-type", "application/json");
        map.put("MerchantId", merchantId);
        map.put("Authorization", authorization);
        return map;
    }

    @Override
    public Result<InitResult> initialize(InitRequest request) throws IOException {
        return cashierService.initialize(request).execute().body();
    }

    @Override
    public Result<StatusResult> status(StatusRequest request) throws IOException {
        return cashierService.status(request).execute().body();
    }

    @Override
    public Result<CloseResult> close(StatusRequest request) throws IOException {
        return cashierService.close(request).execute().body();
    }
}
