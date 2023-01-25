#!/bin/bash

find ./src -type f -name "*.java" > sources.txt
javac -cp libs/jade.jar -d ./out @sources.txt
cd ./out
jar cvf agents.jar ua/nure/mstt_labs/
cd ..
java -cp libs/jade.jar:out/agents.jar jade.Boot -agents world:ua.nure.mstt_labs.wumpus.agents.WumpusWorldAgent\;navigator:ua.nure.mstt_labs.wumpus.agents.NavigatorAgent\;speleologist:ua.nure.mstt_labs.wumpus.agents.SpeleologistAgent
