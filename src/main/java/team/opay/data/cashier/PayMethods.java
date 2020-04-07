package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;

public enum PayMethods {
    @SerializedName("account")
    ACCOUNT,
    @SerializedName("qrcode")
    QRCODE
}
