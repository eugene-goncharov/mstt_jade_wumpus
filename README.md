# JADE Book Trading

This project represents the "Book Trading" example implementation from [JADE Programming Tutorial for Beginners](https://jade.tilab.com/doc/tutorials/JADEProgramming-Tutorial-for-beginners.pdf).

## Prerequisites

- macOS 11.6 or higher
- Java 17 or higher
- JADE 4.6.0

## Running

To run the app that launches

```
chmod a+x run.sh
./run.sh
```


### Output

```
Jan 25, 2023 6:22:51 PM jade.core.Runtime beginContainer
INFO: ----------------------------------
    This is JADE 4.6.0 - revision 6869 of 30-11-2022 14:47:03
    downloaded in Open Source, under LGPL restrictions,
    at http://jade.tilab.com/
----------------------------------------
Jan 25, 2023 6:22:51 PM jade.imtp.leap.LEAPIMTPManager initialize
INFO: Listening for intra-platform commands on address:
- jicp://192.168.0.86:1099

Jan 25, 2023 6:22:52 PM jade.core.BaseService init
INFO: Service jade.core.management.AgentManagement initialized
Jan 25, 2023 6:22:52 PM jade.core.BaseService init
INFO: Service jade.core.messaging.Messaging initialized
Jan 25, 2023 6:22:52 PM jade.core.BaseService init
INFO: Service jade.core.resource.ResourceManagement initialized
Jan 25, 2023 6:22:52 PM jade.core.BaseService init
INFO: Service jade.core.mobility.AgentMobility initialized
Jan 25, 2023 6:22:52 PM jade.core.BaseService init
INFO: Service jade.core.event.Notification initialized
Jan 25, 2023 6:22:52 PM jade.mtp.http.HTTPServer <init>
INFO: HTTP-MTP Using XML parser com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser
Jan 25, 2023 6:22:52 PM jade.core.messaging.MessagingService boot
INFO: MTP addresses:
http://localhost:7778/acc
Navigator: Agent navigator@192.168.0.86:1099/JADE is ready.
Speleologist: Agent speleologist@192.168.0.86:1099/JADE is ready.
[world@192.168.0.86:1099/JADE] agent is ready.
Jan 25, 2023 6:22:52 PM jade.core.AgentContainerImpl joinPlatform
INFO: --------------------------------------
Agent container Main-Container@192.168.0.86 is ready.
--------------------------------------------
speleologist@192.168.0.86:1099/JADE: Start finding a Wumpus world
speleologist@192.168.0.86:1099/JADE: Found a Wumpus World.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: Maybe you can  move forward.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  turn right.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  move forward.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  turn left.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: Maybe you can  move forward.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: Maybe you can  turn right.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. Seems like I hear a scream. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  shoot.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. Seems like I hear a scream. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  move forward.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. Something is shining. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  turn left.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. Something is shining. 
navigator@192.168.0.86:1099/JADE: I think it is a good option to  move forward.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: Maybe you can  grab.
speleologist@192.168.0.86:1099/JADE: Wumpus world returns OK.
speleologist@192.168.0.86:1099/JADE: Help me, navigator.
navigator@192.168.0.86:1099/JADE: Give me information regarding your current status.
speleologist@192.168.0.86:1099/JADE: Giving you info: It stinks in here, you know. A cold breeze is blowing hard. 
navigator@192.168.0.86:1099/JADE: Maybe you can  climb.
speleologist@192.168.0.86:1099/JADE: The speleologist won!
Speleologist: Agent speleologist@192.168.0.86:1099/JADE shutting down.
       
```