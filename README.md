# General Utils Library
Some library written in Java for other programs.



## Database (MySql) functionality
Can be used for connecting to databases.


### Requirement for Database (Connection File)
Creation in working directory of file "Constants.txt"
It need to follow a specific pattern of (variable name : value :type),
and in case the use of : or spaces is require it can be used " ".
The needed value are UrlDatabase, UserDatabase, UsrPsw.
```Plain Text
UrlDatabase  : {your_link_to_database}     :String
UserDatabase : {your_username}           :String
PswDatabase  : {your_password}           :String
```
Ex.
```Plain Text
UrlDatabase  : "jdbc:mysql://thisIsATest.com:3306"     :String
UserDatabase : thisIsUserNameTest                      :String
PswDatabase  : safePassword                            :String
```

### Requirement for Database (Connection File)
MySql Connector jar file downloadable at link <a href="https://dev.mysql.com/downloads/connector/j/">here </a>
