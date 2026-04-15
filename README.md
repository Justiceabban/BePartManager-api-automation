<div align="center">

# 🚀 BePart Manager API Automation

[![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![JUnit 5](https://img.shields.io/badge/JUnit-5.10.0-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![REST Assured](https://img.shields.io/badge/REST--Assured-5.3.2-4CAF50?style=for-the-badge)](https://rest-assured.io/)
[![Allure](https://img.shields.io/badge/Allure-2.24.0-orange?style=for-the-badge)](https://allurereport.org/)
[![License](https://img.shields.io/badge/License-Internal-blue?style=for-the-badge)](./README.md)

**Production-ready API test automation suite for the BePart Manager Backend.**  
17 tests · 110+ assertions · 100% endpoint coverage · Beautiful Allure reports.

</div>

---

## 📋 Table of Contents

1. [✨ Key Features](#-key-features)
2. [📊 Project Statistics](#-project-statistics)
3. [🛠️ Technology Stack](#️-technology-stack)
4. [📁 Project Structure](#-project-structure)
5. [🎯 Prerequisites](#-prerequisites)
6. [⚙️ Configuration](#️-configuration)
7. [🚀 Quick Start](#-quick-start)
8. [▶️ Running Tests](#️-running-tests)
9. [🔍 API Endpoints Tested](#-api-endpoints-tested)
10. [📋 Expected Output](#-expected-output)
11. [📈 Allure Report Features](#-allure-report-features)
12. [🆘 Troubleshooting](#-troubleshooting)
13. [📚 Documentation](#-documentation)
14. [🏆 Project Status](#-project-status)
15. [👨‍💻 Author](#️-author)
16. [📄 License](#-license)

---

## ✨ Key Features

| Feature | Detail |
|---------|--------|
| 🚀 **17 Comprehensive Tests** | 5 positive + 12 negative scenarios |
| 📊 **Professional Allure Reporting** | Beautiful, interactive HTML dashboards |
| 🔐 **Centralized Configuration** | Zero-code token and environment switching |
| 📝 **110+ Automated Assertions** | Multi-layer request/response validation |
| 🧪 **JUnit 5 Framework** | Modern, annotation-driven testing |
| 📈 **100% Endpoint Coverage** | All 5 Manager API endpoints tested |
| 📚 **3,100+ Lines of Docs** | Complete guides and references included |
| 🎯 **CI/CD Ready** | Plug straight into any pipeline |

---

## 📊 Project Statistics

<div align="center">

| Metric | Value |
|:------:|:-----:|
| **Total Tests** | 17 (5 positive · 12 negative) |
| **Assertions** | 110+ |
| **Endpoints Covered** | 5 / 5 — 100% |
| **Pass Rate** | ✅ 100% |
| **Avg Execution Time** | ~50 seconds |
| **Documentation** | 3,100+ lines |
| **Code Quality** | Production ready |

</div>

---

## 🛠️ Technology Stack

### Core Technologies

| Technology | Version | Role |
|:----------:|:-------:|:----:|
| ![Java](https://img.shields.io/badge/-Java-ED8B00?logo=openjdk&logoColor=white) | 11+ | Language |
| ![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apache-maven&logoColor=white) | 3.6+ | Build & dependency management |
| **JUnit 5** | 5.10.0 | Test framework |
| **REST-Assured** | 5.3.2 | HTTP client & assertions |
| **Allure** | 2.24.0 | Test reporting |

### Key Dependencies

```xml
<dependencies>
    <!-- API Testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.2</version>
    </dependency>

    <!-- Testing Framework -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
    </dependency>

    <!-- Allure Reporting -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-rest-assured</artifactId>
        <version>2.24.0</version>
    </dependency>

    <!-- JSON Processing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-path</artifactId>
        <version>5.3.2</version>
    </dependency>
</dependencies>
```

---

## 📁 Project Structure

```
BePartManager-api-automation/
├── 📄 pom.xml                                   # Maven configuration
├── 📖 README.md                                 # This file
├── 🖥️ run-tests.bat                             # Execute tests (Windows)
├── 🖥️ run-tests-with-allure.bat                 # Execute with Allure (Windows)
├── 🖥️ serve-allure-report.bat                   # View Allure reports (Windows)
│
├── src/
│   ├── main/
│   │   ├── java/com/managerApp/utils/
│   │   │   └── ConfigReader.java               # Configuration utility
│   │   └── resources/
│   │       └── config.properties               # Environment configuration
│   │
│   └── test/
│       ├── java/com/managerApp/api/
│       │   ├── BePartManagerApiTest.java        # ✅ 5 positive tests
│       │   └── BePartManagerApiNegativeTest.java # ❌ 12 negative tests
│       └── resources/
│           └── allure.properties               # Allure configuration
│
├── target/
│   ├── allure-results/                          # Raw test execution data
│   └── allure-report/                           # Generated HTML report
│
└── Documentation/                               # Complete reference guides
    ├── QUICK_REFERENCE.md
    ├── CONFIGURATION_SUMMARY.md
    ├── ALLURE_GUIDE.md
    ├── ASSERTIONS_GUIDE.md
    ├── EXAMPLE_ASSERTIONS.md
    ├── ENDPOINTS_REFERENCE.md
    ├── TESTING_SUMMARY.md
    ├── JIRA_DOCUMENTATION.md
    ├── PROJECT_DELIVERY_SUMMARY.md
    └── PROJECT_SUMMARY.md
```

---

## 🎯 Prerequisites

> Ensure the following are installed before getting started.

- ✅ **Java 11** or higher — [Download](https://adoptium.net/)
- ✅ **Maven 3.6** or higher — [Download](https://maven.apache.org/download.cgi)
- ✅ **Internet connection** — required to reach the API
- ✅ **Valid Bearer token** — configured in `config.properties`

---

## ⚙️ Configuration

All configuration lives in a single file: `src/main/resources/config.properties`

```properties
# ─── API Configuration ──────────────────────────────────────────────────────
base.url=https://api.onboardingv2.test.gcw.ng.telekom.net
bearer.token=<your-bearer-token-here>

# ─── Test Data ──────────────────────────────────────────────────────────────
user.id=d3044832-a0f1-703b-221e-6997687e5375
journey.storyblok.id=8cfc8128-e101-4b7c-81ff-5631b3276629

# ─── Negative Test Data ─────────────────────────────────────────────────────
invalid.user.id=invalid-uuid-123
non.existent.user.id=99999999-9999-9999-9999-999999999999
non.existent.journey.id=00000000-0000-0000-0000-000000000000
invalid.bearer.token=invalid-token-12345
```

### 🔑 Updating the Bearer Token

```
1. Open  src/main/resources/config.properties
2. Replace the bearer.token value
3. Save — no recompilation needed!
```

### 🌐 Switching Environments

Update `base.url` in `config.properties` to point at any target environment. That's it.

---

## 🚀 Quick Start

```bash
# 1. Clone the repository
git clone https://github.com/Justiceabban/BePartManager-api-automation.git
cd BePartManager-api-automation

# 2. Install all dependencies
mvn clean install

# 3. Add your Bearer token to src/main/resources/config.properties

# 4. Run the full test suite
mvn clean test                   # Maven (cross-platform)
# OR
run-tests-with-allure.bat        # Windows batch script

# 5. View the Allure report
mvn allure:serve                 # Maven (cross-platform)
# OR
serve-allure-report.bat          # Windows batch script
```

> 💡 A browser window will open automatically with the interactive Allure report.

---

## ▶️ Running Tests

### All Tests (17 tests)

```bash
mvn test
```

### Positive Tests Only (5 tests)

```bash
mvn test -Dtest=BePartManagerApiTest
```

### Negative Tests Only (12 tests)

```bash
mvn test -Dtest=BePartManagerApiNegativeTest
```

### A Specific Test Method

```bash
# Single positive test
mvn test -Dtest=BePartManagerApiTest#testGetBuddies

# Single negative test
mvn test -Dtest=BePartManagerApiNegativeTest#testGetBuddies_NoAuthentication
```

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `BePartManagerApiTest.java` or `BePartManagerApiNegativeTest.java`
3. Click the ▶️ **Run** button next to any test class or method
4. After tests complete, run `mvn allure:serve` to view the report

---

## 🔍 API Endpoints Tested

> All endpoints require **Bearer token** authentication.

### ✅ Positive Test Coverage (5 Endpoints)

| # | Method | Endpoint | Test Method | Description |
|---|:------:|----------|-------------|-------------|
| 1 | `GET` | `/api/v1/manager/buddies` | `testGetBuddies()` | Paginated list of buddies |
| 2 | `GET` | `/api/v1/manager/performance/{userId}/{journeyId}` | `testGetPerformanceWithJourney()` | User journey performance metrics |
| 3 | `GET` | `/api/v1/manager/buddies/{userId}` | `testGetBuddyByUserId()` | Detailed buddy information |
| 4 | `GET` | `/api/v1/manager/feedback/{userId}/{journeyId}` | `testGetFeedback()` | Journey feedback data |
| 5 | `GET` | `/api/v1/manager/checklist/{userId}/{journeyId}` | `testGetChecklist()` | Onboarding checklist items |

### ❌ Negative Test Coverage (12 Scenarios)

<details>
<summary><strong>🔐 Authentication &amp; Security (3 tests)</strong></summary>

- No authentication token — expects `401`/`403`
- Invalid token — expects `401`/`403`
- Malformed token format — expects `401`/`403`
</details>

<details>
<summary><strong>🔎 Input Validation (4 tests)</strong></summary>

- Invalid user ID format — expects `400`/`404`
- Non-existent user ID — expects `404`
- Invalid journey ID — expects `400`/`404`
- Empty user ID path — expects `400`/`404`
</details>

<details>
<summary><strong>🌐 HTTP Method Validation (2 tests)</strong></summary>

- `POST` on a GET-only endpoint — expects `405`
- `DELETE` on a GET-only endpoint — expects `405`
</details>

<details>
<summary><strong>⚡ Edge Cases &amp; Performance (3 tests)</strong></summary>

- Special characters in user ID
- Missing `Content-Type` header
- Response time validation — must complete in &lt; 30 seconds
</details>

---

## 📋 Expected Output

### Console Output (Sample)

```console
[INFO] Running com.managerApp.api.BePartManagerApiNegativeTest
✓ No auth test: Status 403 (Forbidden)
✓ Invalid token test: Status 403
...
========================================
Negative tests completed!
========================================
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

[INFO] Running com.managerApp.api.BePartManagerApiTest
Status Code: 200
✓ Test completed: Get Buddies List
Status Code: 200
✓ Test completed: Get Performance with Journey
...
========================================
All tests completed!
========================================
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] Results:
[INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 📈 Allure Report Features

### Overview Dashboard

| Feature | Details |
|---------|---------|
| 📊 **Statistics** | Total tests, pass/fail breakdown |
| ⏱️ **Performance** | Execution time per test and overall |
| 📈 **Trends** | Historical pass/fail trends across runs |
| 🎯 **Severity** | Distribution by Critical / Blocker / Normal |

### Detailed Test Results

- **Request** — method, URL, headers, parameters
- **Response** — status code, headers, formatted JSON body
- **Steps** — granular step-by-step execution trace
- **Attachments** — request/response payloads and logs
- **Timeline** — visual test execution waterfall

### Test Organisation

- 📁 Grouped by **Epic → Feature → Story**
- 🏷️ Tagged by severity
- 🔍 Searchable and filterable
- 📝 Rich descriptions and inline documentation

> 📖 See [ALLURE_GUIDE.md](Documentation/ALLURE_GUIDE.md) for the full Allure setup guide.

---

## 🆘 Troubleshooting

| Problem | Solution |
|---------|----------|
| **Tests fail with 401 / 403** | Update `bearer.token` in `config.properties` |
| **Connection refused** | Verify the API is reachable at the configured `base.url` |
| **Maven build fails** | Run `mvn clean install` to refresh all dependencies |
| **`allure` command not found** | Use `mvn allure:serve` instead, or install the [Allure CLI](https://allurereport.org/docs/install/) |
| **Tests are slow** | Expected — the full suite takes ~50 seconds for 17 tests |

---

## 📚 Documentation

All documents live in the [`Documentation/`](Documentation/) folder.

| Document | Purpose |
|----------|---------|
| [`QUICK_REFERENCE.md`](Documentation/QUICK_REFERENCE.md) | Quick commands and tips |
| [`CONFIGURATION_SUMMARY.md`](Documentation/CONFIGURATION_SUMMARY.md) | Configuration management guide |
| [`ALLURE_GUIDE.md`](Documentation/ALLURE_GUIDE.md) | Allure reporting setup and usage |
| [`ASSERTIONS_GUIDE.md`](Documentation/ASSERTIONS_GUIDE.md) | Assertion patterns and best practices |
| [`EXAMPLE_ASSERTIONS.md`](Documentation/EXAMPLE_ASSERTIONS.md) | Code examples and templates |
| [`ENDPOINTS_REFERENCE.md`](Documentation/ENDPOINTS_REFERENCE.md) | Full API endpoints reference |
| [`TESTING_SUMMARY.md`](Documentation/TESTING_SUMMARY.md) | Complete test details |
| [`JIRA_DOCUMENTATION.md`](Documentation/JIRA_DOCUMENTATION.md) | Full project documentation |
| [`PROJECT_DELIVERY_SUMMARY.md`](Documentation/PROJECT_DELIVERY_SUMMARY.md) | Delivery summary for stakeholders |
| [`PROJECT_SUMMARY.md`](Documentation/PROJECT_SUMMARY.md) | Technical project overview |

---

## 🏆 Project Status

<div align="center">

| Item | Status |
|:----:|:------:|
| **Build** | ✅ Passing |
| **Tests** | ✅ 17 / 17 (100%) |
| **Endpoint Coverage** | ✅ 5 / 5 (100%) |
| **Documentation** | ✅ Complete |
| **CI/CD Readiness** | ✅ Pipeline-ready |

</div>

---

## 👨‍💻 Author

<div align="center">

**Justice Abban**  
*QA Automation Engineer*  
AmaliTech gGmbH

</div>

---

## 📄 License

Internal use only — **AmaliTech gGmbH**

---

<div align="center">

> 💡 **Need help fast?** Check [QUICK_REFERENCE.md](Documentation/QUICK_REFERENCE.md) for the most common commands and tips.

</div>
