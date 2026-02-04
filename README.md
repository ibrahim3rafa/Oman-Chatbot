# 🤖 Chatbot Automation Testing (Excel Data-Driven)

This project automates testing for a web-based chatbot using **Selenium WebDriver with Java**.  
It follows a **data-driven testing** approach where chatbot questions are read from an **Excel file**, sent to the chatbot UI, and the bot’s responses are captured and written back to the Excel file automatically.

---

## 📌 Project Overview

The main goal of this project is to validate chatbot responses by automating real user interactions with the chatbot UI.  
Test data is managed through Excel, making it easy for testers, stakeholders, or reviewers to add, update, and review chatbot questions and answers without changing the code.

---

## 🛠 Tech Stack

- Java  
- Selenium WebDriver  
- TestNG  
- Apache POI (Excel handling)  
- Maven  
- IntelliJ IDEA  
- ChromeDriver  

---

## 📂 Project Structure
```bash
src
├── main
│ └── java
│ ├── pages
│ │ └── ChatbotPage.java
│ └── utils
│ └── ExcelUtil.java
│
├── test
│ ├── java
│ │ └── tests
│ │ └── ChatbotExcelTest.java
│ └── resources
│ └── chatbot_data.xlsx
│
└── target
└── chatbot_data.xlsx
```

---

## 📊 Excel File Format

The Excel file used for testing must follow this structure:

| Column | Description |
|------|------------|
| Question | Chatbot question to be sent |
| Answer | Chatbot response (filled automatically by the test) |

- The Excel file is read from `src/test/resources`
- The output Excel file with chatbot answers is generated in the `target` directory

---

## ▶️ Test Flow

1. Open the chatbot web application
2. Launch the chatbot widget
3. Accept the disclaimer
4. Read questions from the Excel file
5. Send each question to the chatbot
6. Wait for a new chatbot response dynamically
7. Capture the correct bot reply
8. Write the response back to the Excel file

---

## 🧪 Running the Tests

### Run from IntelliJ IDEA
- Open `ChatbotExcelTest.java`
- Right-click and select **Run**

### Run using Maven
```bash
mvn test
```

## Key Features

- Data-driven testing using Excel

- Page Object Model (POM) design pattern

- Dynamic waiting for new chatbot responses

- No hard-coded sleeps

- Stable and reliable automation execution

- Clean separation between test logic, page logic, and test data

## ⚠️ Important Notes

- Excel files inside resources are read-only during execution

- All test outputs are written to the target folder

- Chatbot responses are captured based on newly generated bot messages to avoid duplicated or incorrect answers

## 🚀 Future Improvements

- Add PASS / FAIL status for each test case

- Validate chatbot responses using keywords or rules

- Add timestamps for chatbot replies

- Support multiple Excel sheets

- Integrate with CI/CD pipelines

- Add AI hallucination detection scenarios

## 👤 Author

Ibrahim Arafa
Junior Software Tester | ISTQB® Certified Tester (CTFL & MAT)
Manual Testing • Automation Testing • API Testing