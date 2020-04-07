package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CloseResult {
    @SerializedName("reference")
    private String reference;

    @SerializedName("orderNo")
    private String orderNo;

    @SerializedName("status")
    private String status;
}
