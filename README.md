# Student Result Management System

## Project Description
A Java Swing desktop application for managing student records and academic results. The system allows an admin to log in, add students, enter marks, and automatically calculate grades and pass/fail status. Data is saved to files so it persists between sessions.

## Group Members
|    Name 	|   CMS/ID    | Section |
|---------------|-------------|---------|
| Ahmed Chandio | 023-25-0201 | B |
| Malhar Unar   | 023-25-0201 | B |


## Purpose
This project helps educational institutes manage student data and results digitally. Instead of paper records, administrators can add students, enter marks, and instantly see grades — all stored in files for future use.

## Main Modules
- **model/** — Person (base class), Student (extends Person), Result
- **ui/** — LoginFrame, DashboardFrame, StudentFrame, ResultFrame
- **utils/** — FileHandler (saves/loads data), GradeCalculator (grade logic)
- **main/** — Main (entry point)

## How to Compile and Run

### Requirements
- Java JDK 8 or higher
- No external libraries needed

### Steps to Run
1. Open a terminal / command prompt
2. Navigate to the project folder:
   cd path/to/Project
3. Compile all files:
   javac main/Main.java model/*.java ui/*.java utils/*.java
4. Run the application:
   java main.Main

### Login Credentials
- Username: admin
- Password: 1234

## Features
- Admin login screen
- Add and view students (name, roll number, class)
- Enter marks and auto-calculate grade (A/B/C/D/F) and pass/fail status
- All data saved to students.txt and results.txt
