package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class InitResult {
    @SerializedName("reference")
    private String reference;

    @SerializedName("orderNo")
    private String orderNo;

    @SerializedName("cashierUrl")
    private String cashierUrl;

    @SerializedName("amount")
    private long amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private Status status;
}
