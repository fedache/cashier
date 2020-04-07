package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class StatusResult {
    @SerializedName("reference")
    private String reference;

    @SerializedName("orderNo")
    private String orderNo;

    @SerializedName("amount")
    private String amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private String status;
}

