## Bean Cafe API

REST API for a fictional restaurant

## Run locally

Create `.env`

```
PG_DB=
PG_USER=
PG_PASS=
PG_HOST=
```

```
docker-compose up
```


## Endpoints

Resource      |     POST          |       GET           |     UPDATE             |      DELETE
:------------ | :-----------------| :-------------------| :-------------------- | :---------------- | 
/users        | :heavy_check_mark: |  :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark:| 
/products        |  |   | | | 
/categories        |  |   |  | | 
/orders        |  |   |  | | 
/payments        |  |   |  | | 
/cart        |  |   |  | | 


## Users

### GET `/users`

response
```json
{
  "data": [
      {
        "id": 1,
        "email": "edwin@mail.com",
        "name": "edwin",
        "address": "Nairobi, Kenya",
        "phone": "0700000000",
        "cartId": null
      }
  ],
  "message": "ok"
}
```

### GET `/users/{id}`

response 

```json
{
  "data": {
    "id": 1,
    "email": "edwin@mail.com",
    "name": "edwin",
    "address": "Nairobi, Kenya",
    "phone": "0700000000",
    "cartId": null
  },
  "message": "ok"
}
```

### POST `/users`

body

```json
{
  "email":"edwin@mail.com",
  "name":"edwin",
  "address":"Nairobi, Kenya",
  "phone":"0700000000"
}
```

response

```json
{
  "data": {
    "id": 1,
    "email": "edwin@mail.com",
    "name": "edwin",
    "address": "Nairobi, Kenya",
    "phone": "0700000000",
    "cartId": null
  },
  "message": "User created"
}
```

### PUT `/users/{id}`

body

```json
{
  "address":"Mombasa, Kenya"
}
```

### DELETE `/users/{id}`

response

```json
{
  "data": null,
  "message": "User deleted"
}
```