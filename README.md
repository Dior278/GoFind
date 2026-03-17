# Setup and Installation Instructions for GoFind Full-Stack Application

## Prerequisites
- JDK 11 or later for Java backend
- Node.js 14 or later for TypeScript frontend
- Docker (optional, for containerized setup)
- PostgreSQL or another database supported by TypeORM

## Project Structure
- `backend/` - Contains Java files and Spring Boot configuration
- `frontend/` - Contains TypeScript files and React components
- `docker/` - Contains Docker configuration files

## Installation Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Dior278/GoFind.git
   cd GoFind
   ```
2. Navigate to the `backend` directory:
   ```bash
   cd backend
   ```
3. Install dependencies:
   ```bash
   ./mvnw install
   ```
4. Navigate to the `frontend` directory:
   ```bash
   cd ../frontend
   ```
5. Install npm dependencies:
   ```bash
   npm install
   ```

## Running Instructions
### Development
- For backend:
  ```bash
  cd backend
  ./mvnw spring-boot:run
  ```
- For frontend:
  ```bash
  cd frontend
  npm start
  ```

### Production
- Build the backend:
  ```bash
  cd backend
  ./mvnw clean package
  ```
- Build the frontend:
  ```bash
  cd frontend
  npm run build
  ```
- Run the application (ensure database is set up):
  ```bash
  java -jar backend/target/goFind.jar
  ```

## Testing
- For backend tests:
  ```bash
  cd backend
  ./mvnw test
  ```
- For frontend tests:
  ```bash
  cd frontend
  npm test
  ```

## Build
- To build the application for production, follow the production instructions above.

## Database Setup
1. Create a new database using PostgreSQL.
2. Update the `application.properties` in the `backend` directory with your database credentials.
3. Run migrations using TypeORM to set up the database schema.

## Docker Information
- A Dockerfile is provided in the `docker/` directory.
- To build and run with Docker:
  ```bash
  docker-compose up --build
  ```

## Available npm Scripts
- `npm start` - Starts the development server.
- `npm run build` - Builds the production version of the frontend.
- `npm test` - Runs the tests for the frontend.

## API Documentation
- The API is documented using Swagger, available at `/api/docs` once the application is running.

## Troubleshooting
- Check the console logs for errors if the application does not start correctly.
- Ensure your database is running and properly configured.

## Contributing Guidelines
- Please fork the repository and create a new branch for your feature or bug fix.
- Ensure tests are written for new features.

## Support Information
- For support, please open an issue on GitHub or contact the maintainer at Dior278@example.com.
