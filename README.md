# Reverse Polish Notation (RPN) Calculator

This is a command-line Java application that reads mathematical expressions in **Reverse Polish Notation (RPN)** from a file and outputs the results line-by-line.

---

## 📦 Features

- Supports standard operations: `+`, `-`, `*`, `/`
- Additional operators: `sqrt`, `sin`, `cos`, `avg`, `mod`
- Each line is evaluated independently
- Graceful handling of invalid or non-RPN input

---

## 📁 Example Input File (`input.txt`)

```
1.0 2.0 +
3 4 *
6 3 * 2 - sqrt
1 + 1
4 2 - 2 - 1000 *
```

---

## 🧾 Example Output

```
1.0 2.0 + = 3.0
3 4 * = 12.0
6 3 * 2 - sqrt = 4.0
1 + 1 - Not Reverse Polish Notation try backwards
4 2 - 2 - 1000 * = 0.0
```

---

## 🛠️ Build Instructions

This project uses **Java 17+** and **Maven**.

### 🔧 Compile the Project

```bash
mvn clean package
```

### ▶️ Run the Application

```bash
java -jar target/rpn-calculator-1.0.jar input.txt
```

> Replace `input.txt` with the path to your file containing RPN expressions.

---

## 🧪 Run Tests

```bash
mvn test
```

---

## 🧮 Supported Operators

| Operator | Arity | Description                           |
|----------|-------|---------------------------------------|
| `+`      | 2     | Addition                              |
| `-`      | 2     | Subtraction                           |
| `*`      | 2     | Multiplication                        |
| `/`      | 2     | Division                              |
| `sqrt`   | 1     | Square root                           |
| `sin`    | 1     | Sine (input in radians)               |
| `cos`    | 1     | Cosine (input in radians)             |
| `avg`    | 2     | Average of two numbers                |
| `mod`    | 2     | Modulus (remainder of division)       |

---

## 📁 Project Structure

```
rpn-calculator/
├── input.txt
├── pom.xml
├── README.md
├── src/
│   ├── main/java/com/example/rpn/
│   │   ├── ReversePolishCalculator.java
│   │   └── RpnApplication.java
│   └── test/java/com/example/rpn/
│       └── ReversePolishCalculatorTest.java
```

---

## 📝 License

This project is open for educational and production use. No external frameworks are used, only standard Java libraries.
