val text = sc.textFile("data.txt") // replace with path of any text file. The text variable
val wordsFlatMap = text.flatMap(line => line.split(" ")) // create a flatmap for each line by splitting it into words (separated by space)
val wordMap = wordsFlatMap.map(word => (word,1)) // map method to create tuples of word with count initialize as 1.
var uncollected = wordMap.reduceByKey(_+_) // reduce by the key (first member of the tuple) using '+' operator.  
val wordCounts = uncollected.collect // computation starts only after this step (laziness in scala)
print(wordCounts) // display the entire array
println(wordCounts(0)) // first element