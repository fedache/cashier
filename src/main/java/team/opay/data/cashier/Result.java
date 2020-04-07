package team.opay.data.cashier;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class Result<T> {
    @SerializedName("code")
    @Nullable
    private String code;

    @SerializedName("message")
    @Nullable
    private String message;

    @SerializedName("data")
    @Nullable
    private T data;
}
