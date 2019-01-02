#!/usr/bin/env bash
mvn clean package shade:shade
scp -i /home/aslak/.ssh/id_rsa -r /home/aslak/IdeaProjects/Robot2/Server/target/Server-1.0-SNAPSHOT.jar pi@10.0.0.113:/home/pi/Server.jar
ssh -i /home/aslak/.ssh/id_rsa pi@10.0.0.113 sudo java -jar Server.jar