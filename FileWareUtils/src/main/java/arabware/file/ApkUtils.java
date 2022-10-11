/* 2022 , The Open Source ApkUtils Project
this class can get info about an apk file from path (you can modify it to make it for installed also)

sample example :

for example getting the name of the apk file 

YourStringVariable = new ApkUtils(MainActivity.this,path).getName();

MainActivity.this is the activity Context , for fragment Context
use YourFragment.this.getContext(), 
and path is the apk String path value or variable

*/


//package name of the class


package arabware.file;

//imports of classes

import android.content.Context; /*Context Class*/
import android.content.pm.PackageInfo; /*Package Info from installed or file apk*/
import android.content.pm.ApplicationInfo; /*same as above but with more info*/
import android.app.Activity; /* the base class of an activity */
import android.app.Fragment; /* the base class of a fragment */
import android.app.DialogFragment; /* the base class of a dialog fragment */
import android.graphics.drawable.Drawable; /* this class for drawing the icon */
import java.lang.String; /* the String class */
import android.os.Build; /* User Device Info */
import java.util.ArrayList; /* This Class Can Contains List Of String values */
import java.io.File; /* file management class */
import android.content.pm.Signature; /* a class that can check and get the signature of an app file or installed app*/
import android.content.pm.PackageManager;

//definition of the whole class


public class ApkUtils {
	
    //fields
    
    //two important fields
    
    private ApplicationInfo ai;
    private PackageInfo pckgInfo;
    
    /*context of your app*/
    public Context cntx;
    /*drawable of the app icon from file*/
	public Drawable drawable;
    /*name of the app from file*/
	public String name;
    /*version name of the app from file*/
	public String versionName;
    /*version code of the app from file*/
    public int versionCode;
    /*package of the app from file*/
	public String pkg;
    /*path of the app from file*/
    public String path;
    /*target sdk version of the app fron file*/
    public int targetSdkVersion;
    /*min sdk version of the app from file*/
    public int minSdkVersion;
    /*data dir of the app from file*/
    public String dataDir;
    /*ManageSpaceActivityName of the app from file , it can be null
    if the developer of the app didnot add it in the manifest! OK?*/
    public String manageSpaceActivityName;
    /*Application Class Name of the app from file , it can be null
    if the developer didnot add it in the manifest! OK?*/
    public String className;
    /*uid of the app from file*/
    public int uid;
    /*source dir of the app from file*/
    public String sourceDir;
    /*public source dir of the app from file*/
    public String publicSourceDir;
    /*spilt names of the app from file if found*/
    public ArrayList<String> names = new ArrayList<>();
    /*spilt source dirs of the app from file if found*/
    public ArrayList<String> sources = new ArrayList<>();
    /*spilt public source dirs of the app from file if found*/
    public ArrayList<String> publicSources = new ArrayList<>();
    /*name of installed app of same package of app from file*/
    public String installedName;
    /*version name of installed app of same package of app from file*/
    public String installedVerName;
    /*version code of installed app of same package of app from file*/
    public int installedVerCode;
    /*min sdk version of installed app of same package of app from file*/
    public int installedMinSdk;
    /*target sdk version of installed app of same package of app from file*/
    public int installedTargetSdk;
    /*checks if the apk file is installed and with SAME SIGNATURE*/
    public boolean isInstalledWithSameSignature = false;
    /*sha1 of the app from file*/
    public String SHA1;
    /*sha256 of the app from file*/
    public String SHA256;
    /*just for signing info*/
    private PackageInfo packageInfo;
    private Signature[] signatures;
    /*permissions of the app from file*/
    public ArrayList<String> permissions = new ArrayList<>();
    
    
    //constructors
    
	public <T extends Context> ApkUtils(T c,String p) {
        
        if(!(new File(p).exists())) {
            throw new RuntimeException(new Exception("unable to find the apk file , are you sure the path is correct and you gave us the permissions"));
        }
        if(c == null) {
            throw new RuntimeException(new Exception("Context cannot be null , you must add correct context to the ApkUtils constructor (definition)"));
        }
        
	path = p;
		cntx = c;
try {
    
targetSdkVersion = cntx.getApplicationContext().getApplicationInfo().targetSdkVersion;

} catch(Exception e) {
    targetSdkVersion = cntx.getApplicationInfo().targetSdkVersion;
}
if(targetSdkVersion == 0) {
    targetSdkVersion = 30;
}


		if((Build.VERSION.SDK_INT ==30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32)&& targetSdkVersion >= 30) {
            
            if(isFullAccessFiles((T)cntx)) {
                doSomething();
            } else {
                throw new RuntimeException(new Exception("the app must have manage all files permission or at least have access the path that apk is there"));
            }
            
            
            
			
            
		} else {
            
            doSomething();
            
        }

		
	}
    
    
    
    
    //methods (functions)
	
    
    /* with this you can get an icon drawable value . and put it in ImageView (for example)*/
    
