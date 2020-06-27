# CN AirData Scraper Scala
Scrap China air quality data in Scala

# My first Scala Script on Github!

* It goes to http://pm25.in/ and scapes all the air quality data for each city, and save it to a file called **data.txt**.
* Since the website updates the data on a hourly basis, running this script once means taking a snapshot.
* So if you need date more than a 'snapshot', you will need to run this script every 60 min.

# TODO:
* Use timestamp in the output file name, so instead of **data.txt**, it will be like **data_20200626_133029.txt**.
* Add the time showed on the website to the output file as a column.
* Add the city name to the output file for each monitoring site.
* The table header is stored in the output file many many times. I need to change the code so each output file only have one row of table header.
