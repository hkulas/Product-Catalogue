# Product-Catalogue
Backend part of Product catalogue app

## Testing
There is swagger set up for testing purpouses you can find it on this URL:
- https://localhost:8080/swagger-ui/index.html#

## Frontend
Download the Product-Catalogue-UI app and follow instructions for installing it.
Run the frontend app with 'set https=3000&npm start'

## Features
* CRUD operations for Products

* CRUD operations for Locations

* Text search

* Shows distance between specified point and other saved locations in database.

## Text search
Searches through specified fields in the created index for Product class. 
* Text search
example
 ```
curl -X GET "https://localhost:8080/product/search?searchText=tommy" -H "accept: */*"
 ```
 
 response:
  ```
 [
  {
    "_id": {
      "timestamp": 1610194932,
      "date": 1610194932000
    },
    "category": "tshirt",
    "manufacturer": "Tommy Hilfiger",
    "name": "T Shirt Basic",
    "photosUrls": [
      "https://img01.ztat.net/article/spp-media-p1/80cd0d1ad7343fcfb2cdd428e50d4034/ea44313127b14266a1bf7c2cb113e89b.jpg?imwidth=1800",
      "https://img01.ztat.net/article/spp-media-p1/0d486b611e563726bac4ad02b5aced2c/cd7f5ebbc5d54f7e82b87c9c0b17b7be.jpg?imwidth=1800"
    ],
    "otherParameters": {
      "Krój": "Regular",
      "Materiał": "Bawełna 100%",
      "Struktura": "Dżersej"
    },
    "_class": "pl.wsb.product.catalogue.model.Product"
  }
]
 ```
 
## Geospatial search
Is looking for location/s based of specified point and distance

example
 ```
curl -X GET "https://localhost:8080/location/near?distance=30&x=53.65&y=14.63" -H "accept: */*"
 ```
 
 response
 ```
 {
  "averageDistance": {
    "value": 6.66142056819518,
    "metric": "KILOMETERS",
    "normalizedValue": 0.001044414782591716,
    "unit": "km"
  },
  "content": [
    {
      "content": {
        "id": "Stepnica Shop",
        "address": "Stepnica, ul. Płaska 22",
        "location": [
          53.6535668231848,
          14.634987959298957
        ]
      },
      "distance": {
        "value": 0.6752064872434645,
        "metric": "KILOMETERS",
        "normalizedValue": 0.000105862650370079,
        "unit": "km"
      }
    },
    {
      "content": {
        "id": "Sklep w Policach",
        "address": "Police, ul. Szeroka 11",
        "location": [
          53.54852994207463,
          14.572845176465034
        ]
      },
      "distance": {
        "value": 12.647634649146896,
        "metric": "KILOMETERS",
        "normalizedValue": 0.001982966914813353,
        "unit": "km"
      }
    }
  ]
}
```
## Built With
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Hubert Kulas** - [HKulas](https://github.com/hkulas)
* **Jakub Boruk** - [JBoruk](https://github.com/JBoruk)
