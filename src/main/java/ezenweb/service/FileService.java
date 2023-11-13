package ezenweb.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    //배포 전
    //final private static String FILE_ROOT_PATH = "c:\\java\\";
    //배포 후
    final private String FILE_ROOT_PATH = "C:\\Users\\504\\Desktop\\projects\\build\\resources\\main\\static\\static\\media\\";

    //배포 후

    //1 upload
    public String fileUpload(MultipartFile multipartFile)
    {
        if(multipartFile.isEmpty()){
            return null;
        }
        String fileName = UUID.randomUUID()+"_"+multipartFile.getOriginalFilename().replaceAll("_","-");
        File file = new File(FILE_ROOT_PATH+fileName);
        /*업로드*/
        try{
            multipartFile.transferTo(file);
            return fileName;
        }catch(Exception e) {
            System.out.println("fileUpload" + e);
            return null;
        }
    }

    @Autowired
    private HttpServletResponse response;
    //2 download
    public void fileDownload(String uuidFile)
    {
        String downloadFilePath = FILE_ROOT_PATH + uuidFile;
        String fileName = uuidFile.split("_")[1];
        try{

            response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
            /*서버가 해당 파일 읽어오기*/
            File file = new File(downloadFilePath);
            /*버퍼스트림을 이용한 바이트로 파일 읽기*/
            BufferedInputStream fin = new BufferedInputStream(Files.newInputStream(file.toPath()));
            /* 파일 용량만큼 바이트 배열 선언*/
            byte[] bytes = new byte[(int)file.length()];
            /* 읽어온 바이트들을 저장*/
            fin.read(bytes);
            BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
            fout.write(bytes);

            fout.flush();fout.close();fin.close();
        }catch(Exception e) {
            System.out.println("fileDownload" + e);
        }


    }
}
