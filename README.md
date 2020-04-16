# Biz DB Train

## Requirements
- JDK 8
- docker-compose

## Setup
1. fork this repository
2. install required modules
    ```shell script
    docker-compose up -d
    ```

3. configure ERFlute
    - Finder.app 
        - open eclipse/Eclipse.app
    - Eclipse.app
        - At Welcome window, Click `Workbench` 
        - At PackageExplorer, Click `Imports projects`
        - Click `Existing Projects into Workspace`
        - Click `Browse` (located on the right of `Select root directory`)
        - Choose `<PROJECT_ROOT>/eclipse/erflute`
        - Click `Finish`

## Commands
- Setup
```shell script
docker-compose up -d
```

- Update Schema (DBFlute replace-schema, jdbc, doc)
```shell script
docker-compose up update-twitterdb
```

- Test Query
```shell script
./gradlew test 
```

## Artifacts
- [SchemaHTML](./dbflute-twitterdb/dbflute_twitterdb/output/doc/schema-twitterdb.html) 
- [JUnit Test Report](./build/reports/tests/test/index.html)

## Utilities
- ERFlute
    - eclipse/Eclipse.app

## Docs
- [DB Planning](./docs/DB_PLANNING.md)
- [SQL Hands on](./docs/SQL_HANDS_ON.md)
