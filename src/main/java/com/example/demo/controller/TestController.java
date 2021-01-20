package com.example.demo.controller;


import com.example.demo.model.vo.Response;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author libinkai
 * @date 2020/11/1 12:57 上午
 */
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/ping/")
    public Response ping(@RequestParam(required = false) String param) {
        return Response.success(testService.ping(param));
    }

    @PostMapping("/file-upload/")
    public Response fileUpload(@RequestParam MultipartFile file) {
        return Response.success(testService.saveFile(file));
    }
}
