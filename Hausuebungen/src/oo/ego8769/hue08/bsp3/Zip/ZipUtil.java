package oo.ego8769.hue08.bsp3.Zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	// COMENDOZEILEN paramether müssen es sein
	// Console müssen die name des files gegeben werden
	public void zip(File in_file, File out_archiv, String extension) throws IOException {
		System.out.println(out_archiv.getAbsolutePath());
		if (!out_archiv.exists()) {
			out_archiv.createNewFile();
		}
		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(out_archiv));

		zipDirectory(in_file, zipOutputStream, extension);

		zipOutputStream.flush();
		zipOutputStream.close();
	}

	private void zipDirectory(File file, ZipOutputStream zipOutputStream, String extension) throws IOException {
		if (file.isDirectory() == true) {
			for (File content : file.listFiles()) {
				// if (content.isDirectory() == true) {
				// zipDirectory(file, zipOutputStream);
				// } else {
				if (!content.isDirectory()) {
					if (extension != null) {
						if (getExtension(content).equals(extension)) {
							zipFile(content, zipOutputStream);
							// }
						}
					} else {
						zipFile(content, zipOutputStream);
					}
				}
			}
		}
	}

	private String getExtension(File file) {
		System.out.println(file.getName());
		return file.getName().split("\\.")[1];

	}

	private void zipFile(File file, ZipOutputStream zipOutputStream) throws IOException {
		System.out.println(file.getAbsolutePath());
		FileInputStream fileInputStream = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(file.getName());

		zipOutputStream.putNextEntry(zipEntry);

		byte[] buffer = new byte[4096];
		int returnValue = 0;
		while (returnValue != -1) {
			returnValue = fileInputStream.read(buffer);
			zipOutputStream.write(buffer);
			zipOutputStream.flush();
		}

		fileInputStream.close();
	}

	public void enZip(File archive, File directori) throws IOException {
		ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(archive)));
		if (!directori.exists()) {
			directori.mkdir();
		}
		enZipArcive(directori, zipInputStream);
	}

	private void enZipArcive(File directori, ZipInputStream zipInputStream) throws IOException {
		ZipEntry entry = zipInputStream.getNextEntry();

		while (entry != null) {
			File enZipFile = new File(directori.getAbsolutePath() + File.separator + entry.getName());
			System.out.println(enZipFile.getAbsolutePath());
			enZipFile.createNewFile();
			FileOutputStream fileOutputStream = null;

			try {
				fileOutputStream = new FileOutputStream(enZipFile);
				byte[] buffer = new byte[4096];
				int returnValue = 0;
				while (returnValue != -1) {
					returnValue = zipInputStream.read(buffer);// ich lese hinaus

					fileOutputStream.write(buffer);// ich schreibe hinein
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				fileOutputStream.flush();
				fileOutputStream.close();
			}

			entry = zipInputStream.getNextEntry();
		}
	}
}
