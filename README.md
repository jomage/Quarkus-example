# Simple quarkus application

## Goal

Simple quarkus application that expose an api to create and retrieve orders and products from an imaginary online shop.

## Run
In a windows cmd, in the root folder of the project:
> `mvnw compile quarkus:dev`

## Features

### get list of objects
In a browser:
 
Products:  
> http://localhost:8080/products

Orders:  
> http://localhost:8080/orders

In a windows cmd:

Products:  
> `curl -w "\n" http://localhost:8080/products`

Orders:  
> `curl -w "\n" http://localhost:8080/orders`


### create objects
In a browser:
Products:  
> http://localhost:8080/products/createone

Orders:  
> http://localhost:8080/orders/createone

In a windows cmd:

Products:  
> `curl -H "Content-Type: application/json" -d "{\"name\":\"test\", \"unitPrice\":42}" http://localhost:8080/products`

or

> `curl -w "\n" http://localhost:8080/products/createone`

Orders:  
> `curl -H "Content-Type: application/json" -d "{\"shippingAddress\":\"34 rue gambetta 34000 Montpellier\", \"dateOrdered\":\"2020-12-12\", \"productsOrdered\":[]}" http://localhost:8080/orders`

or

> `curl -w "\n" http://localhost:8080/orders/createone`

### scheduled tasks

A Scheduler logs the total number of orders present in db every 40s.