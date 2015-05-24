# OrderTaker

OrderTaker is a program to help take order. It is a very useful app to sales manager, who work with computer.
You can use everywhere, but you need internet connection. The main data are in the database.

### Version

1.0

### Prerequisites:
    * [Apache Maven](https://maven.apache.org).
    * Java-jdk 1.8u45
    * JavaFx

### Usage

To create executable 'jar' file, type the following command in terminal in the base dir of project:
```sh
    $ mvn package
```

To run created jar:
```sh
    $ java -jar view/target/view-1.0.jar
```

To create a report about tests, code coverage, documentation, etc:
```sh
    $ mvn site
```

The index.html can found in project_basedir/target/staging.
