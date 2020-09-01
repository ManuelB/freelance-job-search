#!/bin/sh
mvn clean package && docker build -t com.airhacks/scopevisio-chatbot-backend .
docker rm -f scopevisio-chatbot-backend || true && docker run -d -p 8080:8080 -p 4848:4848 --name scopevisio-chatbot-backend com.airhacks/scopevisio-chatbot-backend 
