# Inmobiliaria Project

Welcome to the Inmobiliaria project! This README will guide you through the steps to set up and test the project.

## Getting Started

Follow these steps to get the project up and running:

1. **Clone the Repository:** Open your terminal and run the following command to clone the repository to a new folder.

git clone https://github.com/Nelkha/inmobiliaria.git

2. **Open in Your IDE:** Navigate to your preferred Integrated Development Environment (IDE) and open the cloned project.

3. **Configure Libraries:** This project utilizes ANT for building. To ensure successful compilation, add the necessary libraries. Follow these steps:
- Right-click on the "Libraries" folder inside the project.
- Choose "Add JAR/Folder" and select the following libraries:
  - Absolute Layout
  - MySQL Connector for Java (minimum version: 8.17)

4. **Database Setup:**
- Create a database connection using the provided persistence unit (EclipseLink - Configuration by default).
- Credentials: Username - root, Password - root (Modify if necessary).
- Using MySQL Workbench, create a new database named "inmobiliaria" using the following script:
  ```sql
  CREATE DATABASE inmobiliaria;
  ```

## Running the Project

With the setup complete, you are now ready to run and test the project. Happy coding!

---

_This README was crafted with ❤️. Feel free to contact us at maritogallego@hotmail.com](maritogallego@hotmail.com) for any questions or concerns._
