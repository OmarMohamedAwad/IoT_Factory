# IoT Factory Warehouse

## Auther: Omar Awad.

## Description:
- In England, a warehouse of IoT devices that have sim cards to be tracked all the time.
- All devices should be configured according to UK configurations to be available for selling.
- Half of devices already configured.
- This Software to get real time information about all devices and configure devices too.

## System specifications:
- Used programing language: Java - Spring Boot framework.
- Used network communication: Restful APIs (HTTP).
- MySQL Database is used as data store for all devices.
- MVC approach is used here.
- The code is tasted using unit and integration testing for the controller and the service using junit.

## System Capability:
- The autheraized user can returns all devices in the warehouse that are waiting for activation.
- The autheraized user management endpoints that enable the shop manager to remove or update a device configuration status.
- The autheraized user returns an ordered result of devices available for sale.

## System specifications:
- Used programing language: Java - Spring Boot framework.
- Used network communication: Restful APIs (HTTP).
- MySQL Database is used as data store for all devices.
- MVC approach is used here.
- The code is tasted using unit and integration testing for the controller and the service.

## Assumptions
**The server:**

1. The server provide the following APIs:
   - Get all devices that can be accepted in UK.
   - Get all devices with specific status.
   - Update device 
   - Delete device

2. Each warehouse has these attributes:
   - Warehouse Id.
   - Country.

3. Under each warehouse there are category has these attributes:
   - Category Id
   - Warehouse Id.
   - Location.

2. Each device has these attributes:
   - Device Id.
   - Device Ideal Temperature between (-25 & 85).
   - Device Status (Ready - Not Ready).
   - SIM Id.
   - Category Id.

3. Each SIM card has these attributes:
   - SIM Id.
   - Country.
   - Operator Code.
   - SIM Status.

4. The UK standards are:
   - Each device has SIM Card.
   - The device ideal temperature should be between -28 and 85.
   - The device will be in ready state with this information.

5. The API which get all devices at WAITING status mean that all those devices have SIM cars and this SIM card at WAITING status.

**The client:**

1. Postman will be used as client simulator to hit the endpoints.

Note: All credentials can be configured from application.properties.
Note: Postman requests are attached inside the GitHub repository.

## System Design
<img src="project source/System Draw-System Design.png">

## Server System Components
<img src="project source/System Components.png">

## System Implementation
### Server Class Diagram
<img src="project source/System Draw-Class Diagram.png">
