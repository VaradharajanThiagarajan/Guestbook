| URI               | HTTP Method | HTTP Status |      Description            |       Request        |        Response        | 
|-------------------|-------------|-------------|----------------------      |----------------------|------------------------|
| /Guestentries/Entries           |     Post     |201         |  Add visitor entries to database     |   {"name": "Pamu","comments": "My age is 40"}| None` |
/Guestentries/Entries            |     Get      | 200         |  Get all visitor entries from database |None` |   {"name": "Pamu","comments": "My age is 40"} |


# Instruction for Docker setup

#### Run the springboot guestservice application from the application image
docker run -d -p 1000:8080 -e "SPRING_PROFILES_ACTIVE=docker" --name guest1 --rm guestservice:dev
