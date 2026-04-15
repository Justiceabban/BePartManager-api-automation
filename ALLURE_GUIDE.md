# Allure Report Integration Guide

## Overview

This project now includes **Allure Report** integration for beautiful, comprehensive test reporting with REST-Assured API tests.

## What is Allure?

Allure is a flexible, lightweight test report tool that provides:
- Beautiful, modern UI for test reports
- Detailed test execution history
- Request/Response details for API tests
- Screenshots and attachments
- Test categorization and filtering
- Trend analysis and statistics

## Project Updates

### Dependencies Added

1. **allure-rest-assured** (v2.24.0) - Allure integration for REST-Assured
2. **allure-junit5** (v2.24.0) - Allure integration for JUnit 5
3. **aspectjweaver** (v1.9.20.1) - Required for Allure annotations
4. **allure-maven plugin** (v2.12.0) - Maven plugin for report generation

### New Test Class

**`OnboardingAPITest.java`** - Located in `src/test/java/com/amalitech/api/`

This JUnit 5 test class includes:
- `@Epic`, `@Feature`, `@Story` annotations for test organization
- `@Description` and `@DisplayName` for readable test names
- `@Severity` annotations to mark test importance
- `@Step` annotations for detailed test steps
- Allure attachments for request/response data

### Configuration Files

1. **`allure.properties`** - Allure configuration in `src/test/resources/`
2. **Updated `pom.xml`** - Maven configuration with Allure plugins

## How to Use

### Method 1: Using Batch Scripts (Easiest)

#### Run Tests:
```bash
run-tests-with-allure.bat
```
This will:
- Clean previous test results
- Run all tests with Allure reporting
- Generate Allure results in `target/allure-results`

#### View Report:
```bash
serve-allure-report.bat
```
This will:
- Generate the HTML report
- Start a local web server
- Open the report in your default browser

### Method 2: Using Maven Commands

#### Run tests and generate results:
```bash
mvn clean test
```

#### Generate and serve report:
```bash
mvn allure:serve
```

#### Generate static HTML report:
```bash
mvn allure:report
```
Report will be in `target/site/allure-maven-plugin/`

## Allure Annotations Used

### Class Level:
- `@Epic("Onboarding Backend API")` - High-level feature grouping
- `@Feature("Manager API Endpoints")` - Feature grouping
- `@TestMethodOrder` - Control test execution order

### Method Level:
- `@Test` - Marks method as a test
- `@Order(n)` - Controls test execution sequence
- `@Story("Story Name")` - Groups related tests
- `@Description("...")` - Detailed test description
- `@Severity(SeverityLevel.CRITICAL)` - Test importance level
- `@DisplayName("...")` - Human-readable test name

### Runtime:
- `Allure.step("...")` - Add detailed test steps
- `Allure.parameter("key", "value")` - Add test parameters
- `Allure.addAttachment("name", "type", "content")` - Add attachments

## Report Features

### 1. Overview Dashboard
- Total tests executed
- Pass/Fail statistics
- Execution time
- Trends over multiple runs

### 2. Test Suites
- Organized by Epic → Feature → Story
- Expandable test cases
- Severity indicators
- Tags and categories

### 3. API Test Details
For each test, you'll see:
- **Request Details**:
  - HTTP Method
  - URL
  - Headers (including Authorization)
  - Path Parameters
  - Query Parameters
  
- **Response Details**:
  - Status Code
  - Response Headers
  - Response Body (formatted JSON)
  - Response Time

### 4. Timeline
- Visual timeline of test execution
- Parallel execution visualization
- Duration analysis

### 5. Behaviors
- Tests organized by user stories
- BDD-style reporting

### 6. Categories
- Broken tests
- Failed tests
- Passed tests
- Flaky tests

## Understanding the Reports

### Test Status Icons:
- ✅ **Passed** - Test executed successfully
- ❌ **Failed** - Test failed with assertion error
- ⚠️ **Broken** - Test failed with exception (like Connection Refused)
- ⏭️ **Skipped** - Test was skipped

