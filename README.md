# cashier
Java client for Cashier services

## Gradle
Add custom maven repository and cashier dependecy
```
repositories {
    mavenCentral()
    maven {
        url  "https://dl.bintray.com/fedache/opay-repository"
    }
}
dependencies {
    implementation 'team.opay:cashier:1.0.0'
}
```

## Maven
```
 <repositories>
        <repository>
            <id>opay-repo</id>
            <url>https://dl.bintray.com/fedache/opay-repository</url>
        </repository>
    </repositories>
    <dependencies>
        <dependency>
            <groupId>team.opay</groupId>
            <artifactId>cashier</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```

# Usage

```
Api api = Api.newInstance("https://cashierapi.operapay.com/api/v3/","djdj", "jdj");
Result<InitResult> initResult = api.initialize(request);
Result<StatusResult> statusResult = api.status(request);
Result<CloseResult> closeResult = api.close(request);
```
