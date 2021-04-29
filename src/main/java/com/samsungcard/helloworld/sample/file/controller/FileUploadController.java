package com.samsungcard.helloworld.sample.file.controller;

import com.samsungcard.helloworld.sample.file.dto.UploadFileDto;
import com.samsungcard.helloworld.sample.file.exception.StorageFileNotFoundException;
import com.samsungcard.helloworld.sample.file.service.StorageService;
import com.samsungcard.helloworld.sample.file.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class FileUploadController {
    private final StorageService storageService;
    private final UploadFileService uploadFileService;

    @GetMapping("/files")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", uploadFileService.getAll().stream()
                .map(f -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", f.getServerFileName()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "upload-file";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + uploadFileService.findOriginFileName(filename) + "\"").body(file);
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        String newFileName = storageService.store(file);

        uploadFileService.add(UploadFileDto.builder()
                .serverFileName(newFileName)
                .originFileName(file.getOriginalFilename())
                .build());

        redirectAttributes.addFlashAttribute("messages",
            String.format("%s 파일이 성공적으로 업로드 되었습니다.", file.getOriginalFilename()));

        return "redirect:/files";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
