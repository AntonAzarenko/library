package library.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MetaDataController {

    @PostMapping(value = "upload.html")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String name = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                Path resourceDirectory = Paths.get("../library", "data", "zip");
                File dir = new File(resourceDirectory + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
            } catch (IOException e) {
                return "error";
            }
        }
        return "addedit";
    }
}
