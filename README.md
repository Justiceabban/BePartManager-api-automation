# BePart Manager API Automation

> **Complete, production-ready automated testing suite** for the BePart Manager Backend API — featuring comprehensive test coverage, professional Allure reporting, and extensive documentation.

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](.) [![Tests](https://img.shields.io/badge/tests-17%2F17%20passing-brightgreen)](.) [![Coverage](https://img.shields.io/badge/coverage-100%25-brightgreen)](.) [![Java](https://img.shields.io/badge/java-11%2B-blue)](.) [![Maven](https://img.shields.io/badge/maven-3.6%2B-blue)](.)

---

## 📋 Table of Contents

1. [Key Features](#-key-features)
2. [Project Statistics](#-project-statistics)
3. [Prerequisites](#-prerequisites)
4. [Project Structure](#-project-structure)
5. [Technology Stack](#-technology-stack)
6. [API Endpoints Tested](#-api-endpoints-tested)
7. [Configuration](#️-configuration)
8. [Quick Start](#-quick-start)
9. [Running Tests](#-running-tests)
10. [Expected Output](#-expected-output)
11. [Allure Reports](#-allure-reports)
12. [Troubleshooting](#-troubleshooting)
13. [Documentation](#-documentation)
14. [Common Tasks](#-common-tasks)
15. [Project Status](#-project-status)
16. [Author](#-author)

---

## ✨ Key Features

| Feature | Details |
|---------|---------|
| 🚀 **17 Comprehensive Tests** | 5 positive + 12 negative scenarios |
| 📊 **Professional Allure Reporting** | Beautiful HTML dashboards with trend analysis |
| 🔐 **Centralized Configuration** | Single-file token and environment management |
| 📝 **110+ Automated Assertions** | Multi-layer response validation |
| 🧪 **JUnit 5 Framework** | Modern, annotation-driven testing |
| 📈 **100% Endpoint Coverage** | All 5 Manager API endpoints tested |
| 📚 **3,100+ Lines of Documentation** | Complete guides and references |
| 🎯 **Production Ready** | CI/CD integration ready |

---

## 📊 Project Statistics

| Metric | Value |
|--------|-------|
| **Total Tests** | 17 (5 positive + 12 negative) |
| **Assertions** | 110+ |
| **Endpoints Covered** | 5 of 5 (100%) |
| **Pass Rate** | 100% |
| **Avg. Execution Time** | ~50 seconds |
| **Documentation** | 3,100+ lines |
| **Code Quality** | Production ready |

---

## ✅ Prerequisites

Before running the project, ensure the following are installed and available:

- **Java** 11 or higher
- **Maven** 3.6 or higher
- **Internet connection** (required for API access)
- **Valid Bearer token** (configured in `config.properties`)

---

## 📁 Project Structure

```
BePartManager-api-automation/
├── pom.xml                                        # Maven build configuration
├── README.md                                      # This file
├── run-tests.bat                                  # Execute all tests
├── run-tests-with-allure.bat                      # Execute tests + generate report
├── serve-allure-report.bat                        # Serve Allure HTML report
│
├── src/
│   ├── main/
│   │   ├── java/com/managerApp/utils/
│   │   │   └── ConfigReader.java                 # Configuration utility
│   │   └── resources/
│   │       └── config.properties                  # Environment & test data
│   │
│   └── test/
│       ├── java/com/managerApp/api/
│       │   ├── BePartManagerApiTest.java          # 5 positive tests
│       │   └── BePartManagerApiNegativeTest.java  # 12 negative tests
│       └── resources/
│           └── allure.properties                  # Allure reporting config
│
├── target/
│   ├── allure-results/                            # Raw test execution data
│   └── allure-report/                             # Generated HTML report
│
└── Documentation/                                 # Supplementary guides
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

## 🔧 Technology Stack

### Core Technologies

| Technology | Version |
|-----------|---------|
| **Java** | 11+ |
| **Maven** | 3.6+ |
| **JUnit 5** | 5.10.0 |
| **REST-Assured** | 5.3.2 |
| **Allure** | 2.24.0 |

### Key Maven Dependencies

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

## 🌐 API Endpoints Tested

All endpoints require **Bearer token authentication** via the Manager API.

### Positive Test Coverage (5 Endpoints)

| # | Method | Endpoint | Test Method | Description |
|---|--------|----------|-------------|-------------|
| 1 | `GET` | `/api/v1/manager/buddies` | `testGetBuddies()` | Retrieve paginated list of buddies |
| 2 | `GET` | `/api/v1/manager/performance/{userId}/{journeyId}` | `testGetPerformanceWithJourney()` | Get user journey performance metrics |
| 3 | `GET` | `/api/v1/manager/buddies/{userId}` | `testGetBuddyByUserId()` | Get detailed buddy information |
| 4 | `GET` | `/api/v1/manager/feedback/{userId}/{journeyId}` | `testGetFeedback()` | Retrieve journey feedback data |
| 5 | `GET` | `/api/v1/manager/checklist/{userId}/{journeyId}` | `testGetChecklist()` | Get onboarding checklist items |

### Negative Test Coverage (12 Scenarios)

<details>
<summary><strong>🔐 Authentication &amp; Security (3 tests)</strong></summary>

- No authentication token validation
- Invalid token handling
- Malformed token format testing

</details>

<details>
<summary><strong>🛡️ Input Validation (4 tests)</strong></summary>

- Invalid user ID format validation
- Non-existent user handling
- Invalid journey ID validation
- Empty user ID path handling

</details>

<details>
<summary><strong>🔁 HTTP Method Validation (2 tests)</strong></summary>

- `POST` method on GET-only endpoints
- `DELETE` method on GET-only endpoints

</details>

<details>
<summary><strong>⚡ Edge Cases &amp; Performance (3 tests)</strong></summary>

- Special characters in user ID
- Missing `Content-Type` header
- Response time validation (< 30 seconds)

</details>

---

## ⚙️ Configuration

All configuration is managed centrally through a single file: `src/main/resources/config.properties`

```properties
# ──────────────────────────────────────────
# API Configuration
# ──────────────────────────────────────────
base.url=https://api.onboardingv2.test.gcw.ng.telekom.net
bearer.token=<your-bearer-token-here>

# ──────────────────────────────────────────
# Positive Test Data
# ──────────────────────────────────────────
user.id=d3044832-a0f1-703b-221e-6997687e5375
journey.storyblok.id=8cfc8128-e101-4b7c-81ff-5631b3276629

# ──────────────────────────────────────────
# Negative Test Data
# ──────────────────────────────────────────
invalid.user.id=invalid-uuid-123
non.existent.user.id=99999999-9999-9999-9999-999999999999
non.existent.journey.id=00000000-0000-0000-0000-000000000000
invalid.bearer.token=invalid-token-12345
```

### How to Update Configuration

**Update the Bearer token:**
1. Open `src/main/resources/config.properties`
2. Replace the `bearer.token` value with your new token
3. Save the file — no recompilation needed

**Switch environments:**  
Update only the `base.url` value in `config.properties`

---

## 🚀 Quick Start

### Step 1: Clone the Repository
```bash
git clone https://github.com/Justiceabban/BePartManager-api-automation.git
cd BePartManager-api-automation
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Configure Your Bearer Token
Edit `src/main/resources/config.properties` and set your Bearer token value.

### Step 4: Run the Tests
```bash
# Option A: Batch script (Windows, recommended)
run-tests-with-allure.bat

# Option B: Maven command
mvn clean test
```

### Step 5: View the Allure Report
```bash
# Option A: Batch script (Windows)
serve-allure-report.bat

# Option B: Maven command
mvn allure:serve
```

Your tests will execute and an interactive Allure report will open automatically in your browser. ✅

---

## ▶️ Running Tests

### Run All Tests (17 tests)
```bash
mvn test
```

### Run Positive Tests Only (5 tests)
```bash
mvn test -Dtest=BePartManagerApiTest
```

### Run Negative Tests Only (12 tests)
```bash
mvn test -Dtest=BePartManagerApiNegativeTest
```

### Run a Specific Test Method
```bash
mvn test -Dtest=BePartManagerApiTest#testGetBuddies
```

### Run via IDE (IntelliJ IDEA)
1. Open the project in IntelliJ IDEA
2. Navigate to `BePartManagerApiTest.java` or `BePartManagerApiNegativeTest.java`
3. Right-click the class or method → **Run**
4. After tests complete, run `mvn allure:serve` to view the report

---

## 📤 Expected Output

### Sample Console Output
```
[INFO] Running com.managerApp.api.BePartManagerApiNegativeTest
✓ No auth test: Status 403 (Forbidden)
Completed: Get Buddies - No Authentication (Expect 403)
✓ Invalid token test: Status 403
Completed: Get Buddies - Invalid Token (Expect 401 or 403)
...
========================================
Negative tests completed!
========================================
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

[INFO] Running com.managerApp.api.BePartManagerApiTest
Status Code: 200
Response Body: {"content":[...]}
✓ Test completed: Get Buddies List
Status Code: 200
Response Body: {"id":"87af2190-bacb-4eaa-8c7f-7d2de8446556"...}
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

## 📊 Allure Reports

The generated Allure report provides rich, interactive test insights:

### Overview Dashboard
- ✅ Total tests executed with pass/fail breakdown
- ⏱️ Execution time and performance metrics
- 📈 Test trend graphs across multiple runs
- 🎯 Test distribution by severity level

### Detailed Test Results
- **Request Details** — Method, URL, Headers, Query Parameters
- **Response Details** — Status code, Headers, formatted JSON body
- **Execution Steps** — Step-by-step test flow with timing
- **Attachments** — Raw request/response data and logs
- **Timeline View** — Visual parallel execution timeline

### Test Organization
- 📁 Grouped by **Epic → Feature → Story** hierarchy
- 🏷️ Tagged by severity (`Critical`, `Blocker`, `Normal`, etc.)
- 🔍 Fully searchable and filterable
- 📝 Inline descriptions and documentation links

> 📖 For full Allure setup and usage guidance, see [ALLURE_GUIDE.md](Documentation/ALLURE_GUIDE.md)

---

## 🆘 Troubleshooting

| Symptom | Solution |
|---------|---------|
| **Tests fail with 401 / 403** | Update `bearer.token` in `config.properties` |
| **Connection refused** | Verify the API endpoint is reachable at `base.url` |
| **Maven build fails** | Run `mvn clean install` to refresh all dependencies |
| **`allure` command not found** | Use `mvn allure:serve` instead, or install the [Allure CLI](https://allurereport.org/docs/install/) |
| **Tests seem slow** | Expected — the full suite takes ~50 seconds for 17 tests |

---

## 📚 Documentation

| Document | Description |
|----------|-------------|
| [README.md](README.md) | Project overview (this file) |
| [QUICK_REFERENCE.md](Documentation/QUICK_REFERENCE.md) | Quick commands and tips |
| [CONFIGURATION_SUMMARY.md](Documentation/CONFIGURATION_SUMMARY.md) | Configuration management guide |
| [ALLURE_GUIDE.md](Documentation/ALLURE_GUIDE.md) | Allure reporting setup and usage |
| [ASSERTIONS_GUIDE.md](Documentation/ASSERTIONS_GUIDE.md) | Assertion patterns and best practices |
| [EXAMPLE_ASSERTIONS.md](Documentation/EXAMPLE_ASSERTIONS.md) | Code examples and templates |
| [ENDPOINTS_REFERENCE.md](Documentation/ENDPOINTS_REFERENCE.md) | Full API endpoints reference |
| [TESTING_SUMMARY.md](Documentation/TESTING_SUMMARY.md) | Detailed test descriptions |
| [JIRA_DOCUMENTATION.md](Documentation/JIRA_DOCUMENTATION.md) | Full JIRA-ready project documentation |
| [PROJECT_DELIVERY_SUMMARY.md](Documentation/PROJECT_DELIVERY_SUMMARY.md) | Delivery summary for stakeholders |
| [PROJECT_SUMMARY.md](Documentation/PROJECT_SUMMARY.md) | Technical project overview |

---

## 🛠️ Common Tasks

### Update Bearer Token
```
1. Open  src/main/resources/config.properties
2. Find:    bearer.token=<old-token>
3. Replace: bearer.token=<new-token>
4. Save and re-run tests ✅
```

### Run a Specific Test Scenario
```bash
# Single positive test
mvn test -Dtest=BePartManagerApiTest#testGetBuddies

# Single negative test
mvn test -Dtest=BePartManagerApiNegativeTest#testGetBuddies_NoAuthentication
```

### Generate a Fresh Allure Report
```bash
mvn clean test
mvn allure:serve
```

---

## 🏆 Project Status

| Item | Status |
|------|--------|
| **Build** | ✅ Passing |
| **Tests** | ✅ 17/17 Passing (100%) |
| **Endpoint Coverage** | ✅ 5/5 (100%) |
| **Documentation** | ✅ Complete |
| **CI/CD Readiness** | ✅ Ready for integration |

---

## 👨‍💻 Author

**Justice Abban**  
QA Automation Engineer — AmaliTech gGmbH

---

## 📅 Project Information

| Field | Value |
|-------|-------|
| **Created** | February 13, 2026 |
| **Last Updated** | April 15, 2026 |
| **Version** | 2.0 |
| **License** | Internal use only — AmaliTech gGmbH |

---

> 💡 **Need help?** Start with [QUICK_REFERENCE.md](Documentation/QUICK_REFERENCE.md) for the most common commands and shortcuts.
