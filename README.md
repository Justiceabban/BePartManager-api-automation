# BePart Manager API Automation

**Complete, production-ready automated testing suite** for the BePart Manager Backend API with comprehensive test coverage, professional Allure reporting, and extensive documentation.

## ✨ Key Features

- 🚀 **17 Comprehensive Tests** - 5 positive + 12 negative scenarios
- 📊 **Professional Allure Reporting** - Beautiful HTML dashboards
- 🔐 **Centralized Configuration** - Easy token and environment management
- 📝 **110+ Automated Assertions** - Multi-layer validation
- 🧪 **JUnit 5 Framework** - Modern testing approach
- 📈 **100% Endpoint Coverage** - All 5 Manager API endpoints tested
- 📚 **3,100+ Lines of Documentation** - Complete guides and references
- 🎯 **Production Ready** - CI/CD integration ready

## 📊 Project Statistics

| Metric | Value |
|--------|-------|
| **Total Tests** | 17 (5 positive + 12 negative) |
| **Assertions** | 110+ |
| **Endpoints** | 5 of 5 (100% coverage) |
| **Pass Rate** | 100% |
| **Execution Time** | ~50 seconds |
| **Documentation** | 3,100+ lines |
| **Code Quality** | Production ready |

## 🎯 Prerequisites

- ✅ Java 11 or higher
- ✅ Maven 3.6 or higher
- ✅ Internet connection (for API access)
- ✅ Valid Bearer token (configured in properties)

## 📁 Project Structure

```
onboarding-api-automation/
├── pom.xml                                      # Maven configuration
├── README.md                                    # This file
├── run-tests.bat                                # Execute tests
├── run-tests-with-allure.bat                    # Execute with Allure
├── serve-allure-report.bat                      # View Allure reports
│
├── src/
│   ├── main/
│   │   ├── java/com/managerApp/utils/
│   │   │   └── ConfigReader.java               # Configuration utility
│   │   └── resources/
│   │       └── config.properties                # Environment configuration
│   │
│   └── test/
│       ├── java/com/managerApp/api/
│       │   ├── BePartManagerApiTest.java        # 5 positive tests (606 lines)
│       │   └── BePartManagerApiNegativeTest.java # 12 negative tests (447 lines)
│       └── resources/
│           └── allure.properties                # Allure configuration
│
├── target/
│   ├── allure-results/                          # Test execution data
│   └── allure-report/                           # HTML reports
│
└── Documentation/                               # Complete guides
    ├── QUICK_REFERENCE.md                       # Quick commands
    ├── CONFIGURATION_SUMMARY.md                 # Configuration guide
    ├── ALLURE_GUIDE.md                          # Allure setup
    ├── ASSERTIONS_GUIDE.md                      # Assertion patterns
    ├── EXAMPLE_ASSERTIONS.md                    # Code examples
    ├── ENDPOINTS_REFERENCE.md                   # API documentation
    ├── TESTING_SUMMARY.md                       # Test details
    ├── JIRA_DOCUMENTATION.md                    # Complete docs
    ├── PROJECT_DELIVERY_SUMMARY.md              # Delivery summary
    └── PROJECT_SUMMARY.md                       # Project overview
```


## 🔧 Technology Stack

### Core Technologies
- **Java** 11+
- **Maven** 3.6+
- **JUnit 5** 5.10.0
- **REST-Assured** 5.3.2
- **Allure** 2.24.0

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

## 🎯 API Endpoints Tested

All endpoints require Bearer token authentication through the Manager API:

### Positive Test Coverage (5 Endpoints)

| # | Method | Endpoint | Test Method | Description |
|---|--------|----------|-------------|-------------|
| 1 | GET | `/api/v1/manager/buddies` | `testGetBuddies()` | Retrieve paginated list of buddies |
| 2 | GET | `/api/v1/manager/performance/{userId}/{journeyId}` | `testGetPerformanceWithJourney()` | Get user journey performance metrics |
| 3 | GET | `/api/v1/manager/buddies/{userId}` | `testGetBuddyByUserId()` | Get detailed buddy information |
| 4 | GET | `/api/v1/manager/feedback/{userId}/{journeyId}` | `testGetFeedback()` | Retrieve journey feedback data |
| 5 | GET | `/api/v1/manager/checklist/{userId}/{journeyId}` | `testGetChecklist()` | Get onboarding checklist items |

