# Spring Boot Shopping Cart - Docker Setup

This application now supports Docker Compose for easy development setup with all required services.

## Prerequisites

- Docker and Docker Compose installed
- Java 21
- Maven 3.6+

## Services Included

1. **MySQL 8.0** - Database server
2. **MailDev** - Email testing tool with web UI

## Quick Start

### 1. Build the Application

```bash
mvn clean package -DskipTests
```

### 2. Start Services with Docker Compose

```bash
# Start all services in the background
docker-compose up -d

# Or start and see logs
docker-compose up
```

### 3. Run the Spring Boot Application

```bash
# Using Maven with Docker profile
mvn spring-boot:run -Dspring-boot.run.profiles=docker

# Or using the JAR file
java -jar target/spring-boot-shoopingcart-0.0.1-SNAPSHOT.jar --spring.profiles.active=docker
```

## Service URLs

- **Application**: http://localhost:8080
- **MailDev Web UI**: http://localhost:1080 (View sent emails)
- **MySQL**: localhost:3306
    - Database: `cart`
    - Username: `yu71`
    - Password: `53cret`

## API Endpoints

### Authentication

- `POST /api/auth/signin` - Login
- `POST /api/auth/signup` - Register

### Items

- `GET /api/item/all` - Get all items
- `POST /api/item/add` - Add new item

### Cart

- `GET /api/cart/all` - Get cart items
- `POST /api/cart/add` - Add item to cart

### Email Testing

- `POST /api/mail/send/welcome` - Send welcome email (view in MailDev)

## Database Schema

The application automatically creates the database schema on startup using Hibernate DDL auto-update.

## Stopping Services

```bash
# Stop all services
docker-compose down

# Stop and remove volumes (destroys data)
docker-compose down -v
```

## Development Tips

1. **Email Testing**: All emails sent by the application will be captured by MailDev. Access the web UI
   at http://localhost:1080 to view them.

2. **Database Access**: You can connect to MySQL using any client:
    - Host: localhost
    - Port: 3306
    - Database: cart
    - Username: yu71
    - Password: 53cret

3. **Logs**: View application logs:
   ```bash
   # Application logs
   mvn spring-boot:run -Dspring-boot.run.profiles=docker

   # Docker service logs
   docker-compose logs -f mysql
   docker-compose logs -f maildev
   ```

## External Services (Optional)

For full functionality, set these environment variables:

```bash
export TWILIO_SID="your_twilio_sid"
export TWILIO_AUTH_TOKEN="your_twilio_token"
export TWILIO_NUMBER="your_twilio_phone_number"
export STRIPE_API_KEY="your_stripe_api_key"
```

## Troubleshooting

### MySQL Connection Issues

- Ensure Docker services are running: `docker-compose ps`
- Check MySQL logs: `docker-compose logs mysql`
- Verify database is created: Connect to MySQL and check if `cart` database exists

### Application Startup Issues

- Make sure to use the `docker` profile: `--spring.profiles.active=docker`
- Check if MySQL is ready: Wait for MySQL health check to pass

### Port Conflicts

If ports 3306, 1080, or 1025 are already in use, modify the `compose.yml` file to use different ports.