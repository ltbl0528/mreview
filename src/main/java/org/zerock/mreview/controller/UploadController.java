package org.zerock.mreview.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

// 실제 업로드된 파일 처리를 할 컨트롤러
@RestController
@Log4j2
public class UploadController {

    @Value("${org.zerock.upload.path}") // application.properties의 변수
    private String uploadPath;

    // 여러 파일을 동시 처리할 수 있는 메소드
    @PostMapping("/uploadAjax")
    public void uploadFile(MultipartFile[] uploadFiles) {

        for (MultipartFile uploadFile : uploadFiles) {

            // 이미지 파일만 업로드 가능 (셸 스크립트 파일 등으로 이뤄지는 공격 방지)
            if(!uploadFile.getContentType().startsWith("image")) {
                log.warn("This file is not image type");
                return;
            }

            // 실제 파일 이름 (IE나 Edge는 전체 경로가 들어오므로)
            String originalName = uploadFile.getOriginalFilename();
            String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);

            log.info("fileName: " + fileName);

            // 날짜 폴더 생성(동일한 폴더에 너무 많은 파일이 저장되는 것을 방지)
            String folderPath = makeFolder();

            // UUID (동일한 파일 이름 문제 방지)
            String uuid = UUID.randomUUID().toString();

            // 저장할 파일 이름 중간에 "_"로 구분
            String saveName = uploadPath + File.separator + folderPath + File.separator +
                    uuid + "_" + fileName;

            Path savePath = Paths.get(saveName);

            try {
                uploadFile.transferTo(savePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String makeFolder() {

        // 연/월/일 담을 문자열
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        // 폴더 만들기
        File uploadPathFolder = new File(uploadPath, folderPath);

        // 존재하지 않을 시 생성, 이미 존재하면 생성 X
        if(!uploadPathFolder.exists()) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }
}
