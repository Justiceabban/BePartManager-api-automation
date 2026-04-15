@echo off
REM Script to run tests and generate Allure results
REM After running this, use serve-allure-report.bat to view the report

echo ========================================
echo Running Tests with Allure
echo ========================================
echo.

cd /d "%~dp0"

echo Running tests...
mvn clean test

echo.
echo ========================================
echo Tests completed!
echo ========================================
echo.
echo Allure results saved to: target\allure-results
echo.
echo To view the report, run: serve-allure-report.bat
echo Or use command: mvn allure:serve
echo.
pause

