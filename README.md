<<<<<<< HEAD
# 🚀 BePart Manager API Automation

<div align="center">

**Production-Ready Automated Testing Framework**

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)]()
[![Tests](https://img.shields.io/badge/tests-17%2F17%20passing-success)]()
[![Coverage](https://img.shields.io/badge/coverage-100%25-brightgreen)]()
[![Java](https://img.shields.io/badge/Java-11%2B-orange)]()
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue)]()

*Comprehensive automated testing suite for BePart Manager Backend API with professional Allure reporting*

[Quick Start](#-quick-start) · [Documentation](#-documentation) · [Features](#-features) · [API Endpoints](#-api-endpoints)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Project Statistics](#-project-statistics)
- [Quick Start](#-quick-start)
- [Project Structure](#-project-structure)
- [Technology Stack](#-technology-stack)
- [API Endpoints](#-api-endpoints)
- [Configuration](#️-configuration)
- [Running Tests](#-running-tests)
- [Allure Reports](#-allure-reports)
- [Troubleshooting](#-troubleshooting)
- [Documentation](#-documentation)
- [Author & License](#-author--license)

---

## 🎯 Overview

A **battle-tested, production-ready** automated testing framework designed specifically for the BePart Manager Backend API. This framework provides comprehensive test coverage with professional reporting and extensive documentation.

### What Makes This Special?

- ✅ **Complete Coverage**: All 5 Manager API endpoints tested with 17 comprehensive scenarios
- ✅ **Smart Validation**: 110+ automated assertions ensuring data integrity at every layer
- ✅ **Beautiful Reports**: Professional Allure HTML dashboards with detailed insights
- ✅ **Easy Configuration**: Centralized config management - no code changes needed
- ✅ **Production Ready**: Battle-tested code ready for CI/CD integration


---

## ✨ Features

<table>
<tr>
<td width="50%">

### 🧪 **Comprehensive Testing**
- 17 test scenarios (5 positive + 12 negative)
- 110+ automated assertions
- Multi-layer validation (status, structure, data)
- Edge case and error handling coverage

</td>
<td width="50%">

### 📊 **Professional Reporting**
- Beautiful Allure HTML dashboards
- Detailed request/response logging
- Step-by-step execution tracking
- Trend analysis across test runs

</td>
</tr>
<tr>
<td width="50%">

### 🔐 **Smart Configuration**
- Centralized properties management
- No code changes for token updates
- Easy environment switching
- Secure credential handling

</td>
<td width="50%">

### 📚 **Rich Documentation**
- 3,100+ lines of documentation
- Quick reference guides
- Code examples and templates
- Complete API documentation

</td>
</tr>
</table>

---

## 📊 Project Statistics

<div align="center">

| 📈 Metric | 💯 Value | ✅ Status |
|:----------|:--------:|:---------:|
| **Total Tests** | 17 | 100% Passing |
| **Positive Tests** | 5 | All Passing |
| **Negative Tests** | 12 | All Passing |
| **Assertions** | 110+ | All Validated |
| **Endpoint Coverage** | 5/5 | 100% |
| **Pass Rate** | 100% | ✅ |
| **Avg Execution Time** | ~50 sec | ⚡ |
| **Code Quality** | Production | ⭐ |

</div>

---

## 🚀 Quick Start

### Prerequisites

Ensure you have the following installed:

| Requirement | Version | Download Link |
|------------|---------|---------------|
| ☕ **Java** | 11 or higher | [Download Java](https://www.oracle.com/java/technologies/downloads/) |
| 📦 **Maven** | 3.6 or higher | [Download Maven](https://maven.apache.org/download.cgi) |
| 🌐 **Internet** | Active connection | For API access |
| 🔑 **Bearer Token** | Valid token | From your API provider |

### Installation & Setup

```bash
# Step 1: Navigate to project directory
cd C:\Users\JusticeAbban\Desktop\BePartManager-api-automation

# Step 2: Install dependencies
mvn clean install

# Step 3: Configure your Bearer token
# Edit: src/main/resources/config.properties
# Update: bearer.token=YOUR_TOKEN_HERE

# Step 4: Run tests with Allure reports
run-tests-with-allure.bat
# OR
mvn clean test

# Step 5: View Allure report (auto-opens in browser)
serve-allure-report.bat
# OR
mvn allure:serve
```

### ⚡ Quick Test Commands

```bash
# Run all tests (17 tests)
mvn test

# Run positive tests only (5 tests)
mvn test -Dtest=BePartManagerApiTest

# Run negative tests only (12 tests)
mvn test -Dtest=BePartManagerApiNegativeTest

# Run specific test
mvn test -Dtest=BePartManagerApiTest#testGetBuddies

# Generate and view Allure report
mvn allure:serve
```


---

## 📁 Project Structure

```
BePartManager-api-automation/
│
├── 📄 pom.xml                              # Maven configuration
├── 📖 README.md                            # This file
├── ▶️ run-tests.bat                        # Quick test execution
├── 🎯 run-tests-with-allure.bat            # Tests + Allure report
├── 📊 serve-allure-report.bat              # View Allure dashboard
│
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/com/managerApp/utils/
│   │   │   └── ConfigReader.java          # Configuration utility
│   │   └── 📂 resources/
│   │       └── config.properties           # Environment config
│   │
│   └── 📂 test/
│       ├── 📂 java/com/managerApp/api/
│       │   ├── BePartManagerApiTest.java        # 5 positive tests (606 lines)
│       │   └── BePartManagerApiNegativeTest.java # 12 negative tests (447 lines)
│       └── 📂 resources/
│           └── allure.properties           # Allure configuration
│
├── 📂 target/
│   ├── 📂 allure-results/                  # Test execution data
│   └── 📂 allure-report/                   # Generated HTML reports
│
└── 📂 Documentation/                       # Complete guides
    ├── QUICK_REFERENCE.md                  # Quick commands
    ├── CONFIGURATION_SUMMARY.md            # Config guide
    ├── ALLURE_GUIDE.md                     # Allure setup
    ├── ASSERTIONS_GUIDE.md                 # Assertion patterns
    ├── EXAMPLE_ASSERTIONS.md               # Code examples
    ├── ENDPOINTS_REFERENCE.md              # API docs
    ├── TESTING_SUMMARY.md                  # Test details
    ├── JIRA_DOCUMENTATION.md               # Full documentation
    ├── PROJECT_DELIVERY_SUMMARY.md         # Delivery summary
    └── PROJECT_SUMMARY.md                  # Project overview
```

---

## 🔧 Technology Stack

### Core Technologies

| Technology | Version | Purpose |
|-----------|---------|---------|
| ☕ **Java** | 11+ | Programming language |
| 📦 **Maven** | 3.6+ | Build & dependency management |
| 🧪 **JUnit 5** | 5.10.0 | Testing framework |
| 🌐 **REST-Assured** | 5.3.2 | API testing library |
| 📊 **Allure** | 2.24.0 | Test reporting |

### Key Dependencies

```xml
<dependencies>
    <!-- REST API Testing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.2</version>
    </dependency>
    
    <!-- JUnit 5 Testing Framework -->
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
    
    <!-- JSON Path Processing -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-path</artifactId>
        <version>5.3.2</version>
    </dependency>
</dependencies>
```


---

## 🎯 API Endpoints

> **Note**: All endpoints require Bearer token authentication

### ✅ Positive Test Coverage (5 Endpoints)

| # | Method | Endpoint | Test Method | Description |
|:-:|:------:|:---------|:------------|:------------|
| **1** | `GET` | `/api/v1/manager/buddies` | `testGetBuddies()` | Retrieve paginated list of buddies |
| **2** | `GET` | `/api/v1/manager/performance/{userId}/{journeyId}` | `testGetPerformanceWithJourney()` | Get user journey performance metrics |
| **3** | `GET` | `/api/v1/manager/buddies/{userId}` | `testGetBuddyByUserId()` | Get detailed buddy information |
| **4** | `GET` | `/api/v1/manager/feedback/{userId}/{journeyId}` | `testGetFeedback()` | Retrieve journey feedback data |
| **5** | `GET` | `/api/v1/manager/checklist/{userId}/{journeyId}` | `testGetChecklist()` | Get onboarding checklist items |

### ⚠️ Negative Test Coverage (12 Scenarios)

<table>
<tr>
<th>Category</th>
<th>Test Scenarios</th>
</tr>
<tr>
<td>

**🔐 Authentication & Security**
<br>(3 tests)

</td>
<td>

- ✓ No authentication token validation
- ✓ Invalid token handling
- ✓ Malformed token format testing

</td>
</tr>
<tr>
<td>

**📝 Input Validation**
<br>(4 tests)

</td>
<td>

- ✓ Invalid user ID format validation
- ✓ Non-existent user handling
- ✓ Invalid journey ID validation
- ✓ Empty user ID path handling

</td>
</tr>
<tr>
<td>

**🔄 HTTP Method Validation**
<br>(2 tests)

</td>
<td>

- ✓ POST method on GET-only endpoints
- ✓ DELETE method on GET-only endpoints

</td>
</tr>
<tr>
<td>

**⚡ Edge Cases & Performance**
<br>(3 tests)

</td>
<td>

- ✓ Special characters in user ID
- ✓ Missing Content-Type header
- ✓ Response time validation (< 30 seconds)

</td>
</tr>
</table>


---

## ⚙️ Configuration

### Centralized Configuration Management

All settings are managed in a single file: `src/main/resources/config.properties`

```properties
# API Configuration
base.url=https://api.onboardingv2.test.gcw.ng.telekom.net
bearer.token=YOUR_BEARER_TOKEN_HERE

# Test Data
user.id=d3044832-a0f1-703b-221e-6997687e5375
journey.storyblok.id=8cfc8128-e101-4b7c-81ff-5631b3276629

# Negative Test Data
invalid.user.id=invalid-uuid-123
non.existent.user.id=99999999-9999-9999-9999-999999999999
non.existent.journey.id=00000000-0000-0000-0000-000000000000
invalid.bearer.token=invalid-token-12345
```

### 🔄 Updating Configuration

#### Update Bearer Token (Most Common)

1. Open `src/main/resources/config.properties`
2. Find: `bearer.token=OLD_TOKEN`
3. Replace with: `bearer.token=NEW_TOKEN`
4. Save the file
5. Run tests - **No code compilation needed!** ✅

#### Switch Environments

Simply update the `base.url` in `config.properties`:

```properties
# Development
base.url=https://api.dev.example.com

# Staging
base.url=https://api.staging.example.com

# Production
base.url=https://api.prod.example.com
```

---

## 🔧 Running Tests

### Command Line Options

```bash
# Run all tests (17 tests)
mvn test

# Run positive tests only (5 tests)
mvn test -Dtest=BePartManagerApiTest

# Run negative tests only (12 tests)
mvn test -Dtest=BePartManagerApiNegativeTest

# Run specific test method
mvn test -Dtest=BePartManagerApiTest#testGetBuddies

# Clean, compile, and test
mvn clean test

# Generate Allure report after tests
mvn allure:report

# Generate and serve Allure report (auto-opens browser)
mvn allure:serve
```

### Using Batch Scripts (Windows)

```bash
# Execute tests
run-tests.bat

# Execute tests and generate Allure report
run-tests-with-allure.bat

# View existing Allure report
serve-allure-report.bat
```

### Using IDE (IntelliJ IDEA / Eclipse)

1. Open the project in your IDE
2. Navigate to test class:
   - `BePartManagerApiTest.java` (positive tests)
   - `BePartManagerApiNegativeTest.java` (negative tests)
3. Right-click on the test class or method
4. Select **"Run"** or click the green play button ▶️
5. After completion, run `mvn allure:serve` to view the report

---

## 📊 Expected Output

### Console Output (Sample)

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.managerApp.api.BePartManagerApiNegativeTest
✓ No auth test: Status 403 (Forbidden)
Completed: Get Buddies - No Authentication (Expect 403)
✓ Invalid token test: Status 403
Completed: Get Buddies - Invalid Token (Expect 401 or 403)
✓ Malformed token test: Status 403
Completed: Get Performance - Malformed Token (Expect 401 or 403)
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
[INFO] Total time: 50.123 s
```

---

## 📊 Allure Reports

### What You Get

The Allure framework generates **professional HTML dashboards** with:

#### 📈 Overview Dashboard
- ✅ Total tests executed with pass/fail statistics
- ⏱️ Execution time and performance metrics
- 📊 Test trends across multiple runs
- 🎯 Test distribution by severity level

#### 🔍 Detailed Test Results
- **Request Details**: HTTP method, URL, headers, parameters
- **Response Details**: Status code, headers, formatted JSON body
- **Execution Steps**: Step-by-step test flow with timestamps
- **Attachments**: Request/response data, logs, screenshots
- **Timeline**: Visual representation of test execution
- **Categorization**: Organized by Epic → Feature → Story

#### 🎨 Test Organization
- 📁 Hierarchical grouping (Epic → Feature → Story)
- 🏷️ Severity tagging (Critical, Blocker, Normal, Minor, Trivial)
- 🔍 Search and filter capabilities
- 📝 Rich descriptions and documentation
- 📊 Charts and graphs for trend analysis

### Viewing Reports

```bash
# Option 1: Using batch script
serve-allure-report.bat

# Option 2: Using Maven (auto-opens browser)
mvn allure:serve

# Option 3: Generate static HTML
mvn allure:report
# Then open: target/allure-report/index.html
```

**For complete Allure documentation**, see [ALLURE_GUIDE.md](ALLURE_GUIDE.md)

---

## 🆘 Troubleshooting

<details>
<summary><strong>❌ Tests Fail with 401 Unauthorized</strong></summary>

**Problem**: Authentication error - invalid or expired token

**Solution**:
1. Open `src/main/resources/config.properties`
2. Update `bearer.token` with a valid token
3. Save the file
4. Run tests again

```properties
bearer.token=YOUR_NEW_VALID_TOKEN_HERE
```
</details>

<details>
<summary><strong>❌ Tests Fail with 403 Forbidden</strong></summary>

**Problem**: Token is valid but lacks required permissions

**Solution**:
- Verify the token has Manager API access permissions
- Contact your API administrator for proper credentials
- Update token in `config.properties`
</details>

<details>
<summary><strong>❌ Connection Refused / Timeout</strong></summary>

**Problem**: Cannot connect to API endpoint

**Solution**:
1. Verify API is accessible: ping the base URL
2. Check VPN/network connection if required
3. Verify `base.url` in `config.properties` is correct
4. Check firewall settings
</details>

<details>
<summary><strong>❌ Maven Build Fails</strong></summary>

**Problem**: Dependencies or compilation errors

**Solution**:
```bash
# Clean and rebuild
mvn clean install

# Update dependencies
mvn dependency:purge-local-repository

# Force update
mvn clean install -U
```
</details>

<details>
<summary><strong>❌ Allure Command Not Found</strong></summary>

**Problem**: Allure CLI not installed or not in PATH

**Solution**:
Use Maven plugin instead (no CLI installation needed):
```bash
mvn allure:serve
```

Or install Allure CLI:
```bash
# Windows (using Scoop)
scoop install allure

# macOS (using Homebrew)
brew install allure
```
</details>

<details>
<summary><strong>⏱️ Tests Are Slow</strong></summary>

**Problem**: Tests taking longer than expected

**Solution**:
- This is normal - full suite takes ~50 seconds for 17 tests
- Network latency affects execution time
- Consider running specific test suites for faster feedback
</details>

## 📚 Documentation

This project includes extensive documentation:

| Document | Purpose |
|----------|---------|
| **README.md** | This file - project overview |
| **QUICK_REFERENCE.md** | Quick commands and tips |
| **CONFIGURATION_SUMMARY.md** | Configuration management guide |
| **ALLURE_GUIDE.md** | Allure reporting setup and usage |
| **ASSERTIONS_GUIDE.md** | Assertion patterns and best practices |
| **EXAMPLE_ASSERTIONS.md** | Code examples and templates |
| **ENDPOINTS_REFERENCE.md** | API endpoints documentation |
| **TESTING_SUMMARY.md** | Complete test details |
| **JIRA_DOCUMENTATION.md** | Full project documentation |
| **PROJECT_DELIVERY_SUMMARY.md** | Delivery summary for stakeholders |
| **PROJECT_SUMMARY.md** | Technical project overview |

## 🎯 Common Tasks

### Update Bearer Token (Most Common)
1. Open `src/main/resources/config.properties`
2. Find: `bearer.token=<old-token>`
3. Replace with new token
4. Save and run tests - Done! ✅

### Run Specific Test Scenario
```bash
# Single positive test
mvn test -Dtest=BePartManagerApiTest#testGetBuddies

# Single negative test
mvn test -Dtest=BePartManagerApiNegativeTest#testGetBuddies_NoAuthentication
```

### Generate Fresh Allure Report
```bash
mvn clean test
mvn allure:serve
```

## 🎓 Learning Resources

- **For quick commands**: See [QUICK_REFERENCE.md](QUICK_REFERENCE.md)
- **For Allure setup**: See [ALLURE_GUIDE.md](ALLURE_GUIDE.md)
- **For assertion patterns**: See [ASSERTIONS_GUIDE.md](ASSERTIONS_GUIDE.md)
- **For code examples**: See [EXAMPLE_ASSERTIONS.md](EXAMPLE_ASSERTIONS.md)
- **For complete docs**: See [JIRA_DOCUMENTATION.md](JIRA_DOCUMENTATION.md)

## 🏆 Project Status

- ✅ **Status**: Production Ready
- ✅ **Build**: Success
- ✅ **Tests**: 17/17 Passing (100%)
- ✅ **Coverage**: 5/5 Endpoints (100%)
- ✅ **Documentation**: Complete
- ✅ **CI/CD**: Ready for integration

## 👨‍💻 Author

**Justice Abban**  
QA Automation Engineer  
AmaliTech gGmbH

## 📅 Project Information

- **Created**: February 13, 2026
- **Last Updated**: April 15, 2026
- **Version**: 2.0
- **Status**: Production Ready

## 📄 License

Internal use only - AmaliTech gGmbH

---

**Need Help?** Check [QUICK_REFERENCE.md](QUICK_REFERENCE.md) for quick commands and common tasks!

#   B e P a r t M a n a g e r - a p i - a u t o m a t i o n 
 
 
=======
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
>>>>>>> dfba03395065abf03de40312cea0860ee7047036