	public Drawable getIcon() {
		return drawable;
	}
	
    /*name of the app from file*/
    
	public String getName() {
		return name;
	}
    
    /*version name of the app from file*/
	
	public String getVersionName() {
		return versionName;
	}
    
    /*version code of the app from file*/
    
    public String getVersionCode() {
        return String.valueOf(versionCode);
    }
    
    /*package of the app from file*/
    
    
	public String getPackage() {
		return pkg;
	}
    
    /*target sdk version of the app from file*/
    
    public String getTargetSdkVersion() {
        return String.valueOf(targetSdkVersion);
    }
    
    /*min sdk version of the app from file*/
    
    public String getMinSdkVersion() {
        return String.valueOf(minSdkVersion);
    }
    
    /*manage space activity name if found of the app from file*/
    
    public String getManageSpaceActivityName() {
        if(manageSpaceActivityName == null) {
            return "";
        }
        return manageSpaceActivityName;
    }
    
    /*Application class name if found of the app from file*/
    
    public String getClassName() {
        if(className == null) {
            return "";
        }
        return className;
    }
    
    /*uid of the app from file*/
    
    public String getUID() {
        return String.valueOf(uid); 
    }
    
    /* data dir of the app from file , if installed */
    
    public String getDataDir() {
        return dataDir;
    }
    
    /* source dir of the app from file if installed */
    
    public String getSourceDir() {
        if(sourceDir == null) {
            return "";
        }
        return sourceDir;
    }
    
    /*public source dir of the app from file if installed*/
    
    public String getPublicSourceDir() {
        if(publicSourceDir == null) {
            return "";
        }
        return publicSourceDir;
    }
    
    /* name of installed app that has same package name of app from file*/
    
    public String getInstalledName() {
        if(installedName == null) {
            return "";
        }
        return installedName;
    }
    
    /* version name of installed app that has same package name of app from file*/
    
    public String getInstalledVerName() {
        if(installedVerName == null) {
            return "";
        }
        return installedVerName;
    }
    
    /* version code of installed app that has same package name of app from file*/
    
    public String getInstalledVerCode() {
        return String.valueOf(installedVerCode);
    }
    
    /* target sdk version of installed app that has same package name of app from file*/
    
    public String getInstalledTargetSdk() {
        return String.valueOf(installedTargetSdk);
    }
    
    /* min sdk version of installed app that has same package name of app from file*/
    
    public String getInstalledMinSdk() {
        return String.valueOf(installedMinSdk);
    }
    
    
    /* names list of split files of the app if found and installed*/
    
    public ArrayList<String> getSplitNamesIfFound() {
        if(names == null) {
            names = new ArrayList<>();
            return names;
        }
        return names;
    }
    
    /* source dirs list of split files of the app if found and installed*/
    
    public ArrayList<String> getSplitSourcesIfFound() {
        if(sources == null) {
            sources = new ArrayList<>();
            return sources;
        }
        return sources;
    }
    
    /* public source dirs list of split files of the app if found and installed*/
    
    public ArrayList<String> getSplitPublicSourcesIfFound() {
        if(publicSources == null) {
            publicSources = new ArrayList<>();
            return publicSources;
        }
        return publicSources;
    }
    
    /* if the user installed the apk file and it is same SIGNATURE ,
    then it will return TRUE !*/
        
    public boolean installedWithSameSign() {
        return isInstalledWithSameSignature;
    }
    
    /*you can get the sha1 of the app from file*/
    
    public String getSHA1() {
        if(SHA1 == null) {
            return "";
        }
        return SHA1;
    }
    
    /*you can get the sha256 of the app from file*/
    
    public String getSHA256() {
        if(SHA256 == null) {
            return "";
        }
        return SHA256;
    }
    
    /*you can get the permissions list of the app from file*/
    
    public ArrayList<String> getPermissions() {
        if(permissions == null) {
            permissions = new ArrayList<>();
        }
        return permissions;
    }
    
    
    
    
    
