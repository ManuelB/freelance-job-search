# Build
mvn clean package && docker build -t de.incentergy/employee-frontend .

# RUN

docker rm -f employee-frontend || true && docker run -d -p 8080:8080 -p 4848:4848 --name employee-frontend de.incentergy/employee-frontend 