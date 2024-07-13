package com.yupi.yuojcodesandbox.controller;

import com.yupi.yuojcodesandbox.docker.JavaDockerCodeSandbox;
import com.yupi.yuojcodesandbox.nativecode.JavaNativeCodeSandbox;
import com.yupi.yuojcodesandbox.model.ExecuteCodeRequest;
import com.yupi.yuojcodesandbox.model.ExecuteCodeResponse;
import com.yupi.yuojcodesandbox.nativecode.GaddNativeCodeSandbox;
import com.yupi.yuojcodesandbox.nativecode.GccNativeCodeSandbox;
import com.yupi.yuojcodesandbox.nativecode.PythonNativeCodeSandbox;

import com.yupi.yuojcodesandbox.docker.GaddDockerCodeSandbox;
import com.yupi.yuojcodesandbox.docker.GccDockerCodeSandbox;
import com.yupi.yuojcodesandbox.docker.PythonDockerCodeSandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController("/")
public class MainController {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Resource
    private JavaNativeCodeSandbox javaNativeCodeSandbox;

    @Resource
    private JavaDockerCodeSandbox javaDockerCodeSandbox;
    
    @Resource
    private GccNativeCodeSandbox gccNativeCodeSandbox;

    @Resource
    private GccDockerCodeSandbox gccDockerCodeSandbox;

    @Resource
    private GaddNativeCodeSandbox gaddNativeCodeSandbox;

    @Resource
    private GaddDockerCodeSandbox gaddDockerCodeSandbox;

    @Resource
    private PythonNativeCodeSandbox pythonNativeCodeSandbox;

    @Resource
    private PythonDockerCodeSandbox pythonDockerCodeSandbox;
    

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }

        String language = executeCodeRequest.getLanguage();
        if(language.equals("c")) {
            return gccNativeCodeSandbox.executeCode(executeCodeRequest);
        }else if(language.equals("cpp")) {
            return gaddNativeCodeSandbox.executeCode(executeCodeRequest);
        }else if(language.equals("python")) {
            return pythonNativeCodeSandbox.executeCode(executeCodeRequest);
        }

        return javaNativeCodeSandbox.executeCode(executeCodeRequest);
    }

    /**
     * 执行代码 Docker
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCodeDocker")
    ExecuteCodeResponse executeCodeDocker(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }

        String language = executeCodeRequest.getLanguage();
        if(language.equals("c")) {
            return gccDockerCodeSandbox.executeCode(executeCodeRequest);
        }else if(language.equals("cpp")) {
            return gaddDockerCodeSandbox.executeCode(executeCodeRequest);
        }else if(language.equals("python")) {
            return pythonDockerCodeSandbox.executeCode(executeCodeRequest);
        }
        
        return javaDockerCodeSandbox.executeCode(executeCodeRequest);
    }


    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCodeGcc")
    ExecuteCodeResponse executeCodeGcc(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return gccNativeCodeSandbox.executeCode(executeCodeRequest);
    }

    /**
     * 执行代码 Docker
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCodeDockerGcc")
    ExecuteCodeResponse executeCodeDockerGcc(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return gccDockerCodeSandbox.executeCode(executeCodeRequest);
    }


    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCodePy")
    ExecuteCodeResponse executeCodePy(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return pythonNativeCodeSandbox.executeCode(executeCodeRequest);
    }

    /**
     * 执行代码 Docker
     *
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCodeDockerPy")
    ExecuteCodeResponse executeCodeDockerPy(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request,
                                    HttpServletResponse response) {
        // 基本的认证
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)) {
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null) {
            throw new RuntimeException("请求参数为空");
        }
        return pythonDockerCodeSandbox.executeCode(executeCodeRequest);
    }



}
