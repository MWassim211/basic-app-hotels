db = db.getSiblingDB("HotelDB");
db.article.drop();

db.getCollection('Hotels').save({
    "id": "5fefa64fbqdsqssdcd390c46b3a4c4",
    "name": "Golden",
    "pricePerNight": 100,
    "adress": {
      "city": "London",
      "country": "England"
    },
    "reviews": [
      {
        "userName": "John",
        "rating": 8,
        "approved": true
      },
      {
        "userName": "Marc",
        "rating": 7,
        "approved": false
      }
    ]
});