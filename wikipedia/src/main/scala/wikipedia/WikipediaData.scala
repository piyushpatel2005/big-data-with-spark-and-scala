package wikipedia

import java.io.File

object WikipediaData {

  private[wikipedia] def filePath = {
    val resource = this.getClass.getClassLoader.getResource("wikipedia/wikipedia.dat")
    if (resource == null) sys.error("Please download the dataset as explained in the assignment instructions")
    new File(resource.toURI).getPath
  }

  private[wikipedia] def parse(line: String): WikipediaArticle = {
    val subs = "</title><text>"
    val i = line.indexOf(subs)
    val title = line.substring(14, i) // there are 14 characters before title starts in the file
    val text  = line.substring(i + subs.length, line.length-16) // there are 16 characters after the end of text
    WikipediaArticle(title, text)
  }
}
