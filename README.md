# 0-ProgramParts
Some library written in Java for other programs.


## Database (MySql) functionality
Can be used for connecting to databases.

### Requirement for DatabaseConnection
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
