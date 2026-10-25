# MiniPIS

A playground for developing a simple Patient Information System (PIS), sometimes also called "Practice Information System".

MiniPIS is very simplistic:
- it is not a template for a real PIS implementation, but intended for learning OOP with Java
- it has no user interface, only programmatically create and test your PIS model 
- it provides no persistancy, data is only accessible during run-time (no database storage)

## MiniPIS Template

MiniPIS contains a starting template that covers a Patient Information System (PIS) for a group practice.
It handles the doctors that are working at the practice.
The project contains a Java class for representing a Doctor.
There are methods to create data, process data, and to analyse data.
Study the template and then start to add new functionality according to the following requirements listed as tasks.

## New Requirements

Implement new funtionalities according to the listed requirements. The requirements are mainly some keywords, it is up to you to interpret and make sense out of it. Develop new classes, create sample objects, process them, and analyse the results. 

### Clarified Requirements and Tasks
- Doctor: add missing setter for employmentLevel +
- Doctor: validate employmentLevel in setter method +
- Doctor: add email address +
- (Optional) Doctor: validate email in setter method +
  - Hint: use regular expression for validation
- Add Patient to MiniPIS project +
  - develop a new class +
  - create demo data +
- Patient: add weight and height +
- Patient: add birth date and age +
  - Hint: what could be an attribute, what a method?
  - Hint: check LocalDate in Documentation (https://docs.oracle.com/en/java/javase/24/docs/api/index.html)
- Patient: add sex +
- Refactor Doctor and Patient classes +
  - Hint: reuse common fields and methods in a super class
- Calculate average weight and height of patients +
- Add Appointment to MiniPIS project +
  - develop a new class
  - create demo data
- Export Patients and Doctors as CSV file (take the TSV file exporting Doctors as a starting point and adapt it to CSV) +
- Optional: write JUnit test case(s)


### Unclear Requirements
Many missing concepts have been named by potential users of MiniPIS, but are not prioritized:
- Lab Test
- Assistant
- Diagnosis
- Prescription
- Drug
- Therapy
- Medication
- Nurse
- Bill
- ...
  
Prioritize, design and further develop MiniPIS according to your judgement of feature & function relevance.