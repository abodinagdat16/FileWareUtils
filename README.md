# FileWareUtils
 It is a FileUtil to help developers to work with files .
 [![](https://jitpack.io/v/abodinagdat16/FileWareUtils.svg)](https://jitpack.io/#abodinagdat16/FileWareUtils)
 ### Configure
 ### Maven
 ##### Step 1. Add the JitPack repository to your build file
   Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
 
 #### Step 2. Add the dependency
 
 dependencies {
 
	           implementation 'com.github.abodinagdat16:FileWareUtils:v1.0.0'
         
	}
 
 #👇👇⚠️⛔☢
 # BEFORE YOU USE IT !
 # READ THIS BEFORE READING USAGE TEXT
 # it supports android 11 fully but you must add manage all storage permission or any other ways of accessing android folder , I will try to update it soon but currently you should do that yourself to access android folder , other folders are working well
 
 #  Usage

## with this method you can create new Folder s1 is your string value of path , s2 is your string value of name without path like Download

FileWareUtils.createFolder(s1,s2);


## same as above but for new File

FileWareUtils.createFile(s1,s2);

## to rename a file or folder
 s1 is the the full string path of file or folder
 s2 is the new name of file or folder like NewApp.apk or NewFolder

FileWareUtils.rename(s1,s2);

## to remove folder or file
// s is the path
FileWareUtils.delete(s);

## to move file or folder to string path
// s1 is the full string path of folder or file
// s2 is where to put file or folder



FileWareUtils.move(s1,s2);

## same as above but for copy

FileWareUtils.copy(s1,s2);


## to get size in bytes for file or folder
// s is the string path of file or folder

int size = new FileWareUtils().getSize(s);


## to get files count in a folder , s is string path of the folder


int files = new FileWareUtils().getFilesCount(s);

## same as above but for getting folders count


int folders = new FileWareUtils().getFoldersCount(s);


## to get ArrayList<String> of files in a path
// s is the string path


YourArrayList = new FileWareUtils().getFiles(s);


## same as above but for folders list

YourArrayList = new FileWareUtils().getFolders(s);


## same as above but for both of files and folders list


YourArrayList = new FileWareUtils().getList(s);


## to get custom file array string list only as above like jpg
YourArrayList = new FileWareUtils().getCustom(s,"jpg");



## to change modification date

FileWareUtils.changeDate(path,year,month,day,hour,minute,second);


## get modification date

String date = FileaWareUtils.getDate(path,"yyyy/MM/dd hh:mm:ss");

## to check if file or folder is empty


if(FileWareUtils.isEmpty(path)) {

//it is empty
//do something

}



## to check if path is file or folder


if(FileWareUtils.isFile(path)) {
//it is file
}

if(FileWareUtils.isFolder(path)) {
//it is folder
}


## to get name of file or folder

String name = FileWareUtils.getName(path);

## to get parent(path without name) of file or folder

String parentOf = FileWareUtils.getParent(path);


## to check if file or folder is hidden


if(FileWareUtils.isHidden(path)) {

//it is hidden

}


## to delete custom type of files
## like jpg

FileWareUtils.deleteCustom(path,"jpg");

## to read a file from path


YourString = FileWareUtils.read(path);

## to rewrite a file

FileWareUtils.rewrite(path,text);

## to Add text to file without deleting old text

FileWareUtils.writeAsOld(path,text);
