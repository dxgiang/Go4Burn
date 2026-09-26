package com.example.go4burn.services;

import android.content.Context;

import java.io.File;

public class CacheManager {
    public long getFolderSize(File file) {
        long size = 0;
        if (file != null && file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File subFile : fileList) {
                    size += getFolderSize(subFile);
                }
            }
        } else if (file != null && file.isFile()) {
            size += file.length();
        }
        return size;
    }

    // Hàm lấy tổng kích thước Cache của ứng dụng
    public String getTotalCacheSize(Context context) {
        long cacheSize = 0;

        // Lấy kích thước bộ nhớ đệm nội bộ (Internal Cache)
        if (context.getCacheDir() != null) {
            cacheSize += getFolderSize(context.getCacheDir());
        }

        // Lấy kích thước bộ nhớ đệm bên ngoài (External Cache - nếu có)
        if (context.getExternalCacheDir() != null) {
            cacheSize += getFolderSize(context.getExternalCacheDir());
        }

        return formatSize(cacheSize);
    }

    // Hàm chuyển đổi byte sang chuỗi hiển thị định dạng KB, MB, GB
    private String formatSize(long size) {
        if (size <= 0) return "0 Bytes";
        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return String.format("%.2f %s", size / Math.pow(1024, digitGroups), units[digitGroups]);
    }

    // Hàm đệ quy xóa tệp tin và thư mục con bên trong
    public boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            if (children != null) {
                for (String child : children) {
                    boolean success = deleteDir(new File(dir, child));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        }
        return false;
    }

    // Hàm chính thực hiện xóa toàn bộ Cache ứng dụng
    public void clearAllCache(Context context) {
        try {
            // Xóa Internal Cache
            if (context.getCacheDir() != null) {
                deleteDir(context.getCacheDir());
            }
            // Xóa External Cache
            if (context.getExternalCacheDir() != null) {
                deleteDir(context.getExternalCacheDir());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