### Severity Levels:
- **Blocker** - Critical functionality
- **Critical** - Major features (used for our API tests)
- **Normal** - Standard functionality
- **Minor** - Less important features
- **Trivial** - UI/cosmetic issues

## Test Execution Flow

1. **Setup Phase** (`@BeforeAll`)
   - Initialize base URI
   - Log test parameters to Allure

2. **Test Execution** (Each `@Test` method)
   - Create authenticated request with Allure filter
   - Execute API call
   - Capture request/response
   - Validate status code
   - Attach response to report

3. **Teardown Phase** (`@AfterEach`, `@AfterAll`)
   - Log test completion
   - Clean up resources

## Viewing Previous Reports

Allure keeps history of test runs. To see trends:

1. Run tests multiple times
2. Each run adds to history
3. View trends in the "Graphs" section
4. Compare execution times
5. Identify flaky tests

## Troubleshooting

### Issue: "No test results found"
**Solution**: Run `mvn clean test` first to generate results

### Issue: Browser doesn't open automatically
**Solution**: Manually open the URL shown in console (usually http://localhost:port)

### Issue: Port already in use
**Solution**: Stop the previous Allure server or use `mvn allure:report` to generate static HTML

### Issue: Tests show as "Broken"
**Solution**: This is expected if the backend API isn't running. The test structure and Allure integration are working correctly. Start your backend API to see tests pass.

## Best Practices

1. **Run tests regularly** - Build up execution history
2. **Use meaningful test names** - Makes reports easier to understand
3. **Add detailed steps** - Use `Allure.step()` for complex test flows
4. **Attach evidence** - Screenshots, logs, request/response data
5. **Set appropriate severity** - Helps prioritize test failures
6. **Organize by stories** - Groups related tests together

## Example Report Structure

```
📊 Onboarding Backend API
├── 📁 Manager API Endpoints
│   ├── 📖 Buddies Management
│   │   └── ✅ Get Buddies List
│   ├── 📖 Performance Management
│   │   ├── ✅ Get Performance with Journey
│   │   └── ✅ Get User Performance
│   ├── 📖 Feedback Management
│   │   └── ✅ Get Feedback Data
│   └── 📖 Checklist Management
│       └── ✅ Get Checklist Data
```

## Integration with CI/CD

To integrate with CI/CD pipelines:

```yaml
# Example GitHub Actions
- name: Run Tests
  run: mvn clean test

- name: Generate Allure Report
  run: mvn allure:report

- name: Publish Report
  uses: actions/upload-artifact@v2
  with:
    name: allure-report
    path: target/site/allure-maven-plugin/
```

## Customization

### Change Report Title
Edit `allure.properties`:
```properties
allure.results.directory=target/allure-results
allure.report.title=My Custom Report Title
```

### Add Custom Categories
Create `categories.json` in `src/test/resources/`:
```json
[
  {
    "name": "API Errors",
    "matchedStatuses": ["broken"],
    "messageRegex": ".*ConnectException.*"
  }
]
```

### Add Environment Information
Create `environment.properties`:
```properties
Browser=Chrome
Environment=QA
Backend.Version=1.0.0
API.URL=http://localhost:8080
```

## Resources

- **Allure Documentation**: https://docs.qameta.io/allure/
- **Allure REST-Assured**: https://docs.qameta.io/allure/#_rest_assured
- **Allure JUnit 5**: https://docs.qameta.io/allure/#_junit_5

## Summary

Your project now has:
- ✅ Complete Allure integration
- ✅ Beautiful test reports
- ✅ Detailed API request/response logging
- ✅ Test execution history and trends
- ✅ Easy-to-use batch scripts
- ✅ Professional test documentation

**To get started**: Run `run-tests-with-allure.bat`, then `serve-allure-report.bat` to see your first Allure report!

