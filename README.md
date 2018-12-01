#BTO Scraper

This python script painstakingly scrapes almost all current BTO data from the BTO webapp developed by Housing Development Board. The webapp can be found [here](https://services2.hdb.gov.sg/webapp/BP13AWFlatAvail/BP13SEstateSummary?sel=BTO). 

BTO data includes: Block number, Room type, coordinates (not exact, street conversion to coordinates by geo-reversing with the help of googlemaps API), Construction finish date, moving-in date, Ethnicity availability, Building layout image link.


This scraper stores the scraped data into a textfile with "***" delimiters and a MySQL database. a mysql database has to be set up locally and a mysqlconnector is needed.A simple frontend (java) using the Tomcat server is used to filter through the results based on the BTO attributes. This allows an easier method to search for BTO units as the current implementation by HDB is very user-unfriendly.

Data is scraped once and is static.




