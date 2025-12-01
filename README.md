📘 Student Management System — Java (OOP + File Storage)

A clean, simple, and beginner-friendly Student Management System built using Core Java, OOP, Collections, and File Handling.

This project performs full CRUD operations, stores data in a text file, and follows a proper src + bin Java structure.

🚀 Features
✔ Core Features (CRUD)

Add Student

View All Students

Update Student

Delete Student

✔ Additional Features

Search Student by Name

Sort Students by Age

Auto-save to file

Auto-load from file

Clean console-based menu

🧠 Tech Used

Java (Core)

OOP Concepts (Classes, Objects, Encapsulation)

File Handling (BufferedReader, BufferedWriter)

Collections (ArrayList, List)

📁 Folder Structure

StudentManagement/
├── src/ # Java source files
│ ├── Main.java
│ ├── Student.java
│ ├── StudentService.java
│ └── FileHandler.java
│
├── bin/ # Compiled .class files
│ ├── Main.class
│ ├── Student.class
│ ├── StudentService.class
│ └── FileHandler.class
│
├── students.txt # Auto-created data storage file
├── .gitignore
└── README.md

▶️ How to Compile and Run
Step 1: Compile

Run this from the project folder:
javac -d bin src/\*.java

Step 2: Run
java -cp bin Main

📦 Data Storage File Format (students.txt)

1,Devansh,23,CSE
2,Aditya,23,CSE
3,Priyam,22,DS
4,Kavya,21,AI

Stored automatically when adding/updating/deleting students.

🛠 Future Enhancements (Optional)

Save data in JSON / CSV

Validate inputs

GUI version using JavaFX

Student marks + GPA system

Sort by name

Search by ID

Better table formatting

✨ Author

Devansh Kumar
Java | MERN | Full Stack Developer
