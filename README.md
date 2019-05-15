# Advertisement Request Enhancer

*Advertisement Request Enhancer* is a microservice which augments anincoming Ad request with contextual information like demographics, location etc. It leverages libraries and services from Spring Cloud and Netflix OSS to compose the system.

## Build

. Using Maven, build and package the application:
+
----
$ mvn clean package -Dmaven.test.skip=true
----
+

## Run

. Start the Eureka Service
+
----
$ cd spring-boot-microservice-eureka-naming-server/
$ mvn spring-boot:run
----

. Start the AdEnhancer Service
+
----
$ cd adEnhancer/
$ mvn spring-boot:run
----

. Start the Zuul service
+
----
$ cd zuul-server-master/
$ mvn spring-boot:run
----


## Test the Application

### An example request and response is shown below
### POST to http://127.0.0.1:8765/ad-enhancer-service/enhance
#### Request

```json
{
    "site": {
        "id": "foo123",
        "page": "http://www.foo.com/why-foo"
    },
    "device": {
        "ip": "69.250.196.118"
    },
    "user": {
        "id": "9cb89r"
    }
}
```
---

#### Response
```json{
    "site": {
        "id": "foo123",
        "page": "http://www.foo.com/why-foo",
        "demographics": {
            "female_percent": 49,
            "male_percent": 51
        },
        "publisher": {
            "id": "ksjdf9325",
            "name": "ACME Inc."
        }
    },
    "device": {
        "ip": "69.250.196.118"
    },
    "user": {
        "id": "9cb89r"
    }
}
```

