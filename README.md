# Code challenge

# Exercice 1
Write a Java code where a user can create an application and assign it to someone else for approval where it can also be rejected (something like jira)
The trick is that this workflow/Java code need to be delivered by integrating with a business process management tool (jbpm, kie server)

  - find the schematic diagram from bpmn diagram editor(eclipse plugin with the source code on git "https://github.com/jeanSaade-springBoot/jbpm-kie-server-springboot.git")
### Step to deploy:
  -     generate kjar file from aven from the project: "application-management-kjar"
  -     run the spring boot project "application-management-service"
  -    do this api call that will call the bpmn process: "http://localhost:8090/createandsubmit?name=jean&status=Approved" 
 ```sh
- you can clone the code and through maven dependencies all will be configured
- JDK 8
- from spring boot aplication we called an well designed bpmn process in order to create the application and assign it to the user
- Still need more work but the main methods and logic are created.
``` 
