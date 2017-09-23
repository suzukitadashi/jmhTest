#Javaのバージョンを切り替える手順

## 前作業
JAVA_HOMEのパス指定を変える
C:\Program Files\Java\latest

## Java8
rmdir "C:\Program Files\Java\latest"
mklink /D "C:\Program Files\Java\latest" "C:\Program Files\Java\jdk1.8.0_144"

## Java9
rmdir "C:\Program Files\Java\latest"
mklink /D "C:\Program Files\Java\latest" "C:\Program Files\Java\jdk-9"
