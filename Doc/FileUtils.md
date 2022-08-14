# File UTils
  #### learn to use FileUtils class

> with this method you can create new Folder s1 is your string value of path , s2 is your string value of name without path like Download
```java
FileWareUtils.createFolder(s1,s2);
```

> same as above but for new File
```java
FileWareUtils.createFile(s1,s2);
```
> to rename a file or folder
 s1 is the the full string path of file or folder
 s2 is the new name of file or folder like NewApp.apk or NewFolder
```java
FileWareUtils.rename(s1,s2);
```
> to remove folder or file
```java
// s is the path
FileWareUtils.delete(s);
```
> to move file or folder to string path
// s1 is the full string path of folder or file
// s2 is where to put file or folder
```java
FileWareUtils.move(s1,s2);
```
> same as above but for copy
```java
FileWareUtils.copy(s1,s2);
```

> to get size in bytes for file or folder
 ```java
// s is the string path of file or folder

int size = new FileWareUtils().getSize(s);
```

> to get files count in a folder , s is string path of the folder

```java
int files = new FileWareUtils().getFilesCount(s);
```
> same as above but for getting folders count

```java
int folders = new FileWareUtils().getFoldersCount(s);
```

> to get ArrayList<String> of files in a path
```java
  // s is the string path
YourArrayList = new FileWareUtils().getFiles(s);
```

> same as above but for folders list
```java
YourArrayList = new FileWareUtils().getFolders(s);
```

> same as above but for both of files and folders list
```java
YourArrayList = new FileWareUtils().getList(s);
```

> to get custom file array string list only as above like jpg
```java
  YourArrayList = new FileWareUtils().getCustom(s,"jpg");
```


> to change modification date
```java
FileWareUtils.changeDate(path,year,month,day,hour,minute,second);
```

> get modification date
```java
String date = FileaWareUtils.getDate(path,"yyyy/MM/dd hh:mm:ss");
```
> to check if file or folder is empty
```java
if(FileWareUtils.isEmpty(path)) {

//it is empty
//do something

}
```


> to check if path is file or folder

```java
if(FileWareUtils.isFile(path)) {
//it is file
}

if(FileWareUtils.isFolder(path)) {
//it is folder
}
```

> to get name of file or folder
```java
String name = FileWareUtils.getName(path);
```
> to get parent(path without name) of file or folder
```java
String parentOf = FileWareUtils.getParent(path);
```

> to check if file or folder is hidden

```java
if(FileWareUtils.isHidden(path)) {

//it is hidden

}
```

> to delete custom type of files like jpg
```java
FileWareUtils.deleteCustom(path,"jpg");
```
> to read a file from path

```java
YourString = FileWareUtils.read(path);
```
> to rewrite a file
```java
FileWareUtils.rewrite(path,text);
```
> to Add text to file without deleting old text
```java
FileWareUtils.writeAsOld(path,text);
```
