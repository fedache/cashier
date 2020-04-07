package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;

public enum PaymentTypes {
    @SerializedName("BalancePayment")
    BALANCE,
    @SerializedName("BonusPayment")
    BONUS
}
