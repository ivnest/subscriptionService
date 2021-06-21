# subscriptionService

Run proccess:
  1.- Execute "mvn clean install" in each subfolder (service-discovery, public-service, emailService and subscriptionService).
  2.- Execute in root folder "docker-compose build"
  3.- Execute in root folder "docker-compose up"

Test process:
  When application is running access to: http://localhost:8080/swagger-ui.html#/public-service-controller to visualize endpoints.
  With Postman import file (which is in root folder) "Adidas newsletter.postman_collection.json".
  Uses the different calls to test.
  Note: existing clientIds-> 1,2
        existing subscriptionIds-> 1,2
        existing newsletterIds-> 1,2,3
        
Other:
  To check Eureka dashbord access to: http://localhost:8761/
