# Inventory Management

### Prerequisites

1. Git
1. Java 8+
1. Eclipse With Maven Integration

### Installation

1. Clone this repository
   ```
   git clone git@github.com:ronarvaez/inventoryManagement.git
   ```
1. Open an Eclipse Workspace in the folder you cloned the project
1. File > Import > Maven > Existing Maven Projects
1. Open terminal at the folder you cloned the project
1. Run Maven Package
   ```
   mvn clean package
   ```
1. Run Java
   ```
   java -jar target/inventoryManagement-0.1.0.jar
   ```

### Endpoints

1.  POST Create Item

    ```
    POST http://localhost:8080/items
    {
      "description": "+5 Dexterity Vest",
      "quality": "20",
      "sellIn":"10"
    }
    ```

1.  POST Create Many Items

    ```
    POST http://localhost:8080/items/bulk
    [
      {
      "description": "+5 Dexterity Vest",
      "quality": "20",
      "sellIn":"10"
    },
    {
      "description": "Aged Brie",
      "quality": "0",
      "sellIn":"2",
      "type": "AGED_BRIE"
    },{
      "description": "Elixir of the Mongoose",
      "quality": "7",
      "sellIn":"5",
      "type": "BASIC"
    },{
      "description": "SULFURAS",
      "quality": "80",
      "sellIn":"0",
      "type": "SULFURA"
    },{
      "description": "Concert backstage passes",
      "quality": "20",
      "sellIn":"15",
      "type": "CONCERT_PASS"
    }
    ]
    ```

1.  GET List all Items

    ```
    GET http://localhost:8080/items/
    ```

1.  GET Find one Item by Index

    ```
    GET http://localhost:8080/items/{index}

    example: http://localhost:8080/items/1
    ```

1.  DELETE one item by index

    ```
    DELETE http://localhost:8080/items/{index}

    example: http://localhost:8080/items/0
    ```

1.  DELETE all items

    ```
    DELETE http://localhost:8080/items
    ```

1.  Update an Item
    ```
    PATCH http://localhost:8080/items/{index}
    {
      "description": "+5 Dexterity Vest",
      "quality": "20",
      "sellIn":"10"
    }
    ```
1.  Process End Of Day

    ```
    GET http://localhost:8080/processEOD

    Response Example -> list of processed items
    [
        {
            "description": "+5 Dexterity Vest",
            "quality": 7,
            "sellIn": -2,
            "type": "BASIC"
        },
        {
            "description": "Aged Brie",
            "quality": 21,
            "sellIn": -10,
            "type": "AGED_BRIE"
        },
        {
            "description": "Elixir of the Mongoose",
            "quality": 0,
            "sellIn": -7,
            "type": "BASIC"
        },
        {
            "description": "SULFURAS",
            "quality": 80,
            "sellIn": 0,
            "type": "SULFURA"
        },
        {
            "description": "Concert backstage passes",
            "quality": 39,
            "sellIn": 3,
            "type": "CONCERT_PASS"
        }
    ]
    ```

1.  Process End Of Day for N days in the future

    ```
    GET http://localhost:8080/processEOD/{days}

        example: GET http://localhost:8080/processEOD/10
        Response Example -> list of processed items
        [
            {
                "description": "+5 Dexterity Vest",
                "quality": 7,
                "sellIn": -2,
                "type": "BASIC"
            },
            {
                "description": "Aged Brie",
                "quality": 21,
                "sellIn": -10,
                "type": "AGED_BRIE"
            },
            {
                "description": "Elixir of the Mongoose",
                "quality": 0,
                "sellIn": -7,
                "type": "BASIC"
            },
            {
                "description": "SULFURAS",
                "quality": 80,
                "sellIn": 0,
                "type": "SULFURA"
            },
            {
                "description": "Concert backstage passes",
                "quality": 39,
                "sellIn": 3,
                "type": "CONCERT_PASS"
            }
        ]
    ```

    <hr>
    By Rodrigo Narvaez
