package ztu.education.spring_web_project.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Files {
    public static String uploadFile(MultipartFile file, String path) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }

        File uploadDir = new File(path);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String filename = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(path + "\\" + filename));

        return filename;
    }
}
