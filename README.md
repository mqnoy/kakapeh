# SI report manajemen
 SI report manajemen Berbasis Java Desktop 

Aplikasi manajemen report




## Built With
* [Jdk8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - jdk8
* [Mysql server](https://dev.mysql.com/downloads/mysql/) - Database server
* [jcallendar-1.4](https://toedter.com/jcalendar/) - Input date
* [commons-codec-1.12](http://archive.apache.org/dist/commons/codec/binaries/) - MD5
* iReport
* Jasper

## library list
* Reporting
```
commons-beanutils-1.8.2.jar
commons-collections-3.2.1.jar
commons-digester-2.1.jar
commons-logging-1.1.jar
groovy-all-2.0.1.jar
jackson-core-2.1.4.jar
jackson-databind-2.1.4.jar
jasperreports-5.6.0.jar
jasperreports-core-renderer.jar
```

### Installing

download the file
[kakapehfile](https://github.com/mqnoy/kakapeh/archive/master.zip) 


or clone the repository

```
git clone https://github.com/mqnoy/kakapeh.git
```


import database

[db_app_kkp.sql](https://raw.githubusercontent.com/mqnoy/kakapeh/master/databases/db_app_kkp.sql) in databases folder
```
mysql -u yourusername -p db_app_kkp < db_app_kkp.sql.sql
```

## RUN Application

import project 

```
locate to folder kakapeh ,with NetBeans
```

run single frame "Pengaturan" for generating the config then
edit or ignore the config database configuration in config/aplikasi_config.ini

run with runscript run.sh/.bat
for linux :
```
sudo chmod +x run.sh
./run.sh
```

for windows : (make sure jdk8 already installed ) 
```
double click run.bat
```

password access : 
2016,2016

## TODO:
 

## Author
* kelompok4 kkp



