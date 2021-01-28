## Initiate a payment from 3rd Party Application
```aidl
Payment payment = Payment.builder()
                        .currency("GBP")
                        .callbackUrl("http://www.google.com")
                        .posTransactionId(1221)
                        .amount(100)
                        .build();

try {
    payment.initiate(view.getContext(), "Pay with");
} catch (ActivityNotFoundException e) {
    Log.e("Payment", e.toString());
}
```

## Code to use on callback to check result
```aidl
TransactionResult transactionResult = TransactionResult.fromJson(result);
Log.d("TransactionResult", transactionResult.toString());
```
