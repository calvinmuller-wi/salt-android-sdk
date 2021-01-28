# Installation
 - Step 1
```aidl
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
- Step 2
```aidl
dependencies {
    implementation 'com.github.calvinmuller-wi:salt-android-sdk:1.0-SNAPSHOT'
}
```
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
Outputs
```aidl
TransactionResult(cardAcceptorGuid=6233bed6-9053-4e96-af3e-0504715f6ef1, createDate=Tue Jan 19 17:18:13 GMT+01:00 2021, currency=GBP, originalTransactionId=0, posTransactionId=fb0fd571-6294-4d3d-b94b-0c56160d873a, promptTip=true, requestAmount=900, state=APPROVED, tipAmount=0, totalAmount=900, transactionId=null, transactionType=payment, switchTransactionId=9101c3d0-5a69-11eb-92c9-4ba8bbedca76, terminalTransactionId=9101c3d0-5a69-11eb-92c9-4ba8bbedca76, cardSchemeName=MasterCard, cardExpiry=0525, cardMaskedNumber=************7746, cardEntryMode=CONTACTLESS_ICC, id=7076, accountType=DEBIT, authCode=123456, tenderId=9871, hasCardHolderReceipt=true)
```

# TODO:
1. Create refund & partial refunds from payments
2. Create reversals from payments
