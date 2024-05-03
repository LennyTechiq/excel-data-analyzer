
# Excel Data Analyzer

The Excel Data Analyzer is a web application built with Spring Boot that allows users to upload Excel files and analyze the data within them.



## Features

- Upload Excel files
- Display Excel data in a tabular format
- Select and view specific columns
- Count the occurrences of specific names in a column

## Tech Stack

**Client:** Thymeleaf, Bootstrap

**Server:** Java, Spring Boot, Apache POI(for excel file processing)


## Getting Started

**Prerequisites**
- Java 8 or higher
- Maven
- IDE (like IntelliJ IDEA or Eclipse)

**Installation**

1. Clone the repository:

```bash
git clone https://github.com/LennyTechiq/excel-data-analyzer.git
```

2. Navigate to the project directory:
```bash
cd excel-data-analyzer
```

3. Build the project:
```bash
mvn clean package
```

4. Run the application:
```bash
java -jar target/excel-data-analyzer.jar
```

5. Access the application in your web browser at http://localhost:8080
## Usage

- Upload an Excel file using the "Upload Excel" page.
- After uploading, you will be directed to the "Display Data" page where you can view the data.
- Select a column from the dropdown menu to highlight and view only that column.
- Below the table, you can see the counts of specific names in the selected column.


## Contributing

Contributions are welcome! Please open an issue or submit a pull request with any improvements or new features.


## Demo

https://springexcelanalyzer.onrender.com