    private void doSomething() {

try {


if(Build.VERSION.SDK_INT < 28) {
    
		pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, 0);
        
        } else {
            
            if(Build.VERSION.SDK_INT >= 33) {
                
                
                pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.PackageInfoFlags.of(0));
                
            } else {
            
            
            pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, 0);
            
            }
            
        }




ai= pckgInfo.applicationInfo;

} catch(Exception e) {
    
}

try {

ai.sourceDir = path;

} catch(Exception e) {
    
}

try {

ai.publicSourceDir = path;

} catch(Exception e) {
    
}

try {

drawable = cntx.getPackageManager().getApplicationIcon(pckgInfo.applicationInfo);

} catch(Exception e) {
    
}

try {

name = "" + cntx.getPackageManager().getApplicationLabel(pckgInfo.applicationInfo);

} catch(Exception e) {
    
}

try {

versionName = pckgInfo.versionName;

} catch(Exception e) {
    
}

try {

versionCode = pckgInfo.versionCode;

} catch(Exception e) {
    
}

try {


pkg = pckgInfo.packageName;

} catch(Exception e) {
    throw new RuntimeException(new Exception(e));
}

try {

targetSdkVersion = ai.targetSdkVersion;

} catch(Exception e) {
    
}

try {

minSdkVersion = ai.minSdkVersion;

} catch(Exception e) {
    
}

try {
    
dataDir = ai.dataDir;

} catch(Exception e) {
    
}

try {
    
manageSpaceActivityName = ai.manageSpaceActivityName;

} catch(Exception e) {
    
}

try {
    
className = ai.className;

} catch(Exception e) {
    
}

try {
    
uid = ai.uid;

} catch(Exception e) {
    
}

/*here we are checking if the app is installed or no and get some info*/

try {



if(Build.VERSION.SDK_INT < 28) {
    
		pckgInfo = cntx.getPackageManager().getPackageInfo(pkg, 0);
        
        } else {
            
            if(Build.VERSION.SDK_INT >= 33) {
                
                
                pckgInfo = cntx.getPackageManager().getPackageInfo(pkg, PackageManager.PackageInfoFlags.of(0));
                
            } else {
            
            
            pckgInfo = cntx.getPackageManager().getPackageInfo(pkg, 0);
            
            }
            
        }





ai= pckgInfo.applicationInfo;

} catch(Exception e) {
    
}


try {

publicSourceDir = ai.publicSourceDir;


} catch(Exception e) {
    
}

try {

sourceDir = ai.sourceDir;

} catch(Exception e) {
    
}

try {

installedVerName = pckgInfo.versionName;

} catch(Exception e) {
    
}

try {

installedVerCode = pckgInfo.versionCode;

} catch(Exception e) {
    
}

try {

installedTargetSdk = ai.targetSdkVersion;

} catch(Exception e) {
    
}

try {

installedMinSdk = ai.minSdkVersion;

} catch(Exception e) {
    
    
}

try {

installedName = "" + cntx.getPackageManager().getApplicationLabel(ai);

} catch(Exception e) {
    
}

try {

names = new ArrayList<>();

String[] list = ai.splitNames;



for(String s : list) {
    
    names.add(s);
    
}

} catch(Exception e) {
    
}

try {

sources = new ArrayList<>();

String[] list2 = ai.splitSourceDirs;

for(String s : list2) {
    
    sources.add(s);
    
}

} catch(Exception e) {
    
}

try {

publicSources = new ArrayList<>();


String[] list3 = ai.splitPublicSourceDirs;

for(String s : list3) {
    
    publicSources.add(s);
    
}

} catch(Exception e) {
    
}

try {

SHA1 = getSignture("SHA1");

SHA256 = getSignture("SHA256");

} catch(Exception e) {
    
}

try {

String s = getSignture("SHA1");
String s2 = getSignture("SHA1",pkg);
String s3 = getSignture("SHA256");
String s4 = getSignture("SHA256",pkg);


isInstalledWithSameSignature = (s.equals(s2) || s3.equals(s4));




} catch(Exception e) {
    throw new RuntimeException(new Exception(e));
}


if(Build.VERSION.SDK_INT < 28) {
    
		pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.GET_PERMISSIONS);
        
        } else {
            
            if(Build.VERSION.SDK_INT >= 33) {
                
                
                pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.PackageInfoFlags.of(PackageManager.GET_PERMISSIONS));
                
            } else {
            
            
            pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.GET_PERMISSIONS);
            
            }
            
        }

