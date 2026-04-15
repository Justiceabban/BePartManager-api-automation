@echo off
REM Script to generate and serve Allure report
REM This will generate the report and open it in your default browser

echo ========================================
echo Generating Allure Report
echo ========================================
echo.

cd /d "%~dp0"

echo Generating report from test results...
mvn allure:serve

echo.
echo ========================================
echo Report server stopped
echo ========================================
pause

