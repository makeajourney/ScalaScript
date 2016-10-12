import scala.io.Source

/*
Q1 :
Write a Scala code snippet that reverses the lines in a file
(making the last line the first one, and so on).
 */

val source = Source.fromFile("/Users/kimsoyoun/Downloads/myfile.txt", "UTF-8")
val lines = source.getLines().toArray.reverse

for (line <- lines) println(line)

/*
Q2 :
Write a Scala program that reads a file with tabs, replaces each tab with spaces so that
there are tab stops every n columns, and writes the result to the same file.
 */
