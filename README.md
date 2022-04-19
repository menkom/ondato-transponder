# Goals

Main goal of application is to retranslate received information to the list of registered hosts

# Methods
* `GET /api/host` - get the list registered hosts 
```
curl --location --request GET 'http://localhost:8080/api/host
```
* `POST /api/host` with path to host as text in RequestBody - add new host to the list of registered hosts
```
curl --location --request POST 'http://localhost:8080/api/host' \
--header 'Content-Type: text/plain' \
--data-raw 'http://remote.host:8083'
```
* `DELETE /api/host` with path to host as text in RequestBody - delete host from registered hosts
```
curl --location --request DELETE 'http://localhost:8080/api/host' \
--header 'Content-Type: text/plain' \
--data-raw 'http://remote.host:8083'
```
* `POST /api/ondato/webhook/<identificationId>` - receive webhook request from Ondato which will be transferred to all registered hosts
```
curl --location --request POST 'http://localhost:8080/api/ondato/webhook/bcfc5b15-6764-4053-95bb-316a2863fca1' \
--header 'x-api-key: SecretApiKey' \
--header 'Content-Type: application/json' \
--data-raw '{
    "RequestStatus": "MANUAL_FINISH",
    "IsCrossChecked": "true",
    "Event": "CROSS_CHECKED"
}'
```

# Application variables
* HOSTS - list of registered hosts separated with comma (example: http://localhost:8083, https://ondato.host.me) 