### Negative Test Coverage (12 Scenarios)

**Authentication & Security (3 tests)**
- No authentication token validation
- Invalid token handling
- Malformed token format testing

**Input Validation (4 tests)**
- Invalid user ID format validation
- Non-existent user handling
- Invalid journey ID validation
- Empty user ID path handling

**HTTP Method Validation (2 tests)**
- POST method on GET-only endpoints
- DELETE method on GET-only endpoints

**Edge Cases & Performance (3 tests)**
- Special characters in user ID
- Missing Content-Type header
- Response time validation (< 30 seconds)

## ⚙️ Configuration

### Centralized Configuration Management

All configuration is managed through `config.properties`:

```properties
# API Configuration
base.url=https://api.onboardingv2.test.gcw.ng.telekom.net
bearer.token=<your-bearer-token-here>

# Test Data
user.id=d3044832-a0f1-703b-221e-6997687e5375
journey.storyblok.id=8cfc8128-e101-4b7c-81ff-5631b3276629

# Negative Test Data
invalid.user.id=invalid-uuid-123
non.existent.user.id=99999999-9999-9999-9999-999999999999
non.existent.journey.id=00000000-0000-0000-0000-000000000000
invalid.bearer.token=invalid-token-12345
```

### Updating Configuration

**To update the Bearer token:**
1. Open `src/main/resources/config.properties`
2. Update the `bearer.token` value
3. Save the file
4. Run tests (no code recompilation needed!)

**To switch environments:**
Simply update the `base.url` in `config.properties`

## 🚀 Quick Start

### Step 1: Clone/Navigate to Project
```bash
cd C:\Users\JusticeAbban\Desktop\onboarding-api-automation
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Configure Token
Edit `src/main/resources/config.properties` and add your Bearer token

### Step 4: Run Tests
```bash
# Option 1: Using batch script (easiest)
run-tests-with-allure.bat

# Option 2: Using Maven
mvn clean test
```

### Step 5: View Allure Report
```bash
# Option 1: Using batch script
serve-allure-report.bat

# Option 2: Using Maven
mvn allure:serve
```

That's it! Your tests will run and a beautiful Allure report will open in your browser.

## 🔧 Running Tests

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

### Run Specific Test
```bash
mvn test -Dtest=BePartManagerApiTest#testGetBuddies
```

### Using IDE (IntelliJ IDEA)
1. Open the project
2. Navigate to `BePartManagerApiTest.java` or `BePartManagerApiNegativeTest.java`
3. Right-click and select "Run" or click the green play button
4. After tests complete, run `mvn allure:serve` to view report


## 📊 Expected Output

### Console Output (Sample)
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

## 📊 Allure Report Features

The Allure report provides:

### Overview Dashboard
- ✅ Total tests executed with pass/fail statistics
- ⏱️ Execution time and performance metrics
- 📈 Test trends over multiple runs
- 🎯 Test distribution by severity

### Detailed Test Results
- **Request Details**: Method, URL, Headers, Parameters
- **Response Details**: Status code, Headers, Body (formatted JSON)
- **Execution Steps**: Detailed step-by-step test flow
- **Attachments**: Request/Response data, logs
- **Timeline**: Visual representation of test execution

### Test Organization
- 📁 Grouped by Epic → Feature → Story
- 🏷️ Tagged by severity (Critical, Blocker, Normal, etc.)
- 🔍 Searchable and filterable
- 📝 With descriptions and documentation

**For complete Allure documentation**, see [ALLURE_GUIDE.md](ALLURE_GUIDE.md)



## 🆘 Troubleshooting

### Issue: Tests Fail with 401/403
**Solution:** Update the Bearer token in `src/main/resources/config.properties`

### Issue: Connection Refused
**Solution:** Verify API endpoint is accessible at configured base URL

### Issue: Maven Build Fails
**Solution:** Run `mvn clean install` to refresh dependencies

### Issue: Allure Command Not Found
**Solution:** Use `mvn allure:serve` instead or install Allure CLI

### Issue: Tests Are Slow
**Solution:** Normal - full suite takes ~50 seconds for 17 tests

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

#   B e P a r t M a n a g e r - a p i - a u t o m a t i o n  
 