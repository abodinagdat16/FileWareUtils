package arabware.file;

import android.graphics.drawable.*;
import android.content.*;
import android.os.*;
import android.app.*;

public class ApkUtils extends ArabWareFileManager {

	private Context cntx;
	private Drawable drawable;
	private String name;
	private String version;
	private String pkg;
	private String path;

	public <T extends Activity> ApkUtils(T c, String p) {
		path = p;
		cntx = c;

		int targetSdkVersion = cntx.getApplicationContext().getApplicationInfo().targetSdkVersion;


		if (targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30) {

			if (ArabWareFileManager.isFullAccessFiles( (T) cntx )) {
				doSomething();
			} else {
				throw new RuntimeException( new Exception( "the app must have manage all files permission or at least have access the path that apk is there" ) );
			}


		} else {
			doSomething();
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

	private void doSomething() {
		android.content.pm.PackageInfo pckgInfo = cntx.getPackageManager().getPackageArchiveInfo( path, 0 );
		android.content.pm.ApplicationInfo ai = pckgInfo.applicationInfo;
		ai.sourceDir = path;
		ai.publicSourceDir = path;
		drawable = cntx.getPackageManager().getApplicationIcon( pckgInfo.applicationInfo );
		name = "" + cntx.getPackageManager().getApplicationLabel( pckgInfo.applicationInfo );
		version = pckgInfo.versionName;
		pkg = pckgInfo.packageName;
	}

}
