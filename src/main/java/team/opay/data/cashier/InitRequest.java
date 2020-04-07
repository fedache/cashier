package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.util.List;

@Data
public class InitRequest {
    @SerializedName("reference")
    private String reference;

    @SerializedName("mchShortName")
    private String mchShortName;

    @SerializedName("productName")
    private String productName;

    @SerializedName("productDesc")
    private String productDesc;

    @SerializedName("userPhone")
    private String userPhone;

    @SerializedName("userRequestIp")
    private String userRequestIp;

    @SerializedName("amount")
    private long amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("payTypes")
    private List<PaymentTypes> payTypes;

    @SerializedName("payMethods")
    private List<PayMethods> payMethods;

    @SerializedName("callbackUrl")
    private String callbackUrl;

    @SerializedName("returnUrl")
    private String returnUrl;

    @SerializedName("expireAt")
    private String expireAt;
}