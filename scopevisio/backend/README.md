# Build
mvn clean package && docker build -t com.airhacks/scopevisio-chatbot-backend .

# RUN

docker rm -f scopevisio-chatbot-backend || true && docker run -d -p 8080:8080 -p 4848:4848 --name scopevisio-chatbot-backend com.airhacks/scopevisio-chatbot-backend 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test