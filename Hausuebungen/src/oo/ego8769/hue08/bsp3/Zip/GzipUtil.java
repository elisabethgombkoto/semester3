package oo.ego8769.hue08.bsp3.Zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GzipUtil {
	public void gzip(File in_file, File out_archiv, String extension) throws IOException {
		System.out.println(out_archiv.getAbsolutePath());
		if (!out_archiv.exists()) {
			out_archiv.createNewFile();
		}
		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(out_archiv));

		gzipDirectory(in_file, gzipOutputStream, extension);

		gzipOutputStream.flush();
		gzipOutputStream.close();
	}

	private void gzipDirectory(File file, GZIPOutputStream zipOutputStream, String extension) throws IOException {
		if (file.isDirectory() == true) {
			for (File content : file.listFiles()) {
				// if (content.isDirectory() == true) {
				// zipDirectory(file, zipOutputStream);
				// } else {
				if (!content.isDirectory()) {
					if (extension != null) {
						if (getExtension(content).equals(extension)) {
							gzipFile(content, zipOutputStream);
							// }
						}
					} else {
						gzipFile(content, zipOutputStream);
					}
				}
			}
		}
	}

	private String getExtension(File file) {
		System.out.println(file.getName());
		return file.getName().split("\\.")[1];

	}

	private void gzipFile(File file, GZIPOutputStream gzipOutputStream) throws IOException {
		System.out.println(file.getAbsolutePath());
		FileInputStream fileInputStream = new FileInputStream(file);
		ZipEntry gzipEntry = new ZipEntry(file.getName());

		// gzipOutputStream.putNextEntry(gzipEntry);

		byte[] buffer = new byte[4096];
		int returnValue = 0;
		while (returnValue != -1) {
			returnValue = fileInputStream.read(buffer);
			gzipOutputStream.write(buffer);
			gzipOutputStream.flush();
		}

		fileInputStream.close();
	}

	public void enZip(File archive, File directori) throws IOException {
		ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(archive)));
		if (!directori.exists()) {
			directori.mkdir();
		}
		// enGzipArcive(directori, zipInputStream);
	}

	private void enGzipArcive(File directori, GZIPInputStream gzipInputStream) throws IOException {
		/*
		 * ZipEntry entry = gzipInputStream.getNextEntry();
		 * 
		 * while (entry != null) { File enZipFile = new
		 * File(directori.getAbsolutePath() + File.separator + entry.getName());
		 * System.out.println(enZipFile.getAbsolutePath());
		 * enZipFile.createNewFile(); FileOutputStream fileOutputStream = null;
		 * 
		 * try { fileOutputStream = new FileOutputStream(enZipFile); byte[]
		 * buffer = new byte[4096]; int returnValue = 0; while (returnValue !=
		 * -1) { returnValue = gzipInputStream.read(buffer);// ich lese //
		 * hinaus
		 * 
		 * fileOutputStream.write(buffer);// ich schreibe hinein } } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } finally { fileOutputStream.flush();
		 * fileOutputStream.close(); }
		 * 
		 * // entry = gzipInputStream.getNextEntry(); }
		 */}

}
