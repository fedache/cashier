package team.opay;

import team.opay.data.cashier.*;
import team.opay.internal.DefaultApi;

import java.io.IOException;

public interface Api {
    Result<InitResult> initialize(InitRequest request) throws IOException;

    Result<StatusResult> status(StatusRequest request) throws IOException;

    Result<CloseResult> close(StatusRequest request) throws IOException;

    public static Api newInstance(String url, String merchantId, String publicKey) {
        return new DefaultApi(url, merchantId, publicKey);
    }
}
