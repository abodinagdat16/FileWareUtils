package arabware.forfree;
import java.io.*;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class FileWareUtils {
    
	public static File file;
	private int n = 0;
	private ArrayList<String> files = new ArrayList<>();
	public static Calendar c = Calendar.getInstance();
	
	public FileWareUtils() {
		n = 0;
		files = new ArrayList<>();
	}
	
	
	
	public static void createFolder(String path , String name) {
		
		if (path.endsWith("/")) {

			file = new File(path+name);
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			} else {
				
				file = new File(path+"/"+name);
			
			if(!file.exists()) {
				file.mkdirs();
			}
				
				
				}
		
		


		
		
	}
	
	public static void createFile(String path , String name) {
		
		
		
		try {
		
		if (path.endsWith("/")) {
			createFolder(path,"");
			
			
			file = new File(path+name);
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			} else {
				createFolder(path+"/","");
				file = new File(path+"/"+name);
			
			if(!file.exists()) {
				file.createNewFile();
			}
				
				
				}
				
				} catch(IOException e) {
					
				}
		
	}
	
	public static void rename(String path , String to) {
		
		if(isFile(path)) {
			
			
			new File(path).renameTo(new File(path.replace(Uri.parse(path).getLastPathSegment(), "").concat(to)));
			
			
		} else {
			
			
			new File(path).renameTo(new File(path.replace(Uri.parse(path).getLastPathSegment(), to)));
			
			
		}
		
		
	}
	
	public static void delete(String path) {
		if(path.endsWith("/")) {
		new File(path).delete();
		} else {
			
			if(isFile(path)) {
				new File(path).delete();
			} else {
				new File(path+"/").delete();
			}
			
		}
	}
	
	public static void move(String path1 , String path2) {
		
		if(isFile(path1)) {
			
			
	if(path2.endsWith("/")) {
		
			new File(path1).renameTo(new File(path2+Uri.parse(path1).getLastPathSegment()));
			
			} else {
				new File(path1).renameTo(new File(path2+"/"+Uri.parse(path1).getLastPathSegment()));
				
			}
			
		} else {
			
			
			
			if(path1.endsWith("/")) {
			
			
			if(path2.endsWith("/")) {
		
			new File(path1).renameTo(new File(path2+Uri.parse(path1).getLastPathSegment()+"/"));
			
			} else {
				new File(path1).renameTo(new File(path2+"/"+Uri.parse(path1).getLastPathSegment()+"/"));
				
			}
			
			
			
			} else {
				
				
				if(path2.endsWith("/")) {
		
			new File(path1+"/").renameTo(new File(path2+Uri.parse(path1).getLastPathSegment()+"/"));
			
			} else {
				new File(path1+"/").renameTo(new File(path2+"/"+Uri.parse(path1).getLastPathSegment()+"/"));
				
			}
				
				
			}
			
			
			
			
		}
		
		
	}
	
	public static void copy(String path1 , String path2) {
		
		
		
		
		
		if(path2.endsWith("/")) {
			
			
			
			if(isFile(path1)) {
		
		
	copyFile(path1,path2,false,path1);
		
		
		
		
		
		} else {
		
		if(path1.endsWith("/")) {
		
		if(new File(path1).exists()) {
			
		file = new File(path1);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                copyFile(f.getAbsolutePath(),path2,true,path1);
            } else if (f.isDirectory()) {
				
                copy(f.getAbsolutePath(),path2);
            }
        }
		

		
		}
		
		} else {
			
			if(new File(path1+"/").exists()) {
			
		file = new File(path1+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                copyFile(f.getAbsolutePath(),path2,true,path1+"/");
            } else if (f.isDirectory()) {
				
                copy(f.getAbsolutePath(),path2);
            }
        }
		
		
		}
			
		}
		
		}
			
			
			
			
			
		} else {
			
			
			
			
			if(isFile(path1)) {
		
		
	copyFile(path1,path2+"/",false,path1);
		
		
		
		
		
		} else {
		
		if(path1.endsWith("/")) {
		
		if(new File(path1).exists()) {
			
		file = new File(path1);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                copyFile(f.getAbsolutePath(),path2+"/",true,path1);
            } else if (f.isDirectory()) {
				
                copy(f.getAbsolutePath(),path2+"/");
            }
        }
		

		
		}
		
		} else {
			
			if(new File(path1+"/").exists()) {
			
		file = new File(path1+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                copyFile(f.getAbsolutePath(),path2,true,path1+"/");
            } else if (f.isDirectory()) {
				
                copy(f.getAbsolutePath(),path2);
            }
        }
		
		
		}
			
		}
		
		}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	public int getSize(String path) {
		
		if(isFile(path)) {
			
			return ((int)new File(path).length());
			
		} else {
		
		
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                n = n+(int)f.length();
            } else if (f.isDirectory()) {
                getSize(f.getAbsolutePath());
            }
        }
		

		return n;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                n = n+(int)f.length();
            } else if (f.isDirectory()) {
                getSize(f.getAbsolutePath());
            }
        }
		
		return n;
		}
			
		}
		
		}
		
		
		
		
		return 0;
		
	}
	
	public int getFilesCount(String path) {
		
		
		
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                n = n+1;
            } else if (f.isDirectory()) {
                getFilesCount(f.getAbsolutePath());
            }
        }
		

		return n;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                n = n+1;
            } else if (f.isDirectory()) {
                getFilesCount(f.getAbsolutePath());
            }
        }
		
		return n;
		}
			
		}
		
		return 0;
		
	}
	
	public int getFoldersCount(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                
            } else if (f.isDirectory()) {
				n = n+1;
                getFoldersCount(f.getAbsolutePath());
            }
        }
		
		
		
	
		return n;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                
            } else if (f.isDirectory()) {
				n=n+1;
                getFoldersCount(f.getAbsolutePath());
            }
        }
		
		return n;
		}
			
		}
		
		return 0;
		
		
	}
	
	public ArrayList<String> getFiles(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                getFiles(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                getFiles(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	
	public ArrayList<String> getFolders(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                
            } else if (f.isDirectory()) {
				files.add(f.getAbsolutePath());
                getFolders(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                
            } else if (f.isDirectory()) {
				files.add(f.getAbsolutePath());
                getFolders(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	public ArrayList<String> getList(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
				files.add(f.getAbsolutePath());
                getList(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
				files.add(f.getAbsolutePath());
                getList(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	
	
	public static void changeDate(String path , int year , int month , int day , int hour ,int minute , int second) {
		
		c = Calendar.getInstance();
c.set(Calendar.YEAR, year);
c.set(Calendar.MONTH, month-1);
c.set(Calendar.DAY_OF_MONTH, day-1);
c.set(Calendar.HOUR, hour);
c.set(Calendar.MINUTE, minute);
c.set(Calendar.SECOND, second);


		
if(isFile(path)) {
			
		
		
		
		

new File(path).setLastModified(c.getTimeInMillis());
		
		} else {
			
			
			if(path.endsWith("/")) {
				
				
new File(path).setLastModified(c.getTimeInMillis());
				
			} else {
				
				
new File(path+"/").setLastModified(c.getTimeInMillis());
				
			}
			
			
		}
		
		
		
	}
	
	public static String getDate(String path , String format) {
		c = Calendar.getInstance();
		if(isFile(path)) {
			
			c.setTimeInMillis(((long)new File(path).lastModified()));
			return new SimpleDateFormat(format).format(c.getTime());
			
			
		} else {
			
			if(path.endsWith("/")) {
				
				c.setTimeInMillis(((long)new File(path).lastModified()));
			return new SimpleDateFormat(format).format(c.getTime());
				
			} else {
				
				c.setTimeInMillis(((long)new File(path+"/").lastModified()));
			return new SimpleDateFormat(format).format(c.getTime());
				
			}
			
			
		}
		
		
	}
	
	public static boolean isEmpty(String path) {
		 return (new FileWareUtils().getSize(path) == 0);
	}
	
	public static boolean isFolder(String path) {

		file = new File(path);
		if(file.exists()) {
			return file.isDirectory();
		} else {
			return false;
		}
	}
	
	public static boolean isFile(String path) {
		file = new File(path);
		if(file.exists()) {
			return file.isFile();
		} else {
			return false;
		}
		
	}

	
	public static String getName(String path) {
		return Uri.parse(path).getLastPathSegment();
	}
	
	public static String getParent(String path) {
		
		
		if(isFile(path)) {
			
			return path.replace(Uri.parse(path).getLastPathSegment(),"");
			
		} else {
			
			if(path.endsWith("/")) {
				
				return path.replace("/"+Uri.parse(path).getLastPathSegment(),"");
				
			} else {
				return path.replace(Uri.parse(path).getLastPathSegment(),"");
				
			}
			
			
		}
		
		
		
		
	}
	
	public static boolean isHidden(String path) {
		return Uri.parse(path).getLastPathSegment().startsWith(".");
	}
	
	
	public static String read(String path) {
		
		//this code was fully copied from sketchware FileUtils class
		
		StringBuilder sb = new StringBuilder();
        FileReader fr = null;
        try {
            fr = new FileReader(new File(path));

            char[] buff = new char[1024];
            int length = 0;

            while ((length = fr.read(buff)) > 0) {
                sb.append(new String(buff, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
		
		
		
	}
	
	
	public static void rewrite(String text , String path) {
		
		//this code was copied from sketchware FileUtils class
		
		
		FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File(path), false);
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}
	
	
	
	
	public static void writeToOld(String text , String path) {
		
		
		//this code was copied from sketchware FileUtils class
		
		
		FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(new File(path), false);
            fileWriter.write(read(path) + text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		
		
		
	}
	
	
	
	
	public ArrayList<String> getImages(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
			
            if (f.isFile()) {
				String p = f.getAbsolutePath();
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("png").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".png") || (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("jpg").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".jpg") || Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(".jpeg").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".".concat(".jpeg")))) {
					files.add(f.getAbsolutePath());
	} else {
		
	}
				
                
            } else if (f.isDirectory()) {
                getImages(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
				String p = f.getAbsolutePath();
                if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("png").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".png") || (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("jpg").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".jpg") || Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(".jpeg").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".".concat(".jpeg")))) {
					files.add(f.getAbsolutePath());
	} else {
		
	}
            } else if (f.isDirectory()) {
                getImages(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	
	public ArrayList<String> getApk(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
			
            if (f.isFile()) {
				String p = f.getAbsolutePath();
				
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("apk").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".apk")) {
	
	files.add(f.getAbsolutePath());
	
}
                
            } else if (f.isDirectory()) {
                getApk(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
				String p = f.getAbsolutePath();
                
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("apk").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".apk")) {
	
files.add(f.getAbsolutePath());
}
				
            } else if (f.isDirectory()) {
                getApk(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	
	
	
	
	public ArrayList<String> getVideos(String path) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
			
            if (f.isFile()) {
				String p = f.getAbsolutePath();
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("mp4").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".mp4") || (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("m4a").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".m4a") || Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("3gp").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".".concat("3gb")))) {
					files.add(f.getAbsolutePath());
	} else {
		
	}
				
                
            } else if (f.isDirectory()) {
                getVideos(f.getAbsolutePath());
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
				String p = f.getAbsolutePath();
                if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("mp4").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".mp4") || (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("m4a").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".m4a") || Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat("3gp").length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals(".".concat("3gb")))) {
					files.add(f.getAbsolutePath());
	} else {
		
	}
            } else if (f.isDirectory()) {
                getVideos(f.getAbsolutePath());
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		}
		
	
	
	
	
	public ArrayList<String> getCustom(String path,String fileExtension) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
			
            if (f.isFile()) {
				String p = f.getAbsolutePath();
				
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(fileExtension).length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals("."+fileExtension)) {
	
	files.add(f.getAbsolutePath());
	
}
                
            } else if (f.isDirectory()) {
                getCustom(f.getAbsolutePath(),fileExtension);
            }
        }
		

		return files;
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
				String p = f.getAbsolutePath();
                
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(fileExtension).length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals("."+fileExtension)) {
	
files.add(f.getAbsolutePath());
}
				
            } else if (f.isDirectory()) {
                getCustom(f.getAbsolutePath(),fileExtension);
            }
        }
		return files;
		
		}
			
		}
		
		return null;
		
		
		
	}
	
	
	
	public static void deleteCustom(String path,String fileExtension) {
		
		if(path.endsWith("/")) {
		
		if(new File(path).exists()) {
			
		file = new File(path);
        File[] list = file.listFiles();
        
        for (File f : list) {
			
            if (f.isFile()) {
				String p = f.getAbsolutePath();
				
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(fileExtension).length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals("."+fileExtension)) {
	
	delete(f.getAbsolutePath());
	
}
                
            } else if (f.isDirectory()) {
                deleteCustom(f.getAbsolutePath(),fileExtension);
            }
        }
		

		
		}
		
		} else {
			
			if(new File(path+"/").exists()) {
			
		file = new File(path+"/");
        File[] list = file.listFiles();
        
        for (File f : list) {
            if (f.isFile()) {
				String p = f.getAbsolutePath();
                
				if (Uri.parse(p).getLastPathSegment().substring((int)(Uri.parse(p).getLastPathSegment().length() - ".".concat(fileExtension).length()), (int)(Uri.parse(p).getLastPathSegment().length())).equals("."+fileExtension)) {
	
delete(f.getAbsolutePath());
}
				
            } else if (f.isDirectory()) {
                deleteCustom(f.getAbsolutePath(),fileExtension);
            }
        }
		
		
		}
			
		}
		
		 
		
		
		
	}
	
	
	public static void copyFile(String path1 , String path2 , boolean fromFolder , String org) {
		
		
		if(fromFolder) {
		
		
		if(path2.endsWith("/")) {
			
			if(new File(path2+getParent(path1).replace(getParent(org),"")).exists()) {
				
			} else {
				
				
				new File(path2+getParent(path1).replace(getParent(org),"")).mkdirs();
				
			}
		
			
	
		try{
		int count;
		InputStream input = new FileInputStream(new File(path1));
		OutputStream output = new  FileOutputStream(path2+getParent(path1).replace(getParent(org),"")+getName(path1));
		byte data[] = new byte[1024];
		while ((count = input.read(data))>0) {
			output.write(data, 0, count);
		}
		output.flush();
		output.close();
		input.close();
		
		}catch(Exception e){
				
		}
		
		
		} else {
			
			
			
			
			if(new File(path2+"/"+getParent(path1).replace(getParent(org),"")).exists()) {
				
			} else {
				
				
				new File(path2+"/"+getParent(path1).replace(getParent(org),"")).mkdirs();
				
			}
		
			
	
		try{
		int count;
		InputStream input = new FileInputStream(new File(path1));
		OutputStream output = new  FileOutputStream(path2+"/"+getParent(path1).replace(getParent(org),"")+getName(path1));
		byte data[] = new byte[1024];
		while ((count = input.read(data))>0) {
			output.write(data, 0, count);
		}
		output.flush();
		output.close();
		input.close();
		
		}catch(Exception e){
				
		}
			
			
		}
		
		
		
		} else {
			
			
			
			if(path2.endsWith("/")) {
	
		try{
		int count;
		InputStream input = new FileInputStream(new File(path1));
		OutputStream output = new FileOutputStream(path2+getName(path1));
		byte data[] = new byte[1024];
		while ((count = input.read(data))>0) {
			output.write(data, 0, count);
		}
		output.flush();
		output.close();
		input.close();
		
		}catch(Exception e){
				
		}
		
		
		} else {
			
			try{
		int count;
		InputStream input = new FileInputStream(new File(path1));
		OutputStream output = new FileOutputStream(path2+"/"+getName(path1));
		byte data[] = new byte[1024];
		while ((count = input.read(data))>0) {
			output.write(data, 0, count);
		}
		output.flush();
		output.close();
		input.close();
		
		}catch(Exception e){
				
		}
			
			
		}
			
			
			
		}
		
		
		
	}
	
	
	
}