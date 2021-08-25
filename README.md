# Setting up various things

## Setting up Scala & Spark
Use [this blog](https://medium.com/@josemarcialportilla/installing-scala-and-spark-on-ubuntu-5665ee4b62b1) as a reference for Ubuntu systems.

### Running scala code:
1. Fire up _scala REPL_ (Read, Evaluate, Print Loop) by typing ```scala``` on the terminal. 

E.g code: 
```scala
val x: Int = 5+7; 
println("5 + 7 = "+x);
```
It will show the output "5 + 7 = 12". You can exit the scala REPL using Ctrl+C (SIGINT) or by typing ```:q```

2. You can also compile your scala code as follows (**NOTE: you need to create an object with the main method in it**):
First create a new text file and name it something like Hello.scala 
```scala
object Hello { // An object is similar to a class, but you specifically use it when you want a single instance of that class
    def main(args: Array[String]): Unit = { // the Unit type is the scala equivalent of void datatype.
        println("Hello, world!"); // print with new line
    }
}
```
Then just run the following command on the terminal to compile: ```scalac Hello.scala```
It creates
1. Hello$.class
2. Hello.class
[hello world reference](https://docs.scala-lang.org/overviews/scala-book/hello-world-1.html)
To run the compiled code, run command: ```scala Hello```

### Running spark code:
1. Fire up the spark shell executable (```./spark-shell```). It is located in ```spark-x.x.x/bin```. Ignore any warnings displayed. The **spark context** is automatically intialized as ```sc```. Now you can use it in the same way as the scala REPL.
The example code snippet below, gets the word count for a text file. The final format of the output is an array of tuples with word and their corresponding count. 
```scala
val text = sc.textFile("data.txt") // replace with path of any text file. The text variable
val wordsFlatMap = text.flatMap(line => line.split(" ")) // create a flatmap for each line by splitting it into words (separated by space)
val wordMap = wordsFlatMap.map(word => (word,1)) // map method to create tuples of word with count initialize as 1.
var uncollected = wordMap.reduceByKey(_+_) // reduce by the key (first member of the tuple) using '+' operator.  
val wordCounts = uncollected.collect // computation starts only after this step (laziness in scala)
wordCounts // display the entire array
println(wordCounts(0)) // first element
```
2. Running small scripts: fire up REPL and use the following command to load the script file:
```load: /path/to/script.scala```
3. **(Advanced)** Compiling App jar using sbt, and submitting it using spark-submit executable 

## Setting up spark environment variables:
Follow [this blogpost](https://www.educative.io/edpresso/how-to-set-up-a-spark-environment) to setup spark for global use.
It will:
1. Move spark to ```/opt``` and create a symlink
2. Set path variables in the ```~/.bashrc```

### Useful Links
1. [Installing scala and Spark](https://medium.com/@josemarcialportilla/installing-scala-and-spark-on-ubuntu-5665ee4b62b1)
2. [Spark docs](https://spark.apache.org/)
3. [scala docs](https://docs.scala-lang.org/?_ga=2.198983471.1871694219.1629933621-987059727.1629926689)
4. [Hello world in scala](https://docs.scala-lang.org/overviews/scala-book/hello-world-1.html)
5. [Env setup for spark](https://www.educative.io/edpresso/how-to-set-up-a-spark-environment)
6. [Quicksort in scala](https://alvinalexander.com/scala/how-to-sort-scala-array-quicksort/)
7. [sortBy in scala](https://blog.knoldus.com/sorting-in-scala-using-sortedsortby-and-sortwith-function/)
8. [Word Count in spark and scala](https://dzone.com/articles/wordcount-with-spark-and-scala)