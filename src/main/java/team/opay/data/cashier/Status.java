package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName("INITIAL")
    INITIAL,

    @SerializedName("PENDING")
    PENDING,

    @SerializedName("SUCCESS")
    SUCCESS,

    @SerializedName("FAILED")
    FAILED,

    @SerializedName("CLOSED")
    CLOSED;
}
