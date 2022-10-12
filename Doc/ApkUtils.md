## Learn to use Apk Utils
### ApkUtils is a class to get info about apps from file or by package
#### c is the context like MainActivity.this or Fragment.this.getActivity(); , path is the string path of apk file , pkg is the package name of the app , apk is the name of ApkUtils definition here
##### please don't use gradle to download the library, paste the java files , because I didnot yet updated the library jar so if you download it , you will use an older one which has different methods and classes

> how to create from file

``` java

ApkUtils apk = new ApkUtils(c,path);

```

> how to create from package name

``` java
ApkUtils apk = new ApkUtils(null,null).getFromPackageName(c,pkg);

```

> how to get app name

``` java

YourString = apk.getName();

```

> how to get app package name

``` java

YourString = apk.getPackage();

```

> how to get the version name of the app

``` java

YourString = apk.getVersionName();

```
> how to get the version code of the app

``` java

YourString = apk.getVersionCode();

```

######There Are Many Methods Just See The Java Files , I will update this page later

