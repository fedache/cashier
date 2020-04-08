# cashier
Java client for Cashier services

[ ![Download](https://api.bintray.com/packages/fedache/opay-repository/cahier/images/download.svg?version=0.1) ](https://bintray.com/fedache/opay-repository/cahier/0.1/link)

# Usage

```
Api api = Api.newInstance("https://cashierapi.operapay.com/api/v3/","djdj", "jdj");
Result<InitResult> initResult = api.initialize(request);
Result<StatusResult> statusResult = api.status(request);
Result<CloseResult> closeResult = api.close(request);
```
