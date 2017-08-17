#!/bin/sh     
    git_url=https://git.coding.net/tanhong/steambox.git
    port=22
    currentTime=`date '+%Y%m%d%H%M%S'`
      
    echo "[STEP1] starting git pull ........"
    cd ..
    git pull > /opt/steam/log/${currentTime}_git.log  
    echo "[STEP1] git pull successed......."
   
    echo "[STEP2] mvn building.......... " 
    cd SteamServe 
    mvn clean > /opt/steam/log/${currentTime}_mvn_clean.log 
    mvn install > /opt/steam/log/${currentTime}_mvn_install.log 
    echo "[STEP2] build successed.........."
 
    echo "[STEP3] starting deploy to server"
    cd ..
    sh ./depoly.sh restart > /opt/steam/log/${currentTime}_deploy.log
    echo "[STEP3] depoly to servers successfully!"
    
 
