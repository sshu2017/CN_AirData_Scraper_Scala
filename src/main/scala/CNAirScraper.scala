import org.jsoup.Jsoup
import scala.jdk.CollectionConverters._
import java.io._

object CNAirScraper extends App {

  val html = Jsoup.connect("http://pm25.in/").get()
  val cities = html.select(".unstyled > div > li > a").asScala

  var cnt: Int = 1
  for (city <- cities) {
    if (cnt <= 3) {
      saveOneCityTable(
        getOneCityData("http://pm25.in" + city.attr("href"))
      )
      cnt = cnt + 1
      print("cnt = " + cnt + "\n")
    }
  }

  def getOneCityData(inputURL: String): String = {
    println(inputURL)
    val cityDoc = Jsoup.connect(inputURL).get()
    val cityTable = cityDoc.select("#detail-data")
    //    be nice to the server
    Thread.sleep(1500)
    print("Sleeping for 1.5 seconds ...\n")
    cityTable.toString
  }

  def saveOneCityTable(inputTable: String): Unit = {
    val pw = new PrintWriter(new FileWriter("data.txt", true))

    val oneCityTable = Jsoup.parse(inputTable)

    for (ln <- oneCityTable.select("th").asScala) pw.write(ln.text + "|")

    for (ln <- oneCityTable.select("tr").asScala) {
      for (e <- ln.select("td").asScala) {
        pw.write(e.text + "|")
      }
      pw.write("\n")
    }

    pw.close()
  }
}


