package arabware.forfree;
import android.graphics.*;
import android.graphics.drawable.*;
import android.content.*;
import android.os.*;
import android.app.*;
public class ApkUtils extends FileWareUtils {

    private Context cntx;
    private Drawable drawable;
    private String name;
    private String version;
    private String pkg;
    public ApkUtils(Context c,String path) {
        //if app target sdk version is 30 or more than this will never work
        //most of code are from different websites and projects , thanks for every hand helped me , and it has been modified by me hardly to make it work
        cntx = c;

        int targetSdkVersion = cntx.getApplicationContext().getApplicationInfo().targetSdkVersion;


        if(targetSdkVersion >= 30) {
            throw new RuntimeException(new Exception("android 11 sdk 30 is not supported"));
        } else {
            android.content.pm.PackageInfo pckgInfo = cntx.getPackageManager().getPackageArchiveInfo(path,0);
            android.content.pm.ApplicationInfo ai= pckgInfo.applicationInfo;
            ai.sourceDir = path;
            ai.publicSourceDir = path;
            drawable = cntx.getPackageManager().getApplicationIcon(pckgInfo.applicationInfo);
            name = "" + cntx.getPackageManager().getApplicationLabel(pckgInfo.applicationInfo);
            version = pckgInfo.versionName;
            pkg = pckgInfo.packageName;
        }



    }

    public Drawable getIcon() {
        return drawable;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getPackage() {
        return pkg;
    }

}
