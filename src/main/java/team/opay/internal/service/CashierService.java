package team.opay.internal.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import team.opay.data.cashier.*;

public interface CashierService {
    @POST("cashier/initialize")
    Call<Result<InitResult>> initialize(@Body InitRequest request);

    @POST("cashier/status")
    Call<Result<StatusResult>> status(@Body StatusRequest request);

    @POST("cashier/close")
    Call<Result<CloseResult>> close(@Body StatusRequest request);
}