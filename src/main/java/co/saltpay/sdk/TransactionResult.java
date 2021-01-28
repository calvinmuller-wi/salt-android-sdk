package co.saltpay.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResult {

    private String cardAcceptorGuid;
    private Date createDate;
    private String currency;
    private String originalTransactionId;
    private String posTransactionId;
    private String promptTip;
    private int requestAmount;
    private String state;
    private int tipAmount;
    private int totalAmount;
    private String transactionId = null;
    private TransactionType transactionType;
    private String switchTransactionId;
    private String terminalTransactionId;
    private String cardSchemeName;
    private String cardExpiry;
    private String cardMaskedNumber;
    private String cardEntryMode;
    private int id;
    private String accountType;
    private String authCode;
    private int tenderId;
    private boolean hasCardHolderReceipt;

    @SneakyThrows
    public static TransactionResult fromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, TransactionResult.class);
    }

    @SneakyThrows
    public static TransactionResult fromQueryString(String queryString) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Helpers.fromQueryString(queryString), TransactionResult.class);
    }

    boolean isApproved() {
        return state.toLowerCase().equals("approved");
    }
}
