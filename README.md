# JSON Parser and MD5 Hash Generator

A simple Java program that reads a JSON file, extracts specific fields, and generates an MD5 hash.

## Files

- `src/main/java/HashGenerator.java` - Main Java source code
- `input.json` - Input JSON file containing student information
- `output.txt` - Output file containing the generated MD5 hash

## How to Run

1. Make sure you have Java installed
2. Compile the program:
   ```
   javac src/main/java/HashGenerator.java
   ```
3. Run the program:
   ```
   java -cp src/main/java HashGenerator
   ```
4. Check `output.txt` for the generated hash

## Input Format

The input.json file should have this format:
```json
{
    "institute_name": "xyz",
    "student": {
        "first_name": "yourname",
        "roll_number": "yourrollnumber"
    }
}
```

## Output Format

The output.txt file will contain a single line with the MD5 hash of the concatenated first_name and roll_number.
