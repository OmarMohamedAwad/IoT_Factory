<img src="ReadmeAssets/warehouse.png">

# IoT Devices Warehouse

## Auther: Ahmed Eldakhly.

## Description:
- In England, a warehouse of IoT devices that have sim cards to be tracked all the time.
- All devices should be configured according to UK configurations to be available for selling.
- Half od devices already configured.
- This Software to get real time information about all devices and configure devices too.
## System Capability:
**The server:**
- Server can connect with devices Database to retrieve devices information and update this information after physical configuration.
- The server expose 3 RESTful APIs to any client with specific credentials to use server's features.

**The client:**
- The client request each APIs with the right credentials.
- The client can see all devices that have specific status (as requirement for this project we send request to get devices in "WAITING" status).
- The client can get all devices that can be allowed to work in UK according to UK standards.
- the client (Shop) can update the Information of each device.

## System specifications:
- Used programing language: Java - Spring Boot framework.
- Used network communication: Restful APIs (HTTP).
- MySQL Database is used as data store for all devices.
- MVC approach is used here.
- The code is tasted using unit and integration testing for the controller and the service.

## Assumtions
**The server:**

1. The server provide only 3 APIs with 3 functions:
   - Get all devices that can be accepted in UK.
   - Get all devices with specific status (SIM card status).
   - Update each device 

2. Each device has these attributes:
   - Device Id.
   - Device Ideal Temperature between (-25 & 85).
   - Device Status (READY - NOT_READY).
   - SIM Id.

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
2. The client need username and password as basic Auth security.

Note: All credentials can be configured from application.properties.
Note: Postman requests are attached inside the GitHub repository.
## System Architecture
<img src="ReadmeAssets/system_srchitecture.png">

## Server System Components
<img src="ReadmeAssets/server_components.png">

## System Implementation
### Server Class Diagram
<img src="ReadmeAssets/class_diagram.png">

## Implementation documents

- Generated by Java Docs.

**The server document:**
[Server implementation document](JavaDocs/index.html)

## [GitHub Link](https://github.com/Ahmed-Eldakhly/device-tracking-iot)