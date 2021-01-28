package co.saltpay.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

@Data
@Builder
@JsonTypeName("payment")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class Payment {

    @NonNull
    private int posTransactionId;

    @NonNull
    private String currency;

    private boolean prompTip;

    @NonNull
    private int amount;

    private int tipAmount;

    @NonNull
    private String callbackUrl;

    @SneakyThrows
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    /**
     * Title should be something like Pay with:, Refund With, etc.
     * @param context
     * @param title
     * @throws ActivityNotFoundException
     */
    public void initiate(Context context, String title) throws ActivityNotFoundException {
        Uri webpage = Uri.parse("slt://saltpay.co/transaction/start");
        Intent payIntent = new Intent(Intent.ACTION_VIEW, webpage);
        payIntent.putExtra(Intent.EXTRA_TEXT, this.toString());
        context.startActivity(Intent.createChooser(payIntent, title));
    }
}
