@echo off
REM Quick Start Script for Onboarding API Automation
REM This script runs all API tests

echo ========================================
echo Onboarding API Automation
echo ========================================
echo.

REM Check if Maven is installed
where mvn >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Maven is not installed or not in PATH
    echo Please install Maven and add it to your PATH
    pause
    exit /b 1
)

echo Maven found. Starting tests...
echo.

REM Run the automation
cd /d "%~dp0"
mvn compile exec:java -Dexec.mainClass="com.managerApp.api.OnboardingAPIAutomation" -q

echo.
echo ========================================
echo Test execution completed
echo ========================================
pause

