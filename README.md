# Java Vehicle Registration Parser

## Overview
A Java data-processing application that reads external CSV registration records, parses the raw strings into structured fields, and instantiates domain objects.

## Key Concepts
* **File I/O & CSV Parsing**: Reads and tokenizes records from registration.csv.
* **Domain Modeling**: Maps parsed values to CarOwner and Citizen classes.
* **Output Handling**: Formats processed records and outputs data to output.txt.

## How to Run
1. Clone the repository:
   git clone https://github.com/vyjames/java-vehicle-registration-parser.git
2. Compile the files:
   javac RegistrationDemo.java
3. Run the program:
   java RegistrationDemo
