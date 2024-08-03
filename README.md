# Sample Test Automation Framework

Welcome to the **Sample Test Automation Framework**! This project is designed to provide a comprehensive and scalable approach to automated testing for web applications. The framework is split into two distinct modules: **API Testing Framework** and **UI Testing Framework**. This modular design allows for focused testing strategies and better organization of test cases.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Modules](#modules)
    - [API Testing Framework](#api-testing-framework)
    - [UI Testing Framework](#ui-testing-framework)
3. [Technologies Used](#technologies-used)
4. [Installation](#installation)
5. [Running Tests](#running-tests)
6. [Contributing](#contributing)
7. [License](#license)
8. [Contact](#contact)

## Project Overview

The Sample Test Automation Framework aims to simplify the process of testing web applications by providing reusable components and a structured approach to both API and UI testing. The project uses Java as the primary programming language, with Selenium for UI testing and Rest Assured for API testing.

## Modules

### API Testing Framework

The **API Testing Framework** module focuses on testing RESTful APIs. It uses the Rest Assured library to perform various HTTP requests and validate responses. This module includes:

- **Base Test Classes:** Common setup and teardown logic for API tests.
- **Request Builders:** Reusable methods for creating API requests.
- **Response Validators:** Utility methods for validating API responses.
- **Test Cases:** Specific API test cases organized by feature.

### UI Testing Framework

The **UI Testing Framework** module is dedicated to web UI testing. It leverages Selenium WebDriver to interact with web elements and perform user actions. This module includes:

- **Page Object Model (POM):** Encapsulation of page elements and actions for better maintainability.
- **Base Test Classes:** Common setup and teardown logic for UI tests.
- **Test Cases:** Specific UI test cases organized by feature.
- **Utilities:** Common utilities like browser management and screenshot capture.

## Technologies Used

- **Java**: Primary language for developing test scripts.
- **Selenium WebDriver**: For automating web UI testing.
- **Rest Assured**: For RESTful API testing.
- **TestNG**: Test runners for executing test cases.
- **Maven**: Build and dependency management tool.
- **Log4j@**: Logging tool
- **ApacheDBUtils**: For DB manipulation



## Installation

To get started with the project, clone the repository and install the necessary dependencies.

```bash
git clone https://github.com/your-repo/sample-test-automation-framework.git
cd sample-test-automation-framework
mvn clean install
```

## Running Tests

To execute the tests, use the following Maven commands:

### Run API Tests

```bash
mvn test -Dtest=ApiTestSuite
```

### Run UI Tests

```bash
mvn test -Dtest=UiTestSuite
```

You can also specify individual test classes or methods to run specific tests.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/your-feature-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature-name`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, please reach out to the project maintainer:

- **Name:** David
- **Email:** malkhasyandavid@gmail.com

---

Thank you for using the Sample Test Automation Framework! We hope it helps you in delivering high-quality software. Happy testing!