try {
    
    permissions = new ArrayList<>();
		
		if (pckgInfo.requestedPermissions != null) {
            
            
			for (String p : pckgInfo.requestedPermissions) {
				
				permissions.add(p);
                
                
					}
                    
                    
					}
                    
                    
					} catch (Exception e) {
                        
                        
                        
						}
						


    }
    
    
    
    //don't care about these, they are available at ArabWareFileManager class but I took them for a reason
    
    
    private boolean isAndroid11() {
        return (android.os.Build.VERSION.SDK_INT == 30||android.os.Build.VERSION.SDK_INT > 30);
    }
    

    
    private boolean isAndroid6() {
        return (android.os.Build.VERSION.SDK_INT == 23||android.os.Build.VERSION.SDK_INT > 23);
    }
    

    private boolean isFullAccessFiles(Context c) {
        if(isAndroid11()) {
        return android.os.Environment.isExternalStorageManager();
        }
        if(isAndroid6()) {
            
        if(c.checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
            return false;
        }
        if(c.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
            return false;
        }
        
        } else {
            
            return true;
            
        }
        
        return true;
    }
    
    //credits of signatures methods (StackOverFlow)
    
    public String getSignture(String type) {
        
try {
    
    if(Build.VERSION.SDK_INT < 28) {
    
		packageInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.GET_SIGNATURES);
        
        } else {
            
            if(Build.VERSION.SDK_INT >= 33) {
                
                
                packageInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.PackageInfoFlags.of(PackageManager.GET_SIGNING_CERTIFICATES));
                
            } else {
            
            
            packageInfo = cntx.getPackageManager().getPackageArchiveInfo(path, PackageManager.GET_SIGNING_CERTIFICATES);
            
            }
            
        }
        
    try {
    
    if(packageInfo.signatures == null || packageInfo.signatures.length == 0) {
        
        signatures = packageInfo.signingInfo.getApkContentsSigners();
        
    } else {
        
        signatures = packageInfo.signatures;
        
    }
    
    } catch(Exception e) {
        
        signatures = packageInfo.signingInfo.getApkContentsSigners();
        
    }
    
    
    
		for (android.content.pm.Signature signature : signatures) {
			
			String shaType = getSHAOfType_(signature.toByteArray(),type);
			// check is matches hardcoded value
			return shaType;
		}
} catch(Exception e) {
    throw new RuntimeException(new Exception(e));
}

	return "";
	}
    
    
    
    
    public String getSignture(String type, String pkgName) {
        
try {
    
    if(Build.VERSION.SDK_INT < 28) {
    
		packageInfo = cntx.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_SIGNATURES);
        
        } else {
            
            if(Build.VERSION.SDK_INT >= 33) {
                
                
                packageInfo = cntx.getPackageManager().getPackageInfo(pkgName, PackageManager.PackageInfoFlags.of(PackageManager.GET_SIGNING_CERTIFICATES));
                
            } else {
            
            
            packageInfo = cntx.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_SIGNING_CERTIFICATES);
            
            }
            
        }
        
    try {
    
    if(packageInfo.signatures == null || packageInfo.signatures.length == 0) {
        
        signatures = packageInfo.signingInfo.getApkContentsSigners();
        
    } else {
        
        signatures = packageInfo.signatures;
        
    }
    
    } catch(Exception e) {
        
        signatures = packageInfo.signingInfo.getApkContentsSigners();
        
    }
    
    
    
		for (android.content.pm.Signature signature : signatures) {
			
			String shaType = getSHAOfType_(signature.toByteArray(),type);
			// check is matches hardcoded value
			return shaType;
		}
} catch(Exception e) {
    throw new RuntimeException(new Exception(e));
}

	return "";
	}
  
  //computed the sha1 hash of the signature
  public String getSHAOfType_(byte[] sig , String type) {
try {
  		java.security.MessageDigest digest = java.security.MessageDigest.getInstance(type);
digest.update(sig);
			byte[] hashtext = digest.digest();
			return bytes_To_Hex_(hashtext);
} catch(java.security.NoSuchAlgorithmException e) {
    throw new RuntimeException(new java.security.NoSuchAlgorithmException(e));
}
			
	}
  
  //util method to convert byte array to hex string
  public String bytes_To_Hex_(byte[] bytes) {
  	final char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	
}
