## Learn to use Apk Utils
### ApkUtils is a class to get info about apk files
#### c is the context like MainActivity.this or Fragment.this.getActivity(); , path is the string path of apk file

> to get drawable
```java
Drawable d = new ApkUtils(c,path).getIcon();
imageview1.setImageDrawable(d);
```
> to get name
```java
String appName = new ApkUtils(c,path).getName();
```
> to get version
```java
String version = new ApkUtils(c,path).getVersion();
```
> to get package name
```java
String pkg = new ApkUtils(c,path).getPackage();
```
