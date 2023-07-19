# StormStatServer

> A Java storm database to keep track of various storms' details, allowing users to look up storms by name and view sorted lists based on windspeed or precipitation amount.

## Table of Contents

- [Description](#description)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Required Classes](#required-classes)
  - [Storm](#storm)
  - [WindSpeedComparator](#windspeedcomparator)
  - [PrecipitationComparator](#precipitationcomparator)
  - [StormStatServer](#stormstatserver)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Description

The StormStatServer project is a Java storm database designed to help the Government and NOAA keep track of various storms and their details. The software allows users to look up storms by name, view their details, and sort the storms based on windspeed or precipitation amount. The database can be saved to a file for persistence and reloaded on the next run of the program.

## Prerequisites

To run the StormStatServer project, ensure you have the following installed on your computer:

- Java Development Kit (JDK)
- Git (optional, for cloning the repository)

## Installation

1. Clone the StormStatServer repository to your local machine (if you haven't already).

```bash
$ git clone https://github.com/yourusername/StormStatServer.git
$ cd StormStatServer
```
## Usage
To compile 
```bash
$ javac Main.java
```
Run the DeliveryListManager application from the command line.
```bash
$ java Main
```
Run the StormStatServer application.

Follow the on-screen prompts to interact with the storm database. The menu-based interface allows you to add, remove, and edit storms. The database will be saved automatically at the end of the program and loaded from the file if it exists on startup.

Keep in my mind to create a package name and include the package name in all the classes.

## Required Classes

### Storm
A fully-documented class named Storm that represents a storm with properties such as name, precipitation, windspeed, and date. The class must implement the Serializable interface.

### WindSpeedComparator
A fully-documented class named WindSpeedComparator that allows us to compare two storms based on windspeed. The class should implement the Comparator interface and override the compare method.

### PrecipitationComparator
A fully-documented class named PrecipitationComparator that allows us to compare two storms based on precipitation amount. The PrecipitationComparator class should implement the Comparator interface and override the compare method.

### StormStatServer
A fully-documented class named StormStatServer that allows users to interact with a database of storms. The class provides a menu-based interface to add, remove, and edit storms. The storm database is stored using a HashMap, where the storm name is the key and the associated Storm object is the value. The names should be converted to uppercase.

## Contributing
Contributions to StormStatServer are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Contact
If you have any questions or feedback, you can contact the project maintainer at:

Email: pmtaday@gmail.com
GitHub: @ptaday
