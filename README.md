# =vater=
VAT calculator REST service

## Installation
```
$ git clone https://github.com/maslick/vater.git
$ ./gradlew clean build
```

## Usage
```
$ java -jar build/libs/vater.jar
```

## API
* get 3 countries with the lowest VAT: ``GET /low``
* get 3 countries with the highest VAT: ``GET /high